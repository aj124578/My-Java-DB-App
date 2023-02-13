package myjavadb.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconfig {
    
    public static Connection getConnection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/metadb", "root", "1234");
            System.out.println("DB연결 성공");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
