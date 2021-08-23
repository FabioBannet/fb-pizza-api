package com.example.fbpizzaapi.dto;

import java.util.Objects;

public class AddProdTypeDTO {
    private String type;

    public AddProdTypeDTO() {}

    public AddProdTypeDTO(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProdTypeDTO that = (AddProdTypeDTO) o;
        return Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    @Override
    public String toString() {
        return "AddProdTypeDTO{" +
                "type='" + type + '\'' +
                '}';
    }
}
