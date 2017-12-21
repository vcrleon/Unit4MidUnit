package com.example.c4q.unit4midunit.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.c4q.unit4midunit.R;
import com.example.c4q.unit4midunit.controller.BookAdapter;
import com.example.c4q.unit4midunit.json.Books;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BottomFragment extends Fragment {
    View rootView;
    List<Books> booksList;
    RecyclerView booksRecyclerView;


    public BottomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_bottom, container, false);
        booksRecyclerView = rootView.findViewById(R.id.book_recycler_view);
        BookAdapter bookAdapter = new BookAdapter(booksList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        booksRecyclerView.setAdapter(bookAdapter);
        booksRecyclerView.setLayoutManager(linearLayoutManager);


        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("books", new JSONArray()
                            .put(new JSONObject()
                                    .put("title", "Northanger Abbey")
                                    .put("author", "Austen, Jane")
                                    .put("year", 1865))
                            .put(new JSONObject()
                                    .put("title", "War and Peace")
                                    .put("author", "Tolstoy, Leo")
                                    .put("year", 1875))
                            .put(new JSONObject()
                                    .put("title", "Anna Karenina")
                                    .put("author", "Tolstoy, Leo")
                                    .put("year", 1875))
                            .put(new JSONObject()
                                    .put("title", "Mrs. Dalloway")
                                    .put("author", "Woolf, Virginia")
                                    .put("year", 1925))
                            .put(new JSONObject()
                                    .put("title", "The Hours")
                                    .put("author", "Cunnningham, Michael")
                                    .put("year", 1999))
                            .put(new JSONObject()
                                    .put("title", "Huckleberry Finn")
                                    .put("author", "Twain, Mark")
                                    .put("year", 1865))
                            .put(new JSONObject()
                                    .put("title", "Bleak House")
                                    .put("author", "Dickens, Charles")
                                    .put("year", 1870))
                            .put(new JSONObject()
                                    .put("title", "Tom Sawyer")
                                    .put("author", "Twain, Mark")
                                    .put("year", 1862)));
        } catch (JSONException e) {
            e.printStackTrace();
        }



        return rootView;
    }

    public void JSONparse(String str) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            JSONArray jsonArray = jsonObject.getJSONArray("books");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);
                Books books = new Books();
                String bookTitle = jsonObject1.getString("title");
                String bookAuthor = jsonObject1.getString("author");
                int bookYear = jsonObject1.getInt("year");

                books.setTitle(bookTitle);
                books.setAuthor(bookAuthor);
                books.setYear(bookYear);

                booksList.add(books);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
