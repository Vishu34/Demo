package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbUtil {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "W@#45!@saf23";




        public static Connection getConnection() throws  SQLException{

// //            if we are not using throws keyword then

// //            Connection connection = null;
// //            try {
// //                connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
// //            } catch (SQLException e) {
// //                e.printStackTrace();
// //                // Optional: Log the exception or rethrow it as a custom exception
// //                // throw new RuntimeException("Error connecting to the database", e);
// //            }
// //            return connection;


            return    DriverManager.getConnection(JDBC_URL , JDBC_USERNAME ,JDBC_PASSWORD);
        };












}
