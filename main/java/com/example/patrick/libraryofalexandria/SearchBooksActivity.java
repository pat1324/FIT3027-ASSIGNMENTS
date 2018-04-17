package com.example.patrick.libraryofalexandria;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.patrick.libraryofalexandria.models.Book;

import java.util.ArrayList;

public class SearchBooksActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    // Unique Identifier for receiving activity result
    public static final int ADD_BOOK_REQUEST = 1;

    private ListView bookListView;
    private BookAdapter bookAdapter;
    private ArrayList<Book> bookList;
    public SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_books);
        bookList = new ArrayList<>();
        bookListView = (ListView) findViewById(R.id.bookListView);
        bookAdapter = new BookAdapter(this, bookList);
        bookListView.setAdapter(bookAdapter);
        updateBookCount();

        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle bundle = new Bundle();
                Book book = bookList.get(position);
                bundle.putParcelable("Book", book);
                Intent intent = new Intent(view.getContext(), ViewBookActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager manager = (SearchManager)
                getSystemService(Context.SEARCH_SERVICE);
        MenuItem searchItem = menu.findItem(R.id.search);

        //SearchView mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        mSearchView = (SearchView) searchItem.getActionView();

        mSearchView.setSearchableInfo(manager.
                getSearchableInfo(getComponentName()));
        mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setOnQueryTextListener(this);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        bookAdapter.getFilter().filter(newText);
        return true;
    }


    public void updateBookCount(){
        int nbooks = bookList.size();
        setTitle("Number of books: " + nbooks);
    }


}
