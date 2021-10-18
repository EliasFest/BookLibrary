import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryService {

    public void addBook(Book book) {
        String sql = "INSERT INTO books VALUES (?,?,?,?)";

        try (Connection databaseConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, book.getSerialNumber());
            prepareStatement.setString(2, book.getBookName());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }


}
