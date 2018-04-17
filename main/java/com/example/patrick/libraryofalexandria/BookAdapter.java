package com.example.patrick.libraryofalexandria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.patrick.libraryofalexandria.models.Book;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter implements Filterable {

    private Context mCurrentContext;

    private ArrayList<Book> mFilteredList;
    private BookFilter mFilter;

    private ArrayList<Book> mBookList;

    public BookAdapter(Context con, ArrayList<Book> book) {
        mCurrentContext = con;
        mFilteredList = null;
        mBookList = book;
        initialize_default_list();
    }

    public void initialize_default_list(){
        mBookList.add(new Book(0,"agg", "b", "c", "d", "e", "f", "g", "h"));
        mBookList.add(new Book(1, "eab", "b", "c", "d", "e", "f", "g", "h"));
        mBookList.add(new Book(2, "abc", "b", "c", "d", "e", "f", "g", "h"));
        mBookList.add(new Book(3, "bce", "b", "c", "d", "e", "f", "g", "h"));
        mBookList.add(new Book(4, "xyz", "b", "c", "d", "e", "f", "g", "h"));
        mBookList.add(new Book(5, "def", "b", "c", "d", "e", "f", "g", "h"));

        mFilteredList = mBookList;
    }

    @Override
    public int getCount() { return mFilteredList.size(); }
    @Override
    public Object getItem(int i) { return mFilteredList.get(i); }
    @Override
    public long getItemId(int i) { return i; }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Check if view already exists. If not inflate it
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mCurrentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.book_list_item, null);
        }

        TextView titleView = (TextView) view.findViewById(R.id.titleTextView);
        TextView authorView = (TextView) view.findViewById(R.id.authorTextView);

        titleView.setText(mFilteredList.get(i).getTitle());
        authorView.setText(mFilteredList.get(i).getAuthor());

        return view;
    }

    @Override
    public Filter getFilter() {
        if(mFilter == null) {
            mFilter = new BookFilter();
        }
        return mFilter;
    }

    private class BookFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            if(constraint != null && constraint.length() > 0) {
                ArrayList<Book> tempList = new ArrayList<>();
                for(Book book : mBookList) {
                    if(book.getTitle().toLowerCase().
                            contains(constraint.toString().
                                    toLowerCase()))
                        tempList.add(book);
                }
                results.count = tempList.size();
                results.values = tempList;
            }
            else {
                results.count = mBookList.size();
                results.values = mBookList;
            }
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            mFilteredList = (ArrayList<Book>) results.values;
            notifyDataSetChanged();
        }
    }
}


