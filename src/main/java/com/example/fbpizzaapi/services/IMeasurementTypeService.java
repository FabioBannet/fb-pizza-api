package com.example.fbpizzaapi.services;

import com.example.fbpizzaapi.dto.AddMeasurementTypeDTO;
import com.example.fbpizzaapi.dto.EditMeasurementTypeDTO;
import com.example.fbpizzaapi.models.MeasurementType;

import java.util.List;

public interface IMeasurementTypeService {

    List<MeasurementType> getAll();
    MeasurementType get(Integer id);
    MeasurementType post(AddMeasurementTypeDTO measurementTypeDTO);
    MeasurementType put(EditMeasurementTypeDTO measurementTypeDTO);
    boolean delete(Integer id);

}
