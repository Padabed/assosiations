package ass.attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Book {

    private String title;

    private Set<AuthorBook> participation = new HashSet<>();

    public Book(String title) {
        setTitle(title);
    }

    public Set<AuthorBook> getParticipation() {
        return Collections.unmodifiableSet(participation);
    }

    public void addParticipation(AuthorBook authorBook) {
        if (authorBook == null) {
            throw new IllegalArgumentException("Participation cannot be null");
        }
        if (participation.contains(authorBook)) {
            return;
        }
        if (authorBook.getBook() != this) {
            throw new IllegalArgumentException("Not related");
        }
        participation.add(authorBook);
    }

    public void removeParticipation(AuthorBook authorBook) {
        if (authorBook == null) {
            return;
        }
        if (!this.participation.contains(authorBook)) {
            return;
        }
        participation.remove(authorBook);
        authorBook.remove();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Can`t be null");
        }
        this.title = title;
    }

}
