package com.example.demo.controllers;

import com.example.demo.dto.Dog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {

    @GetMapping("new-dog")
    public Dog getDogByParams(@RequestParam Integer age,
                              @RequestParam Integer price,
                              @RequestParam String name){
        return Dog.builder()
                .age(age)
                .name(name)
                .price(price)
                .build();
    }
}
