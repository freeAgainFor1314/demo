package com.testwe.mobile.service.impl;

import com.testwe.mobile.dao.CityMapper;
import com.testwe.mobile.domain.City;
import com.testwe.mobile.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;


    @Override
    public City selectByPrimaryKey(Integer id) {
        City city = cityMapper.selectByPrimaryKey(id);
        return city;
    }
}
