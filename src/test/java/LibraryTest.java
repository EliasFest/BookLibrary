import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void AddBookTest() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", Status.AVAILABLE));
        int expected = 99775522;

        Book book = library.getBookList().get(0);
        assertEquals(expected, book.getSerialNumber());
    }

    @Test
    public void AddUserTest() {
        Library library = new Library();
        library.addUser(new User(442211, "Elias"));
        String expected = "[442211 Elias]";

        String user = library.getUserList().toString();
        assertEquals(expected, user);
    }

    @Test
    public void getBookListTest() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", Status.AVAILABLE));
        library.addBook(new Book(26263787, "test", Status.AVAILABLE));
        library.showAllBooks();
        String expected = "[99775522 No Longer Human, 26263787 test]";

        String printed = library.getBookList().toString();
        assertEquals(expected, printed);
    }

    @Test
    public void findBookByNumber() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", Status.AVAILABLE));
        library.addBook(new Book(22557799, "The Setting Sun", Status.AVAILABLE));

        Book foundBook = library.searchBookByNumber(99775522);
        String expected = "No Longer Human";

        assertEquals(expected, foundBook.getBookName());

    }

    @Test
    public void bookByNumberNotAvailable() {
        Library library = new Library();
        library.addBook(new Book(99775522, "No Longer Human", Status.AVAILABLE));
        library.addBook(new Book(22557799, "The Setting Sun", Status.AVAILABLE));

        Book foundBook = library.searchBookByNumber(1);

        assertEquals(null, foundBook);
    }
}