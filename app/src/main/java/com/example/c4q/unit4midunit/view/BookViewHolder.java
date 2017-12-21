package com.example.c4q.unit4midunit.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.c4q.unit4midunit.R;
import com.example.c4q.unit4midunit.json.Books;

/**
 * Created by c4q on 12/20/17.
 */

public class BookViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    TextView author;
    TextView year;

    public BookViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.book_title_view);
        author = itemView.findViewById(R.id.book_author_view);
        year = itemView.findViewById(R.id.book_year_view);

    }

    public void onBind(Books books) {
        title.setText(books.getTitle());
        author.setText(books.getAuthor());
        year.setText(books.getYear());
    }

}
