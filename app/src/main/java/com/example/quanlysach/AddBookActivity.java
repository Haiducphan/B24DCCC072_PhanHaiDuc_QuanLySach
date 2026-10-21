
package com.example.quanlysach;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddBookActivity extends AppCompatActivity {

    EditText edtBookTitle, edtBookAuthor, edtBookNote;
    Spinner spCategory;
    RadioGroup rgStatus;
    RatingBar ratingBook;
    TextView tvRatingValue;
    Button btnSaveBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_book);

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

        edtBookTitle = findViewById(R.id.edtBookTitle);
        edtBookAuthor = findViewById(R.id.edtBookAuthor);
        edtBookNote = findViewById(R.id.edtBookNote);

        spCategory = findViewById(R.id.spCategory);
        rgStatus = findViewById(R.id.rgStatus);
        ratingBook = findViewById(R.id.ratingBook);
        tvRatingValue = findViewById(R.id.tvRatingValue);
        btnSaveBook = findViewById(R.id.btnSaveBook);

        String[] categories = {
                "Văn học",
                "Khoa học",
                "Công nghệ",
                "Kỹ năng sống",
                "Khác"
        };

        ArrayAdapter<String> categoryAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        categories
                );

        categoryAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spCategory.setAdapter(categoryAdapter);

        ratingBook.setOnRatingBarChangeListener(
                (ratingBar, rating, fromUser) -> {
                    tvRatingValue.setText(
                            (int) rating + " / 5 sao"
                    );
                }
        );

        btnSaveBook.setOnClickListener(v -> {

            String title = edtBookTitle.getText()
                    .toString().trim();

            String author = edtBookAuthor.getText()
                    .toString().trim();

            String category = spCategory.getSelectedItem()
                    .toString();

            String note = edtBookNote.getText()
                    .toString().trim();

            if (title.isEmpty()) {
                edtBookTitle.setError("Vui lòng nhập tên sách");
                edtBookTitle.requestFocus();
                return;
            }

            if (author.isEmpty()) {
                edtBookAuthor.setError("Vui lòng nhập tác giả");
                edtBookAuthor.requestFocus();
                return;
            }

            String status = "Chưa đọc";

            int selectedId = rgStatus.getCheckedRadioButtonId();

            if (selectedId == R.id.rbReading) {
                status = "Đang đọc";
            } else if (selectedId == R.id.rbRead) {
                status = "Đã đọc";
            }

            int rating = (int) ratingBook.getRating();

            Book newBook = new Book(
                    title,
                    author,
                    category,
                    status,
                    rating,
                    note
            );

            BookData.books.add(newBook);

            Toast.makeText(
                    AddBookActivity.this,
                    "Thêm sách thành công!",
                    Toast.LENGTH_SHORT
            ).show();

            setResult(RESULT_OK);
            finish();
        });
    }
}
