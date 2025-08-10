package com.example.cityjsp.repo;

import org.springframework.stereotype.Repository;
import java.util.Arrays;
import java.util.List;

@Repository
public class CityRepo {
    public List<String> getCities() {
        return Arrays.asList("Delhi", "Mumbai", "Chennai", "Hyderabad", "Bangalore");
    }
}
