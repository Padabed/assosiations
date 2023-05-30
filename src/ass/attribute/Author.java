package ass.attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Author {

    private String name;

    private Set<AuthorBook> participation = new HashSet<>();

    public Author(String name) {
        setName(name);
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
        if (authorBook.getAuthor() != this) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name can`t be null");
        }
        this.name = name;
    }

}
