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
        for (Book book : books) {
            if (bookID == book.getSerialNumber()) {
                book.setBookStatus(Status.RENT);
                book.setWhoHasBook(userID);

            }
        }
    }

    public void returnBook(int bookID, int userID) {
        for (int i = 0; i < books.size(); i++) {
            if (bookID == books.get(i).getSerialNumber()) {
                books.get(i).setBookStatus(Status.AVAILABLE);
                books.get(i).setWhoHasBook(0);
            }
        }
    }

    public String showAllBooks() {
        System.out.print(books);
        return books.toString();
    }

    public String showAllBookStatus() {
        String statusBook="";
        for (int i = 0; i < books.size(); i++) {
            statusBook = statusBook + books.get(i).getBookStatus() + " ";
        }
        return statusBook;
    }

    public String showWhoHasBook() {
        String whoHasBook="";
        for (int i = 0; i < books.size(); i++) {
            whoHasBook = whoHasBook + books.get(i).getWhoHasBook() + " ";
        }
        return whoHasBook;
    }


    public List<Book> getBookList() {
        return books;
    }

    public List<User> getUserList() {
        return users;
    }
}

enum Status {
    AVAILABLE,
    RENT
}