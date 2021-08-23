package com.example.fbpizzaapi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductType productType;

    private String name;
    private Integer measurementPoints;

    @ManyToOne
    @JoinColumn(name = "measurement_type_id", referencedColumnName = "id")
    private MeasurementType measurementType;

    private String description;
    private String imgReference;
    private BigDecimal price;

    public Product() {}

    public Product(Integer id, ProductType productType, String name, Integer measurementPoints, MeasurementType measurementType, String description, String imgReference, BigDecimal price) {
        this.id = id;
        this.productType = productType;
        this.name = name;
        this.measurementPoints = measurementPoints;
        this.measurementType = measurementType;
        this.description = description;
        this.imgReference = imgReference;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMeasurementPoints() {
        return measurementPoints;
    }

    public void setMeasurementPoints(Integer measurementPoints) {
        this.measurementPoints = measurementPoints;
    }

    public MeasurementType getWeightType() {
        return measurementType;
    }

    public void setMeasurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgReference() {
        return imgReference;
    }

    public void setImgReference(String imgReference) {
        this.imgReference = imgReference;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(productType, product.productType) && Objects.equals(name, product.name) && Objects.equals(measurementPoints, product.measurementPoints) && Objects.equals(measurementType, product.measurementType) && Objects.equals(description, product.description) && Objects.equals(imgReference, product.imgReference) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productType, name, measurementPoints, measurementType, description, imgReference, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productType=" + productType +
                ", name='" + name + '\'' +
                ", measurementPoints=" + measurementPoints +
                ", weightType=" + measurementType +
                ", description='" + description + '\'' +
                ", imgReference='" + imgReference + '\'' +
                ", price=" + price +
                '}';
    }
}
