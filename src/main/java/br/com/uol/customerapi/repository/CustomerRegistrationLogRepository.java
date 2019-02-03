package br.com.uol.customerapi.repository;

import br.com.uol.customerapi.model.CustomerRegistrationLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRegistrationLogRepository extends CrudRepository<CustomerRegistrationLog, Long> {
}
