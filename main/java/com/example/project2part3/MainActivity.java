package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.project2part3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private OtterLibraryDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = OtterLibraryDatabase.getInstance(MainActivity.this);
        db.populateInitialData();

        binding.create.setOnClickListener(v ->startActivity(new Intent(this, CreateAccount.class)));

        binding.hold.setOnClickListener(v ->startActivity(new Intent(this, PlaceHold.class)));


        adminLogin fragment = new adminLogin();
        binding.manage.setOnClickListener(v -> fragment.show(getSupportFragmentManager(), ""));

    }
}