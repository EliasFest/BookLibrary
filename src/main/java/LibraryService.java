public class LibraryService {
    LibraryRepository libraryRepository = new LibraryRepository();

    public void lendOut(Book book, User user){
        libraryRepository.addLendOutEntry(book, user);
    }

    public void returnBook(Book book){
        libraryRepository.returnBookSQL(book);
    }

    public void showMyBooks(int userID){
        libraryRepository.getBooksByUserID(userID);
    }






}
