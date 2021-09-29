import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @Test
    public void AddBookTest() {
        Library library = new Library();
        library.addBook(new Book("No Longer Human"));
        String expected = "No Longer Human";

        String bookName = library.().get(0).toString();
        assertEquals(expected, taskMessage);
    }
}