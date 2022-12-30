package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AccountDao {

    @Insert
    void addAccount(Account a);

    @Query("SELECT COUNT(*) FROM Accounts")
    int count();

    @Query("select * from Accounts")
    List<Account> getAll();

    @Query("select * from Accounts where AccountId = :id")
    Account findById(int id);

    @Query("DELETE FROM Accounts")
    void deleteAll();

    @Update
    void updateAccount(Account a);
}

