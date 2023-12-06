package com.brtest.brtest.controllers;

import com.brtest.brtest.Entities.Sale.Sale;
import com.brtest.brtest.Entities.User.User;
import com.brtest.brtest.Services.SaleService;
import com.brtest.brtest.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SaleController {


    @Autowired
    private final SaleService saleService;
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping("/Sales/")
    public ResponseEntity<Sale> Add(@RequestBody Sale sale){
        Boolean response = saleService.AddSale(sale);
        return response ?  new ResponseEntity<>(sale, HttpStatus.OK): new ResponseEntity<>(sale, HttpStatus.BAD_REQUEST) ;
    }


    @GetMapping("/Sales/")
    public ResponseEntity<List<Sale>> get(){
        List<Sale> sales = saleService.getAllSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }


    @DeleteMapping("/sales/{id}/")
    public ResponseEntity<Void> Delete(@PathVariable Integer id){
        Sale sale = saleService.getSalesById(id);
        saleService.DeleteById(sale);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/sales/{id}/")
    public ResponseEntity<Sale> Update(@RequestBody Sale sale){
        saleService.updateSale(sale);
        return new ResponseEntity<>(sale, HttpStatus.OK);
    }


    @GetMapping("/sales/{id}/")
    public ResponseEntity<Optional<Sale>> getById(@PathVariable Integer id){
        Optional<Sale> findSale = Optional.ofNullable(saleService.getSalesById(id));
        return new ResponseEntity<>(findSale, HttpStatus.OK);
    }




}
