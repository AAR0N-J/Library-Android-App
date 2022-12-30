package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDao {

    @Insert
    void addTransaction(Transaction t);

    @Query("SELECT COUNT(*) FROM Transactions")
    int count();

    @Query("select * from Transactions")
    List<Transaction> getAll();

    @Query("select * from Transactions where TransactionId = :id")
    Transaction findById(int id);

    @Query("DELETE FROM Transactions")
    void deleteAll();

    @Update
    void updateTransaction(Transaction t);
}

