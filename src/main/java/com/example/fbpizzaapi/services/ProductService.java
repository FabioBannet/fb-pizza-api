package com.example.fbpizzaapi.services;

import com.example.fbpizzaapi.dto.AddProductDTO;
import com.example.fbpizzaapi.dto.EditProductDTO;
import com.example.fbpizzaapi.models.MeasurementType;
import com.example.fbpizzaapi.models.Product;
import com.example.fbpizzaapi.models.ProductType;
import com.example.fbpizzaapi.repository.MeasurementTypeRepository;
import com.example.fbpizzaapi.repository.ProductRepository;
import com.example.fbpizzaapi.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService implements IProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private MeasurementTypeRepository measurementTypeRepository;

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        try{
            Iterable<Product> prod = productRepository.findAll();

            prod.forEach(p ->{
                products.add(p);
            });
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return products;
        }

    }

    @Override
    public List<Product> getAllByProductTypeId(Integer productTypId) {
        List<Product> products = new ArrayList<>();
        try{
            Iterable<Product> prod = productRepository.findAllByProdType(productTypId);

            prod.forEach(p ->{
                products.add(p);
            });
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return products;
        }
    }

    @Override
    public Product get(Integer id) {
        Product product = new Product();
        try{
            product = productRepository
                    .findById(id)
                    .get();
        }catch(NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return product;
        }

    }

    @Override
    public Product addProduct(AddProductDTO addProductDTO) {

        Product newProduct = new Product();
        newProduct.setId(0);

        try{
            //Product type
            ProductType productType = productTypeRepository
                    .findById(addProductDTO.getProductTypeId())
                    .get();

            newProduct.setProductType(productType);

            newProduct.setName(addProductDTO.getName());
            newProduct.setMeasurementPoints(addProductDTO.getMeasurementPoints());

            //Measurement type
            MeasurementType measurementType =  measurementTypeRepository
                    .findById(addProductDTO.getMeasurementTypeId())
                    .get();
            newProduct.setMeasurementType(measurementType);

            newProduct.setDescription(addProductDTO.getDescription());
            newProduct.setImgReference(addProductDTO.getImgReference());
            newProduct.setPrice(addProductDTO.getPrice());

            newProduct = productRepository.save(newProduct);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return newProduct;
        }
    }

    @Override
    public Product editProduct(EditProductDTO editProductDTO) {
        Product product = new Product();

        if(editProductDTO == null){
            return product;
        }

        try{
            Product existingProduct = productRepository
                    .findById(editProductDTO.getProductId()).get();

            ProductType productType = productTypeRepository
                    .findById(editProductDTO.getProductTypeId())
                    .get();
            existingProduct.setProductType(productType);

            existingProduct.setName(editProductDTO.getName());
            existingProduct.setMeasurementPoints(editProductDTO.getMeasurementPoints());

            MeasurementType measurementType = measurementTypeRepository
                    .findById(editProductDTO.getMeasurementTypeId())
                    .get();

            existingProduct.setMeasurementType(measurementType);
            existingProduct.setDescription(editProductDTO.getDescription());
            existingProduct.setImgReference(editProductDTO.getImgReference());
            existingProduct.setPrice(editProductDTO.getPrice());

            product = productRepository.save(existingProduct);

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
        finally {
            return product;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try{
            Product existingProd = productRepository
                    .findById(id)
                    .get();
            productRepository.delete(existingProd);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
