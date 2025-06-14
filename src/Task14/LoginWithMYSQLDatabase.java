package Task14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginWithMYSQLDatabase {
    private static final String URL = "jdbc:mysql://localhost:3307/sysdata";
    private static final String USER = "root";
    private static final String PASSWORD = "mysql";

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Ensure the MySQL JDBC driver is loaded
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = java.sql.DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException e) {
                System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("Connection Failed! Check output console");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection = null;
        }
    }

    public static boolean login(String username, String password) {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Cannot connect to database for login.");
            return false;
        }

        String query = "SELECT PASSWORD FROM USER WHERE NAME = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (password.equals(dbPassword)) {
                    System.out.println("Login successful for user: " + username);
                    return true;
                } else {
                    System.out.println("Login failed: Incorrect password for user: " + username);
                    return false;
                }
            } else {
                System.out.println("Login failed: User '" + username + "' not found.");
                return false;
            }
        } catch (SQLException e) {
            System.err.println("SQL Error during login: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection testConn = getConnection();
        if (testConn == null) {
            System.out.println("Failed to establish initial connection. Exiting.");
            return;
        } else {
            System.out.println("Initial connection test successful!");
        }

        Scanner scanner = new Scanner(System.in);
        int loginAttempts = 0;
        final int MAX_LOGIN_ATTEMPTS = 3;
        boolean isLoggedIn = false;

        while (loginAttempts < MAX_LOGIN_ATTEMPTS && !isLoggedIn) {
            loginAttempts++;
            System.out.println("\nLogin Attempt " + loginAttempts + " of " + MAX_LOGIN_ATTEMPTS);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String passwordInput = scanner.nextLine();

            isLoggedIn = login(username, passwordInput);

            if (isLoggedIn) {
                System.out.println("Welcome, " + username + "!");
            } else {
                if (loginAttempts >= MAX_LOGIN_ATTEMPTS) {
                    System.out.println("Maximum login attempts reached. Exiting program.");
                } else {
                    int attemptsRemaining = MAX_LOGIN_ATTEMPTS - loginAttempts;
                    System.out.println(attemptsRemaining + " attempt(s) remaining.");
                }
            }
        }

        scanner.close();
        closeConnection();
    }
}