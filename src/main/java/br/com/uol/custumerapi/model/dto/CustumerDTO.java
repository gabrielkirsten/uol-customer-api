package br.com.uol.custumerapi.model.dto;

import br.com.uol.custumerapi.model.Custumer;

import java.io.Serializable;

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

}
