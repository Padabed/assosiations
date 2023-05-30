package ass.composition;

public class Main {

    public static void main(String[] args) {

        Author author = new Author("Arnold");
        Book book = new Book("Story", author);
        Book story = new Book("Book", author);

        author.addBook(book);
        author.addBook(story);

        author.removeBook(book);
        story.removeAuthor();

        if (!author.getBooks().isEmpty() || story.getAuthor() != null || book.getAuthor() != null) {
            System.out.println("Test failed - composition");
        } else {
            System.out.println("Test passed - composition");
        }
    }

}
