package com.example.project2part3;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Account.class, Book.class, Transaction.class}, version=4, exportSchema = false)
public abstract class OtterLibraryDatabase extends RoomDatabase {
    private static  OtterLibraryDatabase sInstance;
    public abstract AccountDao accounts();
    public abstract BookDao books();
    public abstract TransactionDao transactions();

    public static synchronized OtterLibraryDatabase getInstance(Context context) {

        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            OtterLibraryDatabase.class, "Library.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;

    }

    public void populateInitialData() {
        runInTransaction(() -> {
            if (accounts().count() > 0) {
                accounts().deleteAll();
            }
            accounts().addAccount(new Account("!admin2", "!admin2"));
            accounts().addAccount(new Account("anton", "t3nn1sch@mp22"));
            accounts().addAccount(new Account("bernie", "thyr01dExp3rt"));
            accounts().addAccount(new Account("shirleybee", "carmel2chicago"));
            if (books().count() > 0) {
                books().deleteAll();
            }
            books().addBook(new Book("Angela's Ashes","Frank McCourt", "Memoir"));
            books().addBook(new Book("Strengthening Deep Neural Networks", "Katy Warr", "Computer Science"));
            books().addBook(new Book("Frankenstein", "Mary Shelley", "Fiction"));
            if (transactions().count() > 0){
                transactions().deleteAll();
            }
        });
    }
}