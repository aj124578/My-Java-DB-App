package myjavadb;

import java.sql.Connection;
import java.sql.SQLException;

import myjavadb.config.DBconfig;
import myjavadb.model.ProductRepository;
import myjavadb.service.ProductService;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBconfig.getConnection();
        ProductRepository productRepository = new ProductRepository(conn);
        ProductService productService = new ProductService(productRepository);
        productService.상품등록("apple", 2000, 5);
    }
}
