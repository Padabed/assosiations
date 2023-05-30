package ass.attribute;

import java.time.LocalDate;

public class AuthorBook {

    private LocalDate startDate;
    private LocalDate endDate;

    private Author author;
    private Book book;

    public AuthorBook(LocalDate startDate, LocalDate endDate, Book book, Author author) {
        setStartDate(startDate);
        setEndDate(endDate);
        setBook(book);
        setAuthor(author);
    }

    public Author getAuthor() {
        return author;
    }

    private void setAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.author = author;
        this.author.addParticipation(this);
    }

    public Book getBook() {
        return book;
    }

    private void setBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        this.book = book;
        this.book.addParticipation(this);
    }

    public void remove() {

        if (this.book != null) {
            Book b = this.book;
            this.book = null;
            b.removeParticipation(this);
        }

        if (this.author != null) {
            Author a = this.author;
            this.author = null;
            a.removeParticipation(this);
        }

    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }
        if (endDate != null && startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date cannot be after end date");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            this.endDate = null;
            return;
        }
        if (startDate != null && endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        this.endDate = endDate;
    }
}
