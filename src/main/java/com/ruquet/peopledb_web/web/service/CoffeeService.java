package com.ruquet.peopledb_web.web.service;

import com.ruquet.peopledb_web.biz.model.CoffeeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private final String URL_API_COFFEE = "https://api.sampleapis.com/coffee/hot";
    private RestTemplate restTemplate;

    public CoffeeService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public List<CoffeeDTO> getCoffeList(){
        CoffeeDTO[] coffeeArray = restTemplate.getForObject(URL_API_COFFEE, CoffeeDTO[].class);
        return Arrays.stream(coffeeArray)
                .map(coffee-> {
                    coffee.setTitle("Hot coffee : " + coffee.getTitle());
                    return coffee;
                })
                .collect(Collectors.toList());
    }

}
