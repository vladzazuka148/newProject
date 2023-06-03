package com.example.demo.controllers;

import com.example.demo.dto.DogDto;
import com.example.demo.entity.DogEntity;
import com.example.demo.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

    private final DogService dogService;

    public MainController(DogService dogService) {
        this.dogService = dogService;
    }

    @PostMapping("new-dog")
    public void getDogByParams(@RequestParam Integer age,
                                    @RequestParam Integer price,
                                    @RequestParam String name){
        dogService.createNewDog(DogDto.builder()
                .age(age)
                .name(name)
                .price(price)
                .build());
    }
}
