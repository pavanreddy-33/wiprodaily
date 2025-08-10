package com.wipro.webmvc1.repo;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProdRepo {
    public List<String> getProductList() {
        return Arrays.asList("Audi", "Mercedes", "BMW");
    }
}
