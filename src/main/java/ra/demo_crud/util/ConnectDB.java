package ra.demo_crud.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static private final String URL = "jdbc:mysql://localhost:3306/student_crud";
    static private final String USERNAME = "root";
    static private final String PASSWORD = "hung18061999";


    public static Connection openConnection(){
        Connection conn = null;
        try {
            // khai baos Driver
            Class.forName(DRIVER);

            // mở kết nối
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

        return  conn;
    }
    public static void closeConnection(Connection conn) {
        try {
            if (!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
