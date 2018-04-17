package com.example.patrick.libraryofalexandria;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class FrontPageActivity extends AppCompatActivity {


    private Button addBook;
    private Button searchBooks;
    //private Button viewBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        addBook = (Button) findViewById(R.id.addBookButton);
        addBook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), AddBookActivity.class);
                startActivity(intent);
            }
        });

        searchBooks = (Button) findViewById(R.id.searchBookButton);
        searchBooks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SearchBooksActivity.class);
                startActivity(intent);
            }
        });
        /*
        viewBook = (Button) findViewById(R.id.ViewBookButton);
        viewBook.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Book book = new Book("a", "b", "c", "d", "e", "f", "g", "h");
                bundle.putParcelable("Book", book);
                Intent intent = new Intent(v.getContext(), ViewBookActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
*/

    }





}
