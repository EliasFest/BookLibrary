import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void AddBookTest() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", "vorhanden"));
        int expected = 99775522;

        Book book = library.getBookList().get(0);
        assertEquals(expected, book.getSerialNumber());
    }

    @Test
    public void AddUserTest() {
        Library library = new Library();
        library.addUser(new User(442211, "Elias"));
        int expected = 442211;

        User user = library.getUserList().get(0);
        assertEquals(expected, user.getUserNumber());
    }

    @Test
    public void showAllBooksTest() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", "vorhanden"));
        library.showAllBooks();
        String expected = "99775522, No Longer Human";

        String printed = library.getBookList().get(0).toString();
        assertEquals(expected, printed);
    }

    @Test
    public void findBookByNumber() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", "vorhanden"));
        library.addBook(new Book(22557799, "The Setting Sun", "vorhanden"));

        Book foundBook = library.searchBookByNumber(99775522);
        String expected = "No Longer Human";

        assertEquals(expected, foundBook.getBookName());

    }

    @Test
    public void bookByNumberNotAvailable() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", "vorhanden"));
        library.addBook(new Book(22557799, "The Setting Sun", "vorhanden"));

        Book foundBook = library.searchBookByNumber(1);

        assertEquals(null, foundBook);
    }
}