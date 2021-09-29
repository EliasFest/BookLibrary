public class Book {
    private int serialNumber;
    public String bookName;
    public String bookStatus;
    private int whoHasBook;

     Book(int serialNumber, String bookName) {
        this.serialNumber = serialNumber;
        this.bookName = bookName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBookName() {
        return bookName;
    }

    @Override
    public String toString() {
        return serialNumber + ", " + bookName;
    }
}