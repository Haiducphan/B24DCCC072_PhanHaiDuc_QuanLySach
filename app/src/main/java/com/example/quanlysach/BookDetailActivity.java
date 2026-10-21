
package com.example.quanlysach;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BookDetailActivity extends AppCompatActivity {

    TextView tvDetailTitle, tvDetailAuthor, tvDetailCategory;
    TextView tvDetailStatus, tvDetailRatingValue, tvDetailNote;

    RatingBar ratingDetail;
    Button btnMarkRead, btnBack, btnDeleteBook;

    Book book;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_book_detail);

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

        tvDetailTitle = findViewById(R.id.tvDetailTitle);
        tvDetailAuthor = findViewById(R.id.tvDetailAuthor);
        tvDetailCategory = findViewById(R.id.tvDetailCategory);
        tvDetailStatus = findViewById(R.id.tvDetailStatus);
        tvDetailRatingValue = findViewById(R.id.tvDetailRatingValue);
        tvDetailNote = findViewById(R.id.tvDetailNote);

        ratingDetail = findViewById(R.id.ratingDetail);

        btnMarkRead = findViewById(R.id.btnMarkRead);
        btnBack = findViewById(R.id.btnBack);
        btnDeleteBook = findViewById(R.id.btnDeleteBook);

        position = getIntent().getIntExtra("book_position", -1);

        if (position < 0 || position >= BookData.books.size()) {
            Toast.makeText(this, "Không tìm thấy sách",
                    Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        book = BookData.books.get(position);

        showBookDetails();

        ratingDetail.setOnRatingBarChangeListener(
                (ratingBar, rating, fromUser) -> {
                    if (fromUser) {
                        int stars = (int) rating;
                        book.setRating(stars);
                        tvDetailRatingValue.setText(stars + " / 5 sao");
                        setResult(RESULT_OK);
                    }
                }
        );

        btnMarkRead.setOnClickListener(v -> {

            book.setStatus("Đã đọc");

            showBookDetails();

            Toast.makeText(this, "Đã đánh dấu sách là Đã đọc",
                    Toast.LENGTH_SHORT).show();

            setResult(RESULT_OK);
        });

        btnBack.setOnClickListener(v -> {
            finish();
        });

        btnDeleteBook.setOnClickListener(v -> {

            new AlertDialog.Builder(BookDetailActivity.this)
                    .setTitle("Xác nhận xóa")
                    .setMessage("Bạn có chắc chắn muốn xóa sách \""
                            + book.getTitle() + "\" không?")
                    .setNegativeButton("Hủy", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .setPositiveButton("Xóa", (dialog, which) -> {

                        BookData.books.remove(book);

                        Toast.makeText(this, "Xóa sách thành công!",
                                Toast.LENGTH_SHORT).show();

                        setResult(RESULT_OK);
                        finish();
                    })
                    .show();
        });
    }

    private void showBookDetails() {

        tvDetailTitle.setText(book.getTitle());

        tvDetailAuthor.setText("Tác giả: " + book.getAuthor());

        tvDetailCategory.setText("Thể loại: "
                + book.getCategory());

        tvDetailStatus.setText("Trạng thái: "
                + book.getStatus());

        ratingDetail.setRating(book.getRating());

        tvDetailRatingValue.setText(
                book.getRating() + " / 5 sao"
        );

        String note = book.getNote();

        if (note == null || note.trim().isEmpty()) {
            tvDetailNote.setText("Chưa có ghi chú");
        } else {
            tvDetailNote.setText(note);
        }

        if (book.getStatus().equals("Đã đọc")) {

            tvDetailStatus.setTextColor(
                    Color.parseColor("#2E7D32")
            );

            btnMarkRead.setEnabled(false);
            btnMarkRead.setText("Đã đọc");

        } else {

            btnMarkRead.setEnabled(true);
            btnMarkRead.setText("Đánh dấu đã đọc");

            if (book.getStatus().equals("Đang đọc")) {
                tvDetailStatus.setTextColor(
                        Color.parseColor("#EF6C00")
                );
            } else {
                tvDetailStatus.setTextColor(
                        Color.parseColor("#78909C")
                );
            }
        }
    }
}
