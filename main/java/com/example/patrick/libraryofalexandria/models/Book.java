package com.example.patrick.libraryofalexandria.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Patrick on 28/02/2018.
 */

public class Book implements Parcelable{

    // Database Constants
    public static final String TABLE_NAME = "books";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ISBN = "ISBN";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_PUBLISHER = "publisher";
    public static final String COLUMN_EDITION = "edition";
    public static final String COLUMN_PUBYEAR = "pubyear";
    public static final String COLUMN_GENRE = "genre";
    public static final String COLUMN_DESCRIPTION = "description";

    // Table create statement
    public static final String CREATE_STATEMENT = "CREATE TABLE "
            + TABLE_NAME + "(" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            COLUMN_TITLE + " TEXT NOT NULL, " +
            COLUMN_ISBN + " TEXT NOT NULL" +
            COLUMN_AUTHOR + " TEXT NOT NULL, " +
            COLUMN_PUBLISHER + " TEXT NOT NULL, " +
            COLUMN_EDITION + " TEXT NOT NULL, " +
            COLUMN_PUBYEAR + " TEXT NOT NULL, " +
            COLUMN_GENRE + " TEXT NOT NULL, " +
            COLUMN_DESCRIPTION + " TEXT NOT NULL, " +
            ")";


    private long _id;
    private String title;
    private String ISBN;
    private String author;
    private String publisher;
    private String edition;
    private String pubYear;
    private String genre;
    private String description;

    public Book(long id, String bName, String bISBN, String bAuthor, String bPublisher,
                String bEdition, String bPubYear, String bGenre, String bDescription){
        this._id = id;
        this.title = bName;
        this.ISBN = bISBN;
        this.author = bAuthor;
        this.publisher = bPublisher;
        this.edition = bEdition;
        this.pubYear = bPubYear;
        this.genre = bGenre;
        this.description = bDescription;
    }

    protected Book(Parcel in) {
        _id = in.readLong();
        title = in.readString();
        ISBN = in.readString();
        author = in.readString();
        publisher = in.readString();
        edition = in.readString();
        pubYear = in.readString();
        genre = in.readString();
        description = in.readString();
    }

    public void setTitle(String newName) {
        this.title = newName;
    }
    public String getTitle(){
        return this.title;
    }

    public void setISBN(String newISBN) {
        this.ISBN = newISBN;
    }
    public String getISBN(){
        return this.ISBN;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }
    public String getAuthor(){
        return this.author;
    }

    public void setPublisher(String newPublisher) {
        this.publisher = newPublisher;
    }
    public String getPublisher(){
        return this.publisher;
    }

    public void setEdition(String newEdition) {
        this.edition = newEdition;
    }
    public String getEdition(){
        return this.edition;
    }

    public void setPubYear(String newPubYear) {
        this.pubYear = newPubYear;
    }
    public String getPubYear(){
        return this.pubYear;
    }

    public void setGenre(String newGenre) {
        this.genre = newGenre;
    }
    public String getGenre(){
        return this.genre;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    public String getDescription(){
        return this.description;
    }

    public String bookSummary(){
        return "Title: " + title + ", ISBN: " + ISBN + ", Author: " + author + ", Publisher: "
                + publisher + ", Edition: " + edition + ", Year of Publication: " + pubYear + ", Genre: " + genre
                 + ", Description: " + description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(_id);
        parcel.writeString(title);
        parcel.writeString(ISBN);
        parcel.writeString(author);
        parcel.writeString(publisher);
        parcel.writeString(edition);
        parcel.writeString(pubYear);
        parcel.writeString(genre);
        parcel.writeString(description);

    }

    public long getId() { return _id; }
    public void setId(long _id) { this._id = _id; }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

}
