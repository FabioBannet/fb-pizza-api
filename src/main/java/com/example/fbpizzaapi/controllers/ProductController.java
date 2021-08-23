package com.example.fbpizzaapi.controllers;


import com.example.fbpizzaapi.dto.AddProductDTO;
import com.example.fbpizzaapi.dto.EditProductDTO;
import com.example.fbpizzaapi.models.Product;
import com.example.fbpizzaapi.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/product")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/products_by_type/{id}")
    public List<Product> getAllByType(@PathVariable(name = "id")Integer id){
        return productService.getAllByProductTypeId(id);
    }

    @GetMapping("/product/{id}")
    public Product get(@PathVariable(name = "id") Integer id){
        return productService.get(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody AddProductDTO addProductDTO){
        return productService.addProduct(addProductDTO);
    }

    @PutMapping("/product")
    public Product editProduct(@RequestBody EditProductDTO editProductDTO){
        return productService.editProduct(editProductDTO);
    }

    @DeleteMapping("/product/{id}")
    public boolean delete(@PathVariable(name = "id")Integer id){
        return productService.delete(id);
    }


}
