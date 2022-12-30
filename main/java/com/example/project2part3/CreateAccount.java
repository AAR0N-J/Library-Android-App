package com.example.project2part3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.project2part3.databinding.AccountCreateBinding;

import java.util.List;

public class CreateAccount extends AppCompatActivity {
    private AccountCreateBinding binding;
    private OtterLibraryDatabase db;
    private List<Account> accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AccountCreateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = OtterLibraryDatabase.getInstance(this);

        binding.create.setOnClickListener(v -> {
            String username = binding.username.getText().toString();
            String password = binding.password.getText().toString();
            Account a = new Account(username,password);
            accounts = db.accounts().getAll();
            String message = "Success!";
            if (accounts.size() == 0){
                db.accounts().addAccount(a);
                Transaction newT = new Transaction("New account", username);
                db.transactions().addTransaction(newT);
            } else {
                boolean success = true;
                for (int i = 0; i < accounts.size(); i++) {
                    if (accounts.get(i).getUsername().equals(a.getUsername())) {
                        message = "Fail: Username \nalready exists!";
                        success = false;
                    }
                }
                if (success){
                    db.accounts().addAccount(a);
                    Transaction newT = new Transaction("New account", username);
                    db.transactions().addTransaction(newT);
                }
            }

            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
