
package com.example.quanlysach;

import java.util.ArrayList;

public class BookData {

    public static final ArrayList<Book> books = new ArrayList<>();

    static {
        books.add(new Book(
                "Lập trình Android cơ bản",
                "Nguyễn Văn A",
                "Công nghệ",
                "Đang đọc",
                4,
                "Sách dành cho người mới bắt đầu."
        ));

        books.add(new Book(
                "Đắc nhân tâm",
                "Dale Carnegie",
                "Kỹ năng sống",
                "Đã đọc",
                5,
                ""
        ));

        books.add(new Book(
                "Dế Mèn phiêu lưu ký",
                "Tô Hoài",
                "Văn học",
                "Chưa đọc",
                0,
                ""
        ));
    }
}
