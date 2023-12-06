package com.brtest.brtest.Services;

import com.brtest.brtest.Entities.Client.Client;
import com.brtest.brtest.Entities.Sale.Sale;
import com.brtest.brtest.Entities.User.User;
import com.brtest.brtest.repositories.ClientRepository;
import com.brtest.brtest.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    public SaleRepository saleRepository;

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }
    public Sale getSalesById(int Id){
        return saleRepository.findById(Id).orElse(null);
    }

    public Boolean DeleteById(Sale sale){
        saleRepository.deleteById(sale.getId());
        return true;
    }

    public Boolean updateSale(Sale sale){
        saleRepository.saveAndFlush(sale);
        return true;
    }

    public Boolean AddSale(Sale sale) {
        saleRepository.saveAndFlush(sale);
        return true;
    }
}
