package myjavadb;

import java.sql.Connection;
import java.sql.PreparedStatement;

import myjavadb.config.DBconfig;

public class DBApp {
    
    
    public static void main(String[] args) throws Exception {
        // 1.Connection 객체
        Connection conn = DBconfig.getConnection();

        // 2. 버퍼 접근
        String sql = "insert into product(name, price, qty, created_at) values(?,?,?,now())";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 3. 물음표 완성
        pstmt.setString(1, "banana");
        pstmt.setInt(2, 1000);
        pstmt.setInt(3, 30);

        // 4. 전송
        int reuslt = pstmt.executeUpdate();

        // 5. 응답에 대한 처리
        if (reuslt == 1) {
            System.out.println("insert 되었습니다.");
        } else {
            System.out.println("insert 실패");
        }

        // 6. 최종 마무리
        conn.close();
        pstmt.close();
    }
}
