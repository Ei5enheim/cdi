package com.jee.cdi.model;

public class Book {

    public Book ()
    {

    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public static String getTitle() {
        return title;
    }

    public static void setTitle(String title) {
        Book.title = title;
    }

    private static String title;
    private static String author;

    public static String getAuthor() {
        return author;
    }

    public static void setAuthor(String author) {
        Book.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    private String isbn;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", number='").append(isbn).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
