public class main {
    public static void main(String[] args) {
        Book book1 = new Book(123, "hallo", Status.AVAILABLE);
        Book book2 = new Book(456, "Test", Status.AVAILABLE);
        Book book3 = new Book(789, "BuchIstGut", Status.AVAILABLE);

        User user1 = new User(444, "Elias");
        User user2 = new User(666, "Marvin");

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addUser(user1);
        library.addUser(user2);

        Book searchedBook = library.searchBookByNumber(456);

        library.takeBook(456, 666);

        System.out.print(library.showAllBooks());
        System.out.print("\n");

        System.out.print(library.showAllBookStatus());
        System.out.print("\n");

        System.out.println(library.showWhoHasBook());

        library.returnBook(456, 666);
        System.out.print("\n");
        library.showWhoHasBook();

    }
}