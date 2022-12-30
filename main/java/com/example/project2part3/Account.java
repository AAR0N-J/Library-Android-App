package com.example.project2part3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Accounts")
public class Account {

    @PrimaryKey(autoGenerate = true)
    private int AccountId;

    @ColumnInfo
    private String Username;

    @ColumnInfo
    private String Password;


    public Account(String Username, String Password) {
        this.Username = Username;
        this.Password = Password;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

