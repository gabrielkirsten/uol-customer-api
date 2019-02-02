package br.com.uol.custumerapi.model.dto;

import br.com.uol.custumerapi.model.Custumer;

import java.io.Serializable;
import java.util.Objects;

public class CustumerDTO extends DTOMapper<CustumerDTO, Custumer> implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Class<Custumer> returnModelClass() {
        return Custumer.class;
    }

    @Override
    public Class<CustumerDTO> returnDTOClass() {
        return CustumerDTO.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustumerDTO that = (CustumerDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
