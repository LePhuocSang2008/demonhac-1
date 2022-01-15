package demonhac.Dao.Imp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDao {
	private static String URL  = "jdbc:mysql://localhost:3306/webnhac";
    private static String DRIVER = "com.mysql.cj.jdbc.Driver"; //dùng để chỉ dẫn cho Java biết sẽ kết nối tới loại database MySQL
    private static String USERNAME = "root";
    private static String PASSWORD = "";
    private static Connection CON = null;
	 public Connection getConnection() {
	        try {
	            Class.forName(DRIVER);
	            try {
	                CON = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            } catch (SQLException se) {
	                //Handle errors for JDBC
	                se.printStackTrace();
	            }
	        } catch (Exception ex) {
	            //Handle errors for Class.forName
	            ex.printStackTrace();
	        }

	        //return a connection object
	             return CON;
	}
}
