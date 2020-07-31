package io.springbootlab.globaltopic.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Product")
public class Product {

    @Id
    private String productCode;
    private double productPrice;
    private boolean availability;
    private String manufacturedBy;
    private String expireDate;

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productPrice=" + productPrice +
                ", availability=" + availability +
                ", manufacturedBy='" + manufacturedBy + '\'' +
                ", expireDate='" + expireDate + '\'' +
                '}';
    }

    public Product(){

    }

    public Product(String productCode, double productPrice, boolean availability, String manufacturedBy, String expireDate) {
        this.productCode = productCode;
        this.productPrice = productPrice;
        this.availability = availability;
        this.manufacturedBy = manufacturedBy;
        this.expireDate = expireDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getManufacturedBy() {
        return manufacturedBy;
    }

    public void setManufacturedBy(String manufacturedBy) {
        this.manufacturedBy = manufacturedBy;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}
