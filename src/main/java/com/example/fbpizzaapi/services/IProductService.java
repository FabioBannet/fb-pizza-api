package com.example.fbpizzaapi.services;


import com.example.fbpizzaapi.dto.AddProductDTO;
import com.example.fbpizzaapi.dto.EditProductDTO;
import com.example.fbpizzaapi.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();
    List<Product> getAllByProductTypeId(Integer productTypId);
    Product get(Integer id);
    Product addProduct(AddProductDTO addProductDTO);
    Product editProduct(EditProductDTO editProductDTO);
    boolean delete(Integer id);
}
