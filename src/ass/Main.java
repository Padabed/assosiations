package ass;

import ass.attribute.Author;
import ass.attribute.AuthorBook;
import ass.attribute.Book;
import ass.basic.Bank;
import ass.basic.Employee;
import ass.qualified.Item;
import ass.qualified.Product;
import ass.composition.*;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        //--//--//--//--//--//--//--BASIC--//--//--//--//--//--//--//

        Bank bank = new Bank("Idea", "Corda 8");
        Employee e1 = new Employee("Kris", "Negar", 20);
        Employee e2 = new Employee("Andrew", "Scot", 47);

        bank.addEmployee(e1);
        e2.setBank(bank);

        if (e1.getBank() == null || e2.getBank() == null || bank.getEmployees().isEmpty()) {
            System.out.println("Test failed - basic ass");
        } else {
            System.out.println("Test passed - basic ass");
        }

        bank.addEmployee(e2);
        e2.setBank(bank);

        e1.removeBank();
        bank.removeEmployee(e2);;

        if (e1.getBank() != null || e2.getBank() != null || !bank.getEmployees().isEmpty()) {
            System.out.println("Test failed - basic ass");
        } else {
            System.out.println("Test passed - basic ass");
        }

        //--//--//--//--//--//--//--ATTRIBUTE--//--//--//--//--//--//--//

        Author author = new Author("Kirill");
        Book book = new Book("Idea");
        AuthorBook participation = new AuthorBook(
                LocalDate.of(2022,10,23),
                LocalDate.of(2023,10,23),
                book, author);

        author.removeParticipation(participation);

        if (!author.getParticipation().isEmpty() || !book.getParticipation().isEmpty()
                || participation.getBook() != null || participation.getAuthor() != null) {
            System.out.println("Test failed - attribute ass");
        } else {
            System.out.println("Test passed - attribute ass");
        }

        participation = new AuthorBook(
                LocalDate.of(2022,10,23),
                LocalDate.of(2023,10,23),
                book, author);

        participation.remove();

        if (!author.getParticipation().isEmpty() || !book.getParticipation().isEmpty()
                || participation.getBook() != null || participation.getAuthor() != null) {
            System.out.println("Test failed - attribute ass");
        } else {
            System.out.println("Test passed - attribute ass");
        }

        //--//--//--//--//--//--//--COMPOSITION--//--//--//--//--//--//--//

        ass.composition.Main.main(new String[]{});

        //--//--//--//--//--//--//--QUALIFIED--//--//--//--//--//--//--//

        Item i1 = new Item("Grey", "Gys");
        Item i2 = new Item("Gys", "Grey");

        Product product = new Product("Drinks&Animals");

        product.addItem(i2);
        i1.setProduct(product);

        boolean exists = product.getItemByKey("Grey") != null;

        product.removeItem(i1);
        i2.removeProduct();

        if (!product.getItems().isEmpty() || i1.getProduct() != null || i2.getProduct() != null || !exists) {
            System.out.println("Test failed - qualified ass");
        } else {
            System.out.println("Test passed - qualified ass");
        }

        try {
            Item i3 = new Item("Gys", "Black");
        } catch (IllegalArgumentException e) {
            try {
                product.addItem(new Item("Grey", "White"));
            } catch (IllegalArgumentException ex) {
                System.out.println("Test passed - qualified ass");
                return;
            }
            System.out.println("Test failed - qualified ass");
        }

    }

}
