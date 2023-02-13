package myjavadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import myjavadb.config.DBconfig;

public class DBApp {
    private Connection conn;
    private static DBApp instance = new DBApp();

    public static DBApp getInstance() {
        return instance;
    }

    private DBApp() {
    }
    
    
    public static void main(String[] args) throws Exception {
        DBApp app = new DBApp();
        
        // 1.Connection 객체
        app.conn = DBconfig.getConnection();
        insert("apple", 500, 10); 
        insert("apple", 500, 10);
        app.conn.close();
    }

    private static void insert(String name, int price, int qty) throws SQLException {

        // 2. 버퍼 접근
        String sql = "insert into product(name, price, qty, created_at) values(?,?,?,now())";
        PreparedStatement pstmt = app.conn.prepareStatement(sql);

        // 3. 물음표 완성
        pstmt.setString(1, name);
        pstmt.setInt(2, price);
        pstmt.setInt(3, qty);

        // 4. 전송
        int result = pstmt.executeUpdate();

        // 5. 응답에 대한 처리
        if (result == 1) {
            System.out.println("insert 되었습니다.");
        } else {
            System.out.println("insert 실패");
        }

        // 6. 최종 마무리
       
        pstmt.close();
    }
}
