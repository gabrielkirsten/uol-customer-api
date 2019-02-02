package br.com.uol.custumerapi.controller;

import br.com.uol.custumerapi.model.dto.CustumerDTO;
import br.com.uol.custumerapi.service.CustumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("custumers")
public class CustumerController {

    private CustumerService custumerService;

    public CustumerController(CustumerService custumerService) {
        this.custumerService = custumerService;
    }

    @PostMapping
    public ResponseEntity postCustumer(@RequestBody CustumerDTO custumerDto) {
        return ResponseEntity.ok(custumerService.addNewCustumer(custumerDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCustumer(@PathVariable Long id) {
        return ResponseEntity.ok(custumerService.getCustumerById(id));
    }

    @GetMapping
    public ResponseEntity getCustumer() {
        return ResponseEntity.ok(custumerService.getAllCustumers());
    }

    @PutMapping
    public ResponseEntity putCustumer(@RequestBody CustumerDTO custumerDTO) {
        return ResponseEntity.ok(custumerService.updateCostumer(custumerDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustumer(@PathVariable Long id) {
        custumerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
