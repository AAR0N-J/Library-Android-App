package com.example.project2part3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Transactions")
public class Transaction {

    public int getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(int transactionId) {
        TransactionId = transactionId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    @PrimaryKey(autoGenerate = true)
    private int TransactionId;

    @ColumnInfo
    private String Type;

    @ColumnInfo
    private String Username;


    public Transaction(String Type, String Username) {
        this.Username = Username;
        this.Type = Type;
    }

    @Override
    public String toString() {
        return "Transaction Type: "+Type+"\nCustomer's username: "+Username+"\n";
    }
}

