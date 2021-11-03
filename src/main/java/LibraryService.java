import java.util.ArrayList;

public class LibraryService {
    LibraryRepository libraryRepository = new LibraryRepository();

    public void lendOut(Book book, User user) {
        //Look if Book is available
        libraryRepository.addLendOutEntry(book, user);
    }

    public void returnBook(Book book) {
        libraryRepository.returnBookSQL(book);
    }

    public void showMyBooks(int userID) {
        System.out.println(libraryRepository.getBooksByUserID(userID));
    }

    public void showAllBook() {
        System.out.println(libraryRepository.getAllBooks());
    }
}