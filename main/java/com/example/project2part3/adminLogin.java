package com.example.project2part3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.project2part3.databinding.AdminLoginBinding;
import java.util.List;

public class adminLogin extends DialogFragment {
    private AdminLoginBinding binding;
    private OtterLibraryDatabase db;
    private List<Account> accounts;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = AdminLoginBinding.inflate(LayoutInflater.from(getContext()));
        db = OtterLibraryDatabase.getInstance(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(binding.getRoot())
                .setTitle("Admin Login")
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String usernameAdmin = binding.usernameAdmin.getText().toString();
                        String passwordAdmin = binding.passwordAdmin.getText().toString();
                        accounts = db.accounts().getAll();
                        Account a = new Account(usernameAdmin,passwordAdmin);
                        if (a.getUsername().equals("!admin2") && a.getPassword().equals("!admin2")){
                            startActivity(new Intent(getActivity(), ManageSystem.class));
                        } else {
                            String message = "Incorrect Admin Login";
                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNeutralButton("Cancel", ((dialog, which) -> { }));
        return builder.create();
    }
}
