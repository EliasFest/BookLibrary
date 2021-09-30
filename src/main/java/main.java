public class main {
    public static void main(String[] args) {
        Book book1 = new Book(123, "hallo", "Vorhanden");
        Book book2 = new Book(456, "Test", "Vorhanden");
        Book book3 = new Book(789, "BuchIstGut", "Vorhanden");

        User user1 = new User(444, "Elias");
        User user2 = new User(666, "Marvin");

        Library library = new Library();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addUser(user1);
        library.addUser(user2);

        library.searchBookByNumber(456);

        library.takeBook(456, 444);

        library.showAllBooks();

    }
}