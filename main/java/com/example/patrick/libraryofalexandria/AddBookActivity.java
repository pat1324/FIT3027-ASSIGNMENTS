package com.example.patrick.libraryofalexandria;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.patrick.libraryofalexandria.models.Book;

public class AddBookActivity extends AppCompatActivity {

    private Button saveButton;
    private Button updateButton;
    private EditText titleEditText;
    private EditText ISBNEditText;
    private EditText authorEditText;
    private EditText publisherEditText;
    private EditText editionEditText;
    private EditText pubYearEditText;
    private EditText genreEditText;
    private EditText descriptionEditText;
    private Book book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        ISBNEditText = (EditText) findViewById(R.id.ISBNEditText);
        authorEditText = (EditText) findViewById(R.id.authorEditText);
        publisherEditText = (EditText) findViewById(R.id.publisherEditText);
        editionEditText = (EditText) findViewById(R.id.editionEditText);
        pubYearEditText = (EditText) findViewById(R.id.pubYearEditText);
        genreEditText = (EditText) findViewById(R.id.genreEditText);
        descriptionEditText = (EditText) findViewById(R.id.descriptionEditText);

        saveButton = (Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String ISBN = ISBNEditText.getText().toString();
                String author = authorEditText.getText().toString();
                String publisher = publisherEditText.getText().toString();
                String edition = editionEditText.getText().toString();
                String pubYear = pubYearEditText.getText().toString();
                String genre = genreEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                if (title.length() > 0){
                    book = new Book(0, title, ISBN, author, publisher, edition, pubYear, genre, description);
                    // Create new intent, pass information & finish
                    Intent intent = new Intent();
                    intent.putExtra("result", book);
                    setResult(RESULT_OK, intent);
                    finish();
                }


/*
                AlertDialog alertDialog = new AlertDialog.Builder(AddBookActivity.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Book: " + title + " has been successfully created!");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

                */
            }
        });

        updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (book != null) {

                    String title = titleEditText.getText().toString();
                    String ISBN = ISBNEditText.getText().toString();
                    String author = authorEditText.getText().toString();
                    String publisher = publisherEditText.getText().toString();
                    String edition = editionEditText.getText().toString();
                    String pubYear = pubYearEditText.getText().toString();
                    String genre = genreEditText.getText().toString();
                    String description = descriptionEditText.getText().toString();

                    if (title != book.getTitle()) {
                        book.setTitle(title);
                    }

                    if (ISBN != book.getISBN()) {
                        book.setISBN(ISBN);
                    }

                    if (author != book.getAuthor()) {
                        book.setAuthor(author);
                    }

                    if (publisher != book.getPublisher()) {
                        book.setPublisher(publisher);
                    }

                    if (edition != book.getEdition()) {
                        book.setEdition(edition);
                    }

                    if (pubYear != book.getPubYear()) {
                        book.setPubYear(pubYear);
                    }

                    if (genre != book.getGenre()) {
                        book.setGenre(genre);
                    }

                    if (description != book.getDescription()) {
                        book.setDescription(description);
                    }
                }
            }
        });
    }

}

