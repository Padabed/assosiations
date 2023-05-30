package ass.composition;

import java.util.HashSet;
import java.util.Set;

public class Author {

    private String name;
    private Set<Book> books = new HashSet<>();

    public Author(String name) {
        setName(name);
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be a null value");
        }
        if (books.contains(book)) {
            return;
        }
        if (book.getAuthor() != this) {
            throw new IllegalArgumentException("Not related");
        }
        books.add(book);
    }

    public void removeBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Cannot remove a null value");
        }
        if (!books.contains(book)) {
            return;
        }
        if (book.getAuthor() != this) {
            throw new IllegalArgumentException("Not related");
        }
        books.remove(book);
        book.removeAuthor();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
}
