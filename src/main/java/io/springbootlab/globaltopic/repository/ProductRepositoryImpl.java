package io.springbootlab.globaltopic.repository;

import io.springbootlab.globaltopic.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(Product p) {
        return productRepository.addProduct(p);
    }
}
