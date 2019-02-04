package br.com.uol.customerapi.repository;

import br.com.uol.customerapi.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CustomerRepository extends CrudRepository<Customer, UUID> {

    Customer getById(UUID id);

}
