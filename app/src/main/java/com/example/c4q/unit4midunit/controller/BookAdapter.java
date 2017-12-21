package com.example.c4q.unit4midunit.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.unit4midunit.R;
import com.example.c4q.unit4midunit.json.Books;
import com.example.c4q.unit4midunit.view.BookViewHolder;

import java.util.List;

/**
 * Created by c4q on 12/20/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookViewHolder> {

    private List<Books> booksList;

    public BookAdapter(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_views, parent, false);
        return new BookViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Books books = booksList.get(position);
        holder.onBind(books);

    }

    @Override
    public int getItemCount() {
        return booksList.size();
    }

}
