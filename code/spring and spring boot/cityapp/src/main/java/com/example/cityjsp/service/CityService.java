package com.example.cityjsp.service;

import com.example.cityjsp.repo.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    public List<String> getAllCities() {
        return cityRepo.getCities();
    }
}
