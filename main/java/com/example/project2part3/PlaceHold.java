package com.example.project2part3;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


import com.example.project2part3.databinding.PlaceHoldBinding;

import java.util.ArrayList;
import java.util.List;


public class PlaceHold extends AppCompatActivity {
    private PlaceHoldBinding binding;
    private OtterLibraryDatabase db;
    private List<String> Genres;
    private List<String> AvailableGenres;
    private ArrayAdapter<String> GenreAdapter;
    private static int reservationNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = PlaceHoldBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = OtterLibraryDatabase.getInstance(this);

        Genres = new ArrayList<>();

        Genres.add("Memoir");
        Genres.add("Computer Science");
        Genres.add("Fiction");

        GenreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Genres);
        GenreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.playerSpinner.setAdapter(GenreAdapter);

        binding.playerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String temp = (String) binding.playerSpinner.getSelectedItem(); // gets selected Genre
                AvailableGenres = db.books().getAllGenres();
                if (!AvailableGenres.contains(temp)){
                    NoBookFragment fragment = new NoBookFragment();
                    fragment.show(getSupportFragmentManager(), "");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.submit.setOnClickListener(v -> {
            String BookTitle = binding.BookTitle.getText().toString();
            String username = binding.usernameHold.getText().toString();
            reservationNumber++;
            db.books().deleteBook(BookTitle);
            Transaction newT = new Transaction("Hold", username);
            db.transactions().addTransaction(newT);
            String message = "Customer username: "+username+"\nBook Title: "+BookTitle+"\nReservation Number: "+reservationNumber;
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
