package br.com.uol.customerapi.model.dto;

import br.com.uol.customerapi.model.Customer;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class CustomerDTO extends DTOMapper<CustomerDTO, Customer> implements Serializable {

    private UUID id;

    private String name;

    private Integer age;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
    public Class<Customer> returnModelClass() {
        return Customer.class;
    }

    @Override
    public Class<CustomerDTO> returnDTOClass() {
        return CustomerDTO.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
