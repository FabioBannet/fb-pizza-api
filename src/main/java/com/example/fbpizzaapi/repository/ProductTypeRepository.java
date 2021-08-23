package com.example.fbpizzaapi.repository;


import com.example.fbpizzaapi.models.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, Integer> {
}
