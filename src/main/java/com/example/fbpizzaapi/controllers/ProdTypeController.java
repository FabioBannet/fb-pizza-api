package com.example.fbpizzaapi.controllers;

import com.example.fbpizzaapi.dto.AddProdTypeDTO;
import com.example.fbpizzaapi.dto.EditProdTypeDTO;
import com.example.fbpizzaapi.models.ProductType;
import com.example.fbpizzaapi.services.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdTypeController {
    @Autowired
    private IProductTypeService prodTypeService;

    @GetMapping("/prod_type")
    public List<ProductType> getAll(){
        return prodTypeService.getAll();
    }

    @GetMapping("/prod_type/{id}")
    public ProductType get(@PathVariable(name = "id")Integer id){
        return prodTypeService.get(id);
    }

    @PostMapping("/prod_type")
    public ProductType post(@RequestBody AddProdTypeDTO prodTypeDTO){
        return prodTypeService.post(prodTypeDTO);
    }

    @PutMapping("/prod_type")
    public ProductType put(@RequestBody EditProdTypeDTO prodTypeDTO){
        return prodTypeService.put(prodTypeDTO);
    }

    @DeleteMapping("/prod_type/{id}")
    public boolean delete(@PathVariable(name = "id")Integer id ){
        return prodTypeService.delete(id);
    }
}
