package KutuphaneSistemi;// KutuphaneSistemi.Library.java
import java.util.*;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Student> students = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
    }

    public void addStudent(Student student) {
        students.put(student.getId(), student);
    }

    public Book getBook(int id) {
        return books.get(id);
    }

    public Student getStudent(int id) {
        return students.get(id);
    }

    public boolean borrowBook(int studentId, int bookId) {
        Book book = books.get(bookId);
        Student student = students.get(studentId);
        if (book != null && student != null && book.isAvailable()) {
            book.setAvailable(false);
            student.borrowBook(book);
            return true;
        }
        return false;
    }

    public void listBooks() {
        for (Book book : books.values()) {
            System.out.println(book.getId() + ": " + book.getTitle() + " (" + (book.isAvailable() ? "Uygun" : "Ödünçte") + ")");
        }
    }

    public void showStudentHistory(int studentId) {
        Student student = students.get(studentId);
        if (student != null) {
            System.out.println(student.getName() + " kitap geçmişi:");
            for (Book book : student.getBorrowedBooks()) {
                System.out.println("- " + book.getTitle());
            }
        }
    }
    public boolean returnBook(int studentId, int bookId) {
        Book book = books.get(bookId);
        Student student = students.get(studentId);
        if (book != null && student != null && !book.isAvailable() && student.getBorrowedBooks().contains(book)) {
            book.setAvailable(true);
            student.returnBook(book);
            return true;
        }
        return false;
    }
}


