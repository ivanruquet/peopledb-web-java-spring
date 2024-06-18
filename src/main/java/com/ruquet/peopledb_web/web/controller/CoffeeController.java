package com.ruquet.peopledb_web.web.controller;

import com.ruquet.peopledb_web.biz.model.CoffeeDTO;
import com.ruquet.peopledb_web.web.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping
    public List<CoffeeDTO> getCoffees(){
        return coffeeService.getCoffeList();
    }
}
