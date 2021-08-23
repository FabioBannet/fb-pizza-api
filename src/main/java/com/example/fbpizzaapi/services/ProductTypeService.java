package com.example.fbpizzaapi.services;


import com.example.fbpizzaapi.dto.AddProdTypeDTO;
import com.example.fbpizzaapi.dto.EditProdTypeDTO;
import com.example.fbpizzaapi.models.ProductType;
import com.example.fbpizzaapi.repository.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductTypeService implements IProductTypeService{
    @Autowired
    private ProductTypeRepository prodTypeRepo;

    @Override
    public List<ProductType> getAll() {
        List<ProductType> productTypes = new ArrayList<>();
        try{

            Iterable<ProductType> existProdTypes = prodTypeRepo
                    .findAll();
            existProdTypes.forEach(prodType ->{
                productTypes.add(prodType);
            });
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return productTypes;
        }
    }

    @Override
    public ProductType get(Integer id) {
        ProductType prodType = new ProductType();
        try{
            prodType = prodTypeRepo.findById(id)
                    .get();

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return prodType;
        }
    }

    @Override
    public ProductType post(AddProdTypeDTO prodTypeDTO) {
        ProductType prodType = new ProductType();
        try{
            prodType.setType(prodTypeDTO.getType());
            prodType = prodTypeRepo.save(prodType);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return prodType;
        }
    }

    @Override
    public ProductType put(EditProdTypeDTO prodTypeDTO) {

        ProductType prodType = new ProductType();

        try{
            prodType = prodTypeRepo
                    .findById(prodTypeDTO.getId())
                    .get();

            prodType.setType(prodTypeDTO.getType());

            prodType = prodTypeRepo.save(prodType);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return prodType;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try{
            ProductType existProdType = prodTypeRepo
                    .findById(id)
                    .get();
            prodTypeRepo.delete(existProdType);
            return true;
        }catch (NoSuchElementException e){
            e.printStackTrace();
            return false;
        }
    }
}
