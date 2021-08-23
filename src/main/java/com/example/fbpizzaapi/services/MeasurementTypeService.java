package com.example.fbpizzaapi.services;


import com.example.fbpizzaapi.dto.AddMeasurementTypeDTO;
import com.example.fbpizzaapi.dto.EditMeasurementTypeDTO;
import com.example.fbpizzaapi.models.MeasurementType;
import com.example.fbpizzaapi.repository.MeasurementTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MeasurementTypeService implements IMeasurementTypeService{

    @Autowired
    private MeasurementTypeRepository measureTypeRepo;

    @Override
    public List<MeasurementType> getAll() {
        List<MeasurementType> measurementTypes = new ArrayList<>();
        try{
            Iterable<MeasurementType> measurementTypesEntities = measureTypeRepo.findAll();

            measurementTypesEntities.forEach(measure ->{
                measurementTypes.add(measure);
            });

        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return measurementTypes;
        }
    }

    @Override
    public MeasurementType get(Integer id) {
        MeasurementType measurementType = new MeasurementType();
        try{
            measurementType = measureTypeRepo
                    .findById(id)
                    .get();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return measurementType;
        }
    }

    @Override
    public MeasurementType post(AddMeasurementTypeDTO measurementTypeDTO) {
        MeasurementType measurementType = new MeasurementType();
        try{
            measurementType.setType(measurementTypeDTO.getType());

            measurementType = measureTypeRepo.save(measurementType);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return measurementType;
        }
    }

    @Override
    public MeasurementType put(EditMeasurementTypeDTO measurementTypeDTO) {

        MeasurementType existingMeasure = new MeasurementType();

        try{
            existingMeasure = measureTypeRepo
                    .findById(measurementTypeDTO.getId())
                    .get();

            existingMeasure.setType(measurementTypeDTO.getType());

            existingMeasure = measureTypeRepo.save(existingMeasure);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }finally {
            return existingMeasure;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try{
            MeasurementType existMeasure = measureTypeRepo
                    .findById(id)
                    .get();

            measureTypeRepo.delete(existMeasure);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
