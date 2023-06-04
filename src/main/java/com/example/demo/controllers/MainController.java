package com.example.demo.controllers;

import com.example.demo.dto.CatDto;
import com.example.demo.dto.DogDto;
import com.example.demo.service.CatService;
import com.example.demo.service.DogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class MainController {

    private final DogService dogService;
    private final CatService catService;

    public MainController(DogService dogService, CatService catService) {
        this.dogService = dogService;
        this.catService = catService;
    }

    @PostMapping("dogs")
    public void createNewDog(@RequestParam Integer age,
                                    @RequestParam Integer price,
                                    @RequestParam String name){
        dogService.createNewDog(DogDto.builder()
                .age(age)
                .name(name)
                .price(price)
                .build());
    }

    @GetMapping("dogs")
    public List<DogDto> getAllDogs(){
        return dogService.getAllDogs();
    }

    @PostMapping("cats")
    public void createNewCat(@RequestParam Integer age,
                               @RequestParam Integer price,
                               @RequestParam String name){
        catService.createCat(CatDto.builder()
                .age(age)
                .name(name)
                .price(price)
                .build());
    }

}
