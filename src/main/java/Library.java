import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addBook(Book newBook) {
        books.add(newBook);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public String showAllBooks() {
        System.out.println(books);
        return books.toString();
    }

    public Book searchBookByNumber(int id) {
        for (Book searchingBook : books) {
            if (id == searchingBook.getSerialNumber()) {
                return searchingBook;
            }
        }
        return null;
    }

    public List<Book> getBookList() {
        return books;
    }
}