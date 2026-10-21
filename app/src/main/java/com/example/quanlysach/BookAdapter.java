package com.example.quanlysach;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Book> {

    public BookAdapter(Context context, ArrayList<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_book, parent, false);
        }

        TextView tvTitle = convertView.findViewById(R.id.tvBookTitle);
        TextView tvAuthor = convertView.findViewById(R.id.tvBookAuthor);
        TextView tvCategory = convertView.findViewById(R.id.tvBookCategory);
        TextView tvStatus = convertView.findViewById(R.id.tvBookStatus);
        TextView tvStars = convertView.findViewById(R.id.tvBookStars);

        Book book = getItem(position);

        if (book != null) {

            tvTitle.setText(book.getTitle());
            tvAuthor.setText("Tác giả: " + book.getAuthor());
            tvCategory.setText(book.getCategory());
            tvStatus.setText(book.getStatus());

            int rating = Math.max(0, Math.min(5, book.getRating()));

            StringBuilder stars = new StringBuilder();

            for (int i = 0; i < 5; i++) {
                if (i < rating) {
                    stars.append("★");
                } else {
                    stars.append("☆");
                }
            }

            tvStars.setText(stars.toString());

            if (book.getStatus().equals("Đã đọc")) {
                tvStatus.setTextColor(Color.parseColor("#2E7D32"));
            } else if (book.getStatus().equals("Đang đọc")) {
                tvStatus.setTextColor(Color.parseColor("#EF6C00"));
            } else {
                tvStatus.setTextColor(Color.parseColor("#78909C"));
            }
        }

        return convertView;
    }
}
