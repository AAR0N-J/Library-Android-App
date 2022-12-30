package com.example.project2part3;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Books")
public class Book {
    public int getBookId() {
        return BookId;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    @PrimaryKey(autoGenerate = true)
    private int BookId;

    @ColumnInfo
    private String bookTitle;

    @ColumnInfo
    private String Author;

    @ColumnInfo
    private String Genre;



    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public Book(String bookTitle, String Author, String Genre) {
        this.bookTitle = bookTitle;
        this.Author = Author;
        this.Genre = Genre;
    }

    @Override
    public String toString() {
        return bookTitle;
    }
}