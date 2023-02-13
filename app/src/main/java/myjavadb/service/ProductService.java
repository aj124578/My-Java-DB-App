package myjavadb.service;

import java.sql.SQLException;

import myjavadb.model.ProductRepository;

public class ProductService {
    
    private ProductRepository productRepository;

    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void 상품등록(String name, int price, int qty) throws SQLException{
        // 트랜잭션 시작
        productRepository.insert(name, price, qty);
        productRepository.insert(name, price, qty);
        // 트랜잭션 종료
    }
}
