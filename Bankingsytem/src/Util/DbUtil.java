
package Util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {


    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "W@#45!@saf23";

    public static Connection getConnection(){

        Connection connection=null;
        try{

            connection = DriverManager.getConnection(JDBC_URL , JDBC_USERNAME, JDBC_PASSWORD );
        }catch(Exception e ){
            e.printStackTrace();
        }


        return connection;
    }



}
