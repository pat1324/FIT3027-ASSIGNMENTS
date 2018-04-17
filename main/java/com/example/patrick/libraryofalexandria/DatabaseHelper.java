package com.example.patrick.libraryofalexandria;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.patrick.libraryofalexandria.models.Book;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Set Database Properties
    public static final String DATABASE_NAME = "BookDB";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Book.CREATE_STATEMENT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Book.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addBook(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Book.COLUMN_TITLE, book.getTitle());
        values.put(Book.COLUMN_ISBN, book.getISBN());
        values.put(Book.COLUMN_AUTHOR, book.getAuthor());
        values.put(Book.COLUMN_PUBLISHER, book.getPublisher());
        values.put(Book.COLUMN_EDITION, book.getEdition());
        values.put(Book.COLUMN_PUBYEAR, book.getPubYear());
        values.put(Book.COLUMN_GENRE, book.getGenre());
        values.put(Book.COLUMN_DESCRIPTION, book.getDescription());
        db.insert(Book.TABLE_NAME, null, values);
        db.close();
    }

    public HashMap<Long, Book> getAllBooks() {
        HashMap<Long, Book> books = new LinkedHashMap<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Book.TABLE_NAME, null);
        // Add each person to hashmap (Each row has 1 person)
        while (cursor.moveToNext()) {
            Book book = new Book(cursor.getLong(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6),
                    cursor.getString(7),
                    cursor.getString(8));
            books.put(book.getId(), book);
        }
        cursor.close();
        db.close();
        if(books.size() == 0) {
            // If there are no people in the db then add some default people
            createDefaultPeople();
            books = getAllBooks();
        }
        return books;
    }

    public void removeBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Book.TABLE_NAME,
                Book.COLUMN_ID + " = ?",
                new String[] {String.valueOf(book.getId())});
    }

    private void createDefaultPeople()
    {
        addBook(new Book(0,"agg", "b", "c", "d", "e", "f", "g", "h"));
        addBook(new Book(1, "eab", "b", "c", "d", "e", "f", "g", "h"));
        addBook(new Book(2, "abc", "b", "c", "d", "e", "f", "g", "h"));
        addBook(new Book(3, "bce", "b", "c", "d", "e", "f", "g", "h"));
        addBook(new Book(4, "xyz", "b", "c", "d", "e", "f", "g", "h"));
        addBook(new Book(5, "def", "b", "c", "d", "e", "f", "g", "h"));
    }

}
