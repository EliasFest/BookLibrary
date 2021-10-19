public class main {
    public static void main(String[] args) {
        Book book1 = new Book(123, "hallo");
        Book book2 = new Book(456, "Test");
        Book book3 = new Book(789, "BuchIstGut");

        User user1 = new User(444, "Elias");
        User user2 = new User(666, "Marvin");

        LibraryRepository libraryService = new LibraryRepository();

        //libraryService.addBookSQL(book1);
        //libraryService.addBookSQL(book2);
        //libraryService.addBookSQL(book3);

        //libraryService.addUserSQL(user1);

        //libraryService.deleteBookSQL(book1);
        //libraryService.deleteUserSQL(user1);

        //libraryService.showAllBooksSQL();
        //libraryService.showAllUsersSQL();

        libraryService.takeBookSQL(book1, user1);
    }
}