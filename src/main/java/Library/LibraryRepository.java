package Library;

import books.Book;
import users.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class LibraryRepository {

    LibraryRepository(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading driver class");
        }
    }

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
        String sql = "INSERT INTO LendOut (memberID, bookID, start, endDate) VALUES (?, ?, ?, ?)";

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
        String sql = "DELETE FROM LendOut " + "WHERE bookID = ?";

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, book.getSerialNumber());
            preparedStatement.executeUpdate();

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
    }

    public ArrayList<Book> getAllBooks() {
        String sql = "SELECT * FROM Book";
        ArrayList<Book> allBooks = new ArrayList<>();

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            ResultSet resultset = prepareStatement.executeQuery();

            while (resultset.next()) {
                Book books = new Book(resultset.getInt("serialNumber"), resultset.getString("bookName"));
                allBooks.add(books);
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return allBooks;
    }

    public ArrayList<User> getAllUsersSQL() {
        String sql = "SELECT * FROM User";
        ArrayList<User> allUser = new ArrayList();

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement prepareStatement = databaseConnection2.prepareStatement(sql);
        ) {
            ResultSet resultset = prepareStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                User user = new User(resultset.getInt("userNumber"), resultset.getString("userName"));
                allUser.add(user);
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return allUser;
    }

    public ArrayList<Book> getBooksByUserID(int userID) {
        String sql = "SELECT bookID FROM LendOut " + "WHERE memberID = ?";
        ArrayList<Book> myBook = new ArrayList();

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, userID);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                if (userID == userID) {
                    Book book = new Book(resultset.getInt("bookID"), resultset.getString("memberID"));
                    myBook.add(book);
                }
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return myBook;
    }
    public ArrayList<Book> getBooksByID(int bookID) {
        String sql = "SELECT serialNumber, bookName FROM Book " + "WHERE serialNumber = ?";
        ArrayList<Book> thatBook = new ArrayList();

        try (Connection databaseConnection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "LibraryProject", "root", "ceeyel1404");
             PreparedStatement preparedStatement = databaseConnection2.prepareStatement(sql);
        ) {
            preparedStatement.setInt(1, bookID);
            ResultSet resultset = preparedStatement.executeQuery();

            while (resultset.next()) {
                //Display values
                if (bookID == bookID) {
                    Book book = new Book(resultset.getInt("serialNumber"), resultset.getString("bookName"));
                    thatBook.add(book);
                }
            }

        } catch (SQLException exception) {
            System.out.println("Error while connecting to database " + exception);
        }
        return thatBook;
    }
}