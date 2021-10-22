import java.sql.*;
import java.util.Calendar;
import java.util.Date;


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

    public void deleteBookSQL(int bookID) {
        String sql = "DELETE FROM Book " + "WHERE serialNumber = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, bookID);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void deleteUserSQL(int userID) {
        String sql = "DELETE FROM User " + "WHERE userNumber = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            prepareStatement.setInt(1, userID);
            prepareStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void addLendOutEntry(Book book, User user) {
        String sql = "INSERT INTO LendOut (memberID, bookID, start, howLongLend) VALUES (?, ?, ?, ?)";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            Calendar calender = Calendar.getInstance();
            Date now = calender.getTime();
            calender.add(Calendar.DAY_OF_YEAR, 10);
            Date calenderTime = calender.getTime();
            Timestamp endDate = new Timestamp(calenderTime.getTime());

            preparedStatement.setInt(1, user.getUserNumber());
            preparedStatement.setInt(2, book.getSerialNumber());
            preparedStatement.setTimestamp(3, new Timestamp(now.getTime()));
            preparedStatement.setTimestamp(4, endDate);

            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void returnBookSQL(Book book) {
        String sql = "UPDATE FROM LendOut " + "WHERE bookID = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, book.getSerialNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void showAllBooksSQL() {
        String sql = "SELECT * FROM Book";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            ResultSet resultset = prepareStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                System.out.println(" BookID: " + resultset.getInt("serialNumber"));
                System.out.println(" Name: " + resultset.getString("bookName"));
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void showAllUsersSQL() {
        String sql = "SELECT * FROM User";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            ResultSet resultset = prepareStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                System.out.println(" UserID: " + resultset.getInt("userNumber"));
                System.out.println(" Name: " + resultset.getString("userName"));
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public void getBooksByUserID(int userID) {
        String sql = "SELECT bookID FROM LendOut " + "WHERE memberID = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, userID);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                System.out.println(" BookID: " + resultset.getInt("bookID"));
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }
}