package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookDao {

        @Insert
        void addBook(Book b);

        @Query("SELECT COUNT(*) FROM Books")
        int count();

        @Query("select * from Books")
        List<Book> getAll();

        @Query("select * from Books where bookId = :id")
        Book findById(int id);

        @Query("DELETE FROM Books WHERE bookTitle = :BookTitle")
        void deleteBook(String BookTitle);

        @Query("SELECT Genre FROM Books")
        List<String> getAllGenres();

        @Query("DELETE FROM Books")
        void deleteAll();

        @Update
        void updateBook(Book b);
}

