package books;

public class Book {
    private int serialNumber;
    private String bookName;


    public Book() {

    }

    public Book(int serialNumber, String bookName) {
        this.serialNumber = serialNumber;
        this.bookName = bookName;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {

        return " " + serialNumber + " " + bookName;
    }
}