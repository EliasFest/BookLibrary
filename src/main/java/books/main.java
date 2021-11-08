package books;

import Library.LibraryService;
import users.User;

public class main {
    public static void main(String[] args) {
        Book book1 = new Book(123, "hallo");
        Book book2 = new Book(456, "Test");
        Book book3 = new Book(789, "BuchIstGut");

        User user1 = new User(444, "Elias");
        User user2 = new User(666, "Marvin");

        LibraryService libraryService = new LibraryService();

        //libraryService.lendOut(book3, user1);
        //libraryService.showMyBooks(user1.getUserNumber());
        //libraryService.returnBook(book3);
        //libraryService.showAllBook();
        //libraryService.showThatBook(456);
        libraryService.addUserEntry(user2);
    }
}