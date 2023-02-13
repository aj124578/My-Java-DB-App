package myjavadb;

import java.sql.Connection;
import java.sql.SQLException;

import myjavadb.config.DBconfig;
import myjavadb.model.ProductRepository;
import myjavadb.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        // 1. 커넥션 가져오기
        Connection conn = DBconfig.getConnection();

        // 2. DAO를 메모리에 올리기
        ProductRepository productRepository = new ProductRepository(conn);

        // 3. service를 메모리에 올리기
        ProductService productService = new ProductService(productRepository);
        productService.상품등록("apple", 2000, 5);
    }
}
