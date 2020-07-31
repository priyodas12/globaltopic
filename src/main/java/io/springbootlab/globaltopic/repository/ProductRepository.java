package io.springbootlab.globaltopic.repository;

import io.springbootlab.globaltopic.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface ProductRepository extends Repository<Product, String> {
    Product addProduct(Product p);
}
