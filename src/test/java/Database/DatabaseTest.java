package Database;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseTest {

    static Connection con = null;
    // Statement object
    private static Statement stmt;
    // Constant for Database URL
//    public static String DB_URL = "jdbc:mysql://192.168.11.119:3306/is_4";
    public static String DB_URL = "jdbc:mysql://localhost:3306/is_4";
    //Database Username
    public static String DB_USER = "root";
    // Database Password
    public static String DB_PASSWORD = "";

    @BeforeTest
    public void setUp() throws Exception {
        try {
            // Database connection
            String dbClass = "com.mysql.cj.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        try {
            String query = "select * from student";
            // Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false
            while (res.next()) {
                System.out.print(res.getString(1));
                System.out.print(" " + res.getString(2));
                System.out.print(" " + res.getString(3));
                System.out.println(" " + res.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        // Close DB connection
        if (con != null) {
            con.close();
        }
    }
}