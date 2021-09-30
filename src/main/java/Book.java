public class Book {
    private int serialNumber;
    private String bookName;
    private String bookStatus = "Vorhanden";
    private int whoHasBook;

     Book(int serialNumber, String bookName, String bookStatus) {
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

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    @Override
    public String toString() {
        return serialNumber + ", " + bookName;
    }
}