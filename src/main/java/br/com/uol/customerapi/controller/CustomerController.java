package br.com.uol.customerapi.controller;

import br.com.uol.customerapi.model.dto.CustomerDTO;
import br.com.uol.customerapi.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Api(value = "Customer", description = "REST API for Customer", tags = {"Customer"})
@RestController
@RequestMapping("customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value = "Create customer")
    @PostMapping
    public ResponseEntity postCustomer(@RequestBody CustomerDTO customerDto, HttpServletRequest request) {
        return new ResponseEntity<>(customerService.addNewCustomer(customerDto, request.getRemoteAddr()), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get customer by id")
    @GetMapping(value = "/{id}")
    public ResponseEntity getCustomer(@PathVariable UUID id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @ApiOperation(value = "List customer")
    @GetMapping
    public ResponseEntity getCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @ApiOperation(value = "Update customer")
    @PutMapping
    public ResponseEntity putCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerService.updateCostomer(customerDTO));
    }

    @ApiOperation(value = "Delete customer by id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable UUID id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
