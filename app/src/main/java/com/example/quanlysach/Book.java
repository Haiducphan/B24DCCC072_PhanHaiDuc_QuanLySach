
package com.example.quanlysach;

public class Book {

    private String title;
    private String author;
    private String category;
    private String status;
    private int rating;
    private String note;

    public Book(String title, String author, String category,
                String status, int rating, String note) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
        this.rating = rating;
        this.note = note;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getStatus() {
        return status;
    }

    public int getRating() {
        return rating;
    }

    public String getNote() {
        return note;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
