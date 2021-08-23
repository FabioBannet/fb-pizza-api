package com.example.fbpizzaapi.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class EditProductDTO {
    private Integer productId;
    private Integer productTypeId;
    private String name;
    private Integer measurementPoints;
    private Integer measurementTypeId;
    private String description;
    private String imgReference;
    private BigDecimal price;

    public EditProductDTO() {}

    public EditProductDTO(Integer productId, Integer productTypeId, String name, Integer measurementPoints, Integer measurementTypeId, String description, String imgReference, BigDecimal price) {
        this.productId = productId;
        this.productTypeId = productTypeId;
        this.name = name;
        this.measurementPoints = measurementPoints;
        this.measurementTypeId = measurementTypeId;
        this.description = description;
        this.imgReference = imgReference;
        this.price = price;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
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

    public Integer getMeasurementTypeId() {
        return measurementTypeId;
    }

    public void setMeasurementTypeId(Integer measurementTypeId) {
        this.measurementTypeId = measurementTypeId;
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
        EditProductDTO that = (EditProductDTO) o;
        return Objects.equals(productId, that.productId) && Objects.equals(productTypeId, that.productTypeId) && Objects.equals(name, that.name) && Objects.equals(measurementPoints, that.measurementPoints) && Objects.equals(measurementTypeId, that.measurementTypeId) && Objects.equals(description, that.description) && Objects.equals(imgReference, that.imgReference) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productTypeId, name, measurementPoints, measurementTypeId, description, imgReference, price);
    }

    @Override
    public String toString() {
        return "EditProductDTO{" +
                "productId=" + productId +
                ", productTypeId=" + productTypeId +
                ", name='" + name + '\'' +
                ", measurementPoints=" + measurementPoints +
                ", measurementTypeId=" + measurementTypeId +
                ", description='" + description + '\'' +
                ", imgReference='" + imgReference + '\'' +
                ", price=" + price +
                '}';
    }
}
