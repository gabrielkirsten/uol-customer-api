package br.com.uol.custumerapi.repository;

import br.com.uol.custumerapi.model.Custumer;
import org.springframework.data.repository.CrudRepository;

public interface CustumerRepository extends CrudRepository<Custumer, Long> {

    Custumer getById(Long id);

}
