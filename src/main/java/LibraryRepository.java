import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LibraryRepository {

    public void addBookSQL(Book book) {
        String sql = "INSERT INTO Book VALUES (?,?)";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, book.getSerialNumber());
            prepareStatement.setString(2, book.getBookName());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void addUserSQL(User user) {
        String sql = "INSERT INTO User VALUES (?,?)";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, user.getUserNumber());
            prepareStatement.setString(2, user.getUserName());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void deleteBookSQL(Book book) {
        String sql = "DELETE FROM Book " + "WHERE serialNumber = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, book.getSerialNumber());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void deleteUserSQL(User user) {
        String sql = "DELETE FROM User " + "WHERE userNumber = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, user.getUserNumber());
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }
}