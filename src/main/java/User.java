import java.util.ArrayList;
import java.util.List;

public class User {
    private int userNumber;
    private String userName;
    private List<Integer> bookIDs = new ArrayList<>();

    User(int userNumber, String userName) {
        this.userNumber = userNumber;
        this.userName = userName;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public String getUserName() {
        return userName;
    }
    @Override
    public String toString() {
        return userNumber + " " + userName;
    }
}
