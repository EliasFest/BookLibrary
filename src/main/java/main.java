public class main {
    public static void main(String[] args) {
        Book book1 = new Book(123, "hallo");
        Book book2 = new Book(456, "Test");
        Book book3 = new Book(789, "BuchIstGut");

        User user1 = new User(444, "Elias");
        User user2 = new User(666, "Marvin");

      LibraryService libraryService = new LibraryService();

      libraryService.lendOut(book1, user1);
      libraryService.showMyBooks(user1.getUserNumber());
      libraryService.returnBook(book1);
    }
}