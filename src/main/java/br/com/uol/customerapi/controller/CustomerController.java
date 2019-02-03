package br.com.uol.customerapi.controller;

import br.com.uol.customerapi.model.dto.CustomerDTO;
import br.com.uol.customerapi.service.CustomerService;
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
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity postCustomer(@RequestBody CustomerDTO customerDto) {
        return ResponseEntity.ok(customerService.addNewCustomer(customerDto));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity getCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @PutMapping
    public ResponseEntity putCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCostomer(customerDTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
