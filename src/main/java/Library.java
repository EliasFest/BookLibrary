import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book newBook) {
        books.add(newBook);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }

    public Book searchBookByNumber(int id) {
        for (Book searchingBook : books) {
            if (id == searchingBook.getSerialNumber()) {
                return searchingBook;
            }
        }
        return null;
    }

    public void takeBook(int bookID, int userID) {
        for (int i = 0; i < books.size(); i++) {
            if (bookID == books.get(i).getSerialNumber()) {
                books.get(i).setBookStatus("Ausgeliehen");
                books.get(i).setWhoHasBook(userID);
            }
        }
    }

    public void returnBook(int bookID, int userID) {
        for (int i = 0; i < books.size(); i++) {
            if (bookID == books.get(i).getSerialNumber()) {
                books.get(i).setBookStatus("Vorhanden");
                books.get(i).setWhoHasBook(0);
            }
        }
    }

    public String showAllBooks() {
        System.out.print(books);
        return books.toString();
    }

    public void showAllBookStatus() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).getBookStatus() + " ");
        }
    }

    public void showWhoHasBook() {
        for (int i = 0; i < books.size(); i++) {
            System.out.print(books.get(i).getWhoHasBook() + " ");
        }
    }

    public List<Book> getBookList() {
        return books;
    }

    public List<User> getUserList() {
        return users;
    }
}