package Library;

import books.Book;
import users.User;

import java.util.List;

public class LibraryService {
    LibraryRepository libraryRepository = new LibraryRepository();

    public void lendOut(Book book, User user) {
        libraryRepository.addLendOutEntry(book, user);
    }

    public void returnBook(Book book) {
        libraryRepository.returnBookSQL(book);
    }

    public Object showMyBooks(int userID) {
        List<Book> myBooks = libraryRepository.getBooksByUserID(userID);
        System.out.println(myBooks);
        return myBooks;
    }

    public Object showAllBook() {
        List<Book> gotBooks = libraryRepository.getAllBooks();
        System.out.println(gotBooks);
        return gotBooks;
    }

    public Object showThatBook(int ID) {
        List<Book> foundBook = libraryRepository.getBooksByID(ID);
        System.out.println(foundBook);
        return foundBook;
    }

    public Object showAllUsers() {
        List<User> gotUsers = libraryRepository.getAllUsersSQL();
        System.out.println(gotUsers);
        return gotUsers;
    }

    public void addUserEntry(User user) {
        if (user.getUserNumber() != user.getUserNumber()) {
            libraryRepository.addUserSQL(user);
        } else {
            System.out.println("Error");
        }
    }

    public void deleteUserEntry(int ID) {
        libraryRepository.deleteUserSQL(ID);
    }


    public void addBookEntry(Book book) {

            libraryRepository.addBookSQL(book);
   }

    public void deleteBookEntry(int ID) {
        libraryRepository.deleteBookSQL(ID);
    }
}