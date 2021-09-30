public class Book {
    private int serialNumber;
    private String bookName;
    private Status bookStatus;
    private int whoHasBook;

    Book(int serialNumber, String bookName, Status bookStatus) {
        this.serialNumber = serialNumber;
        this.bookName = bookName;
        this.bookStatus = bookStatus;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public Status getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Status bookStatus) {
        this.bookStatus = bookStatus;
    }

    public int getWhoHasBook() {
        return whoHasBook;
    }

    public void setWhoHasBook(int whoHasBook) {
        this.whoHasBook = whoHasBook;
    }

    @Override
    public String toString() {
        return serialNumber + " " + bookName;
    }
}