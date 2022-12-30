package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;


import com.example.project2part3.databinding.SystemManageBinding;

import java.util.List;

public class ManageSystem extends AppCompatActivity {
    private SystemManageBinding binding;
    private OtterLibraryDatabase db;
    private List<Transaction> Transactions;
    private ListView TransactionsListView;
    private ArrayAdapter<Transaction> transactionAdapter;
    private DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SystemManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = OtterLibraryDatabase.getInstance(this);
        dialogFragment = new AddABook();


        Transactions = db.transactions().getAll();

        TransactionsListView = binding.TransactionList;
        if (transactionAdapter == null) {
            transactionAdapter = new ArrayAdapter<>(this, R.layout.item_transaction,  R.id.transaction_item, Transactions);
            TransactionsListView.setAdapter(transactionAdapter);
        } else {
            transactionAdapter.clear();
            transactionAdapter.addAll(Transactions);
            transactionAdapter.notifyDataSetChanged();
        }

        AddABook fragment = new AddABook();
        binding.yes.setOnClickListener(v ->
            fragment.show(getSupportFragmentManager(), "")
        );

        binding.no.setOnClickListener(v-> {
            finish();
        });

    }
    @Override
    protected void onResume() {
        updateUI();
        super.onResume();
    }

    private void updateUI() {
        Transactions = db.transactions().getAll();
        if (transactionAdapter == null) {
            transactionAdapter = new ArrayAdapter<>(this, R.layout.item_transaction,  R.id.transaction_item, Transactions);
            TransactionsListView.setAdapter(transactionAdapter);
        } else {
            transactionAdapter.clear();
            transactionAdapter.addAll(Transactions);
            transactionAdapter.notifyDataSetChanged();
        }
    }
}
