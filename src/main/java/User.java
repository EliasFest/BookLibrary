import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private int userNumber;
    private List<Integer> bookIDs = new ArrayList<>();

    User(int userNumber, String userName) {
        this.userNumber = userNumber;
        this.userName = userName;
    }

    public int getUserNumber() {
        return userNumber;
    }
}
