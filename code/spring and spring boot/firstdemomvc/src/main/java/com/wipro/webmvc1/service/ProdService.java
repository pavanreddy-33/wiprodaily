package com.wipro.webmvc1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.webmvc1.repo.ProdRepo;

@Service
public class ProdService {
    @Autowired
    private ProdRepo repo;

    public List<String> fetchCarList() {
        return repo.getProductList();
    }
}
