package com.BilBay.bilbay.models;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name = "product_specification")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = ProductSpecification.class)
public class ProductSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "productSpecification")
    private Product product;
    @Column(name = "product_photo")
    private String productPhoto;
    @Column(name = "model_year")
    private int modelYear;
    @Column(name = "gear")
    private String gear;
    @Column(name = "engine_power")
    private String enginePower;
    @Column(name = "mileage")
    private long mileage;
    @Column(name = "color")
    private String color;
    @Column(name = "VIN_nr", unique = true)
    private String vinNr;


    public ProductSpecification() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public String getProductPhoto() {
        return productPhoto;
    }
    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
    public int getModelYear() {
        return modelYear;
    }
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }
    public String getGear() {
        return gear;
    }
    public void setGear(String gear) {
        this.gear = gear;
    }
    public String getEnginePower() {
        return enginePower;
    }
    public void setEnginePower(String enginePower) {
        this.enginePower = enginePower;
    }
    public long getMileage() {
        return mileage;
    }
    public void setMileage(long mileage) {
        this.mileage = mileage;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getVinNr() {
        return vinNr;
    }
    public void setVinNr(String vinNr) {
        this.vinNr = vinNr;
    }
}
