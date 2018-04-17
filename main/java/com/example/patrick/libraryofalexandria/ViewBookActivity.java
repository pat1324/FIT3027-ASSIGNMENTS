package com.example.patrick.libraryofalexandria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.patrick.libraryofalexandria.models.Book;

public class ViewBookActivity extends AppCompatActivity {

    Book book;
    TextView titleText;
    TextView ISBNText;
    TextView authorText;
    TextView publisherText;
    TextView editionText;
    TextView pubYearText;
    TextView genreText;
    TextView descriptionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_books);

        Bundle extras = getIntent().getExtras();
        book = extras.getParcelable("Book");
        titleText = (TextView) findViewById(R.id.titleTextView);
        ISBNText = (TextView) findViewById(R.id.ISBNTextView);
        authorText = (TextView) findViewById(R.id.authorTextView);
        publisherText = (TextView) findViewById(R.id.publisherTextView);
        editionText = (TextView) findViewById(R.id.editionTextView);
        pubYearText = (TextView) findViewById(R.id.pubYearTextView);
        genreText = (TextView) findViewById(R.id.genreTextView);
        descriptionText = (TextView) findViewById(R.id.descriptionTextView);

        titleText.setText("Title: " + book.getTitle());
        ISBNText.setText("ISBN: " + book.getISBN());
        authorText.setText("Author: " + book.getAuthor());
        publisherText.setText("Publisher: " + book.getPublisher());
        editionText.setText("Edition: " + book.getEdition());
        pubYearText.setText("Publication Year: " + book.getPubYear());
        genreText.setText("Genre: " + book.getGenre());
        descriptionText.setText("Description: " + book.getDescription());
    }
}
