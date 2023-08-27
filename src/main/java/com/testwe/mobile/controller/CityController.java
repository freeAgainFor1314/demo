package com.testwe.mobile.controller;

import com.testwe.mobile.domain.City;
import com.testwe.mobile.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/getOne/{id}")
    public City getOne(@PathVariable("id") Integer id) {
        return cityService.selectByPrimaryKey(id);
    }
}
