package com.example.fbpizzaapi.dto;

import java.util.Objects;

public class EditProdTypeDTO {
    private Integer id;
    private String type;

    public EditProdTypeDTO() {}

    public EditProdTypeDTO(Integer id, String type) {
        this.id = id;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        EditProdTypeDTO that = (EditProdTypeDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "editProdTypeDTO{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
