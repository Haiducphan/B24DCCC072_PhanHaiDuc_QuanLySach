
package com.example.quanlysach;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tvTotalBooks, tvReadBooks, tvUnreadBooks;
    ListView listViewBooks;
    Button btnAddBook;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );
                    v.setPadding(systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                }
        );

        tvTotalBooks = findViewById(R.id.tvTotalBooks);
        tvReadBooks = findViewById(R.id.tvReadBooks);
        tvUnreadBooks = findViewById(R.id.tvUnreadBooks);

        listViewBooks = findViewById(R.id.listViewBooks);
        btnAddBook = findViewById(R.id.btnAddBook);

        adapter = new BookAdapter(this, BookData.books);
        listViewBooks.setAdapter(adapter);

        updateStatistics();

        btnAddBook.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    AddBookActivity.class
            );
            startActivity(intent);
        });

        listViewBooks.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    BookDetailActivity.class
            );

            intent.putExtra("book_position", position);
            startActivity(intent);
        });
    }

    private void updateStatistics() {
        int total = BookData.books.size();
        int read = 0;

        for (Book book : BookData.books) {
            if (book.getStatus().equals("Đã đọc")) {
                read++;
            }
        }

        int unread = total - read;

        tvTotalBooks.setText(String.valueOf(total));
        tvReadBooks.setText(String.valueOf(read));
        tvUnreadBooks.setText(String.valueOf(unread));
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (adapter != null) {
            adapter.notifyDataSetChanged();
            updateStatistics();
        }
    }
}
