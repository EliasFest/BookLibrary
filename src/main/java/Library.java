import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();


    public void addBook(Book newBook){
        books.add(newBook);
    }

    public List<Book> getBookList(){
        return books;
    }
}