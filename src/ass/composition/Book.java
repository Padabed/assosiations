package ass.composition;

import java.util.HashSet;
import java.util.Set;

public class Book {

    private String title;
    private Author author;

    private static Set<Book> extent = new HashSet<>();

    public Book(String title, Author author) {
        setTitle(title);
        setAuthor(author);
        extent.add(this);
    }

    public Author getAuthor() {
        return author;
    }

    private void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Class cannot exist without an author");
        }
        this.author = author;
        this.author.addBook(this);
    }

    public void removeAuthor() {
        this.author.removeBook(this);
        this.author = null;
        extent.remove(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank");
        }
        this.title = title;
    }
}
