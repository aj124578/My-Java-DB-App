package myjavadb;

import java.sql.Connection;
import java.sql.SQLException;

import myjavadb.config.DBconfig;
import myjavadb.model.ProductRepository;

public class DBApp {
    public static void main(String[] args) throws SQLException {
        Connection conn = DBconfig.getConnection();

        ProductRepository productRepository = new ProductRepository(conn);
        productRepository.insert("apple", 1000, 30);
    }
}
