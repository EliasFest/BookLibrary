/*import java.util.HashMap;

public class Library {
    private HashMap<Integer, Book> books = new HashMap();
    private HashMap<Integer, User> users = new HashMap();

    public void addBook(Book newBook) {
        books.put(newBook.getSerialNumber(), newBook);
    }

    public void addUser(User newUser) {
        users.put(newUser.getUserNumber(), newUser);
    }

    public void takeBook(int bookID, int userID) {
        Book rentBook = books.get(bookID);
        rentBook.setBookStatus(Status.RENT);
        rentBook.setWhoHasBook(userID);
    }

    public void returnBook(int bookID, int userID) {
        Book returnedBook = books.get(bookID);
        returnedBook.setBookStatus(Status.AVAILABLE);
        returnedBook.setWhoHasBook(0);
    }

    public String showAllBooks() {
        System.out.print(books);
        return books.toString();
    }

    public String showAllBookStatus() {
        String statusBook = "";
        for (Book book : books.values()) {
            statusBook = statusBook + book.getBookStatus() + " ";
        }
        return statusBook;
    }

    public String showWhoHasBook() {
        String whoHasBook = "";
        for (Book book : books.values()) {
            whoHasBook = whoHasBook + book.getWhoHasBook() + " ";
        }
        return whoHasBook;
    }

    public HashMap<Integer, Book> getBookMap() {
        return books;
    }

    public HashMap<Integer, User> getUserMap() {
        return users;
    }
}

enum Status {
    AVAILABLE,
    RENT
} */