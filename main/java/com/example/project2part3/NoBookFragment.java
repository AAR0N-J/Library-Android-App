package com.example.project2part3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import android.view.LayoutInflater;
import com.example.project2part3.databinding.DialogNoBookBinding;

public class NoBookFragment extends DialogFragment {
    private DialogNoBookBinding binding;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = DialogNoBookBinding.inflate(LayoutInflater.from(getContext()));
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(binding.getRoot())
                .setTitle("No Book Available")
                .setPositiveButton("Exit", (dialog, which) -> getActivity().finish());
        return builder.create();
    }

}