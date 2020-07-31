package io.springbootlab.globaltopic.service;

import io.springbootlab.globaltopic.controller.ProductManagementController;
import io.springbootlab.globaltopic.model.Product;
import io.springbootlab.globaltopic.repository.ProductRepository;
import io.springbootlab.globaltopic.repository.ProductRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class ProductManagement {

    @Autowired
    ProductRepository productRepository;

    Logger logger= LoggerFactory.getLogger(ProductManagement.class);

    Hashtable<String, Product> productContainer=new Hashtable<>();

    public ProductManagement() {

        IntStream.range(1001,1010).forEach(i-> {

            String code = UUID.randomUUID().toString();
            DecimalFormat f = new DecimalFormat("####.00");
            double d = new Random().nextDouble() * 100;
            String price = f.format(d);
            boolean available = new Random().nextBoolean();
            String mfb = "IN";
            String date = new Date().toString();
            Product p = new Product();
            p.setProductCode(code);
            p.setExpireDate(date);
            p.setProductPrice(Double.parseDouble(price));
            p.setAvailability(available);
            p.setManufacturedBy(mfb);

            productContainer.put(new String(String.valueOf(i)), p);
        });
    }

    public ResponseEntity<Product> getProductById(String id){
        logger.info("getProductById(service) called...");

        if(productContainer.contains(id)){
            return new ResponseEntity<Product>(productContainer.get(id), HttpStatus.OK);
        }
        else
            return new ResponseEntity<Product>(productContainer.get(id),HttpStatus.NOT_FOUND);

    }



    public ResponseEntity<List<Product>> getAllProducts(){
        logger.info("getAllProducts(service) called...{}",productContainer);
        List<Product> productList=new ArrayList<>();
        productContainer.forEach((k,v)->{productList.add(v);});
        return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
    }

    public Product addProducts(Product product){
        logger.info("addProducts(service) called...{}",productContainer);
        return productRepository.addProduct(product);
    }

}


