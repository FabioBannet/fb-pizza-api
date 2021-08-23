package com.example.fbpizzaapi.services;


import com.example.fbpizzaapi.dto.AddProdTypeDTO;
import com.example.fbpizzaapi.dto.EditProdTypeDTO;
import com.example.fbpizzaapi.models.ProductType;

import java.util.List;

public interface IProductTypeService {
    List<ProductType> getAll();
    ProductType get(Integer id);
    ProductType post(AddProdTypeDTO prodTypeDTO);
    ProductType put(EditProdTypeDTO prodTypeDTO);
    boolean delete(Integer id);

}
