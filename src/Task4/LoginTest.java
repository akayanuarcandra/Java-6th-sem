package Task4;

public class LoginTest {
    int attemptCount = 3;

    public boolean loginUsername(String username) {
        if (attemptCount < 0) {
            return false;
        }

        String correct_username = "root";
        if (!correct_username.equals(username)) {
            attemptCount--;
            System.out.println("Invalid username! Attempts left: " + attemptCount);
            return false;
        }

        return true;
    }

    public boolean loginPassword(String password) {
        if (attemptCount < 0) {
            return false;
        }

        String correct_password = "123456";
        if (!correct_password.equals(password)) {
            attemptCount--;
            System.out.println("Invalid password! Attempts left: " + attemptCount);
            return false;
        }

        return true;
    }

    public int getRemainingAttempts() {
        return attemptCount;
    }
}