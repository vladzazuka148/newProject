package com.example.demo.service.impl;

import com.example.demo.dto.DogDto;
import com.example.demo.entity.DogEntity;
import com.example.demo.repository.DogRepository;
import com.example.demo.service.DogService;
import org.springframework.stereotype.Service;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public void createNewDog(DogDto dogDto){
        DogEntity dog = DogEntity.builder()
                        .age(dogDto.getAge())
                        .price(dogDto.getPrice())
                        .name(dogDto.getName())
                        .build();
        dogRepository.save(dog);
    }
}

