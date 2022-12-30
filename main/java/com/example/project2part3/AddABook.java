package com.example.project2part3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.project2part3.databinding.DialogActivityAddAbookBinding;

import java.util.List;

public class AddABook extends DialogFragment {
    private DialogActivityAddAbookBinding binding;
    private OtterLibraryDatabase db;
    private List<Book> books;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = DialogActivityAddAbookBinding.inflate(LayoutInflater.from(getContext()));
        db = OtterLibraryDatabase.getInstance(getActivity());
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot())
                .setTitle("Add Book")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String newBookTitle = binding.addBookAdmin.getText().toString();
                        String newBookAuthor = binding.addAuthor.getText().toString();
                        String newBookGenre = binding.addGenre.getText().toString();
                        Book newBook = new Book (newBookTitle, newBookAuthor, newBookGenre);
                        books = db.books().getAll();
                        if (books.contains(newBook)){
                            Toast.makeText(getActivity(), "Fail: Book Already\nExists in system", Toast.LENGTH_SHORT);
                        } else {
                            db.books().addBook(newBook);
                            Toast.makeText(getActivity(), "Success!", Toast.LENGTH_SHORT);
                            getActivity().finish();
                        }
                    }
                })
                .setNeutralButton("Cancel", ((dialog, which) -> { }));
        return builder.create();
    }
}