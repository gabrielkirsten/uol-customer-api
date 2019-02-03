package br.com.uol.customerapi.repository;

import br.com.uol.customerapi.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer getById(Long id);

}
