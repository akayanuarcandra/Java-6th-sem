package Task14;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDWithMYSQLDatabase {
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

    public static void insertData(String name, String password, String email) {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Cannot connect to database for insert.");
            return;
        }

        String query = "INSERT INTO USER (NAME, PASSWORD, EMAIL) VALUES (?, ?, ?)";
        try (var pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setString(3, email);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " Data(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public static void updateData(String name, String newPassword, String newEmail) {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Cannot connect to database for update.");
            return;
        }

        String query = "UPDATE USER SET PASSWORD = ?, EMAIL = ? WHERE NAME = ?";
        try (var pstmt = conn.prepareStatement(query)) {
            // if user doesn't exist, it will not update anything
            pstmt.setString(1, newPassword);
            pstmt.setString(2, newEmail);
            pstmt.setString(3, name);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " Data(s) updated.");
            } else {
                System.out.println("No Data found with name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public static void deleteData(String name) {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Cannot connect to database for delete.");
            return;
        }

        String query = "DELETE FROM USER WHERE NAME = ?";
        try (var pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, name);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println(rowsAffected + " Data(s) updated.");
            } else {
                System.out.println("No Data found with name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public static void displayDatas() {
        Connection conn = getConnection();
        if (conn == null) {
            System.out.println("Cannot connect to database for display.");
            return;
        }

        String query = "SELECT * FROM USER";
        try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String name = rs.getString("NAME");
                String password = rs.getString("PASSWORD");
                String email = rs.getString("EMAIL");
                System.out.println("User: " + name + ", Password: " + password + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu;
        do {
            System.out.println("1. Insert Data");
            System.out.println("2. Update Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Display Data(s)");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            menu = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (menu) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();
                    if (name.isEmpty() || password.isEmpty() || email.isEmpty()) {
                        System.out.println("All fields are required.");
                        break;
                    }
                    if (!email.contains("@")) {
                        System.out.println("Invalid email format.");
                        break;
                    }
                    insertData(name, password, email);
                    break;
                case 2:
                    System.out.print("Enter name to update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    updateData(updateName, newPassword, newEmail);
                    break;
                case 3:
                    System.out.print("Enter name to delete: ");
                    String deleteName = scanner.nextLine();
                    deleteData(deleteName);
                    break;
                case 4:
                    displayDatas();
                    break;
                case 5:
                    closeConnection();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (menu != 5);
    }
}
