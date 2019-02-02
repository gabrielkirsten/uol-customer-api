package br.com.uol.custumerapi.service;

import br.com.uol.custumerapi.model.Custumer;
import br.com.uol.custumerapi.model.dto.CustumerDTO;
import br.com.uol.custumerapi.repository.CustumerRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustumerService {

    private List<CustumerDTO> custumers;

    private CustumerRepository custumerRepository;

    public CustumerService(CustumerRepository custumerRepository) {
        this.custumerRepository = custumerRepository;
    }

    public CustumerDTO addNewCustumer(CustumerDTO custumerDto) {
        Custumer newCustumer = custumerRepository.save(custumerDto.fromDTO(custumerDto));
        return new CustumerDTO().toDTO(newCustumer);
    }

    @Cacheable("custumers")
    public CustumerDTO getCustumerById(Long id) {
        return new CustumerDTO().toDTO(custumerRepository.getById(id));
    }

    public List<CustumerDTO> getAllCustumers() {

        List<CustumerDTO> allCustumers = new ArrayList<>();

        custumerRepository.findAll().forEach(c -> allCustumers.add(new CustumerDTO().toDTO(c)));

        return allCustumers;

    }

}
