package io.springbootlab.globaltopic.controller;

import io.springbootlab.globaltopic.model.Product;
import io.springbootlab.globaltopic.service.ProductManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Hashtable;
import java.util.List;


@RestController
@RequestMapping("/ecom")
public class ProductManagementController {

    Logger logger= LoggerFactory.getLogger(ProductManagementController.class);

    @Autowired
    private ProductManagement productManagement;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        logger.info("getAllProduct(controller) called...");
        return productManagement.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
        logger.info("getProductById(controller) called...");
        return productManagement.getProductById(id);
    }
}
