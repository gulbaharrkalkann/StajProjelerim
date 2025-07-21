package KutuphaneSistemi;// KutuphaneSistemi.Student.java
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int id;
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
