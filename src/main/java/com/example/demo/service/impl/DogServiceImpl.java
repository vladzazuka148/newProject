package com.example.demo.service.impl;

import com.example.demo.dto.DogDto;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import com.example.demo.service.DogService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;
    private final KafkaTemplate<String,String>kafkaTemplate;

    public DogServiceImpl(DogRepository dogRepository, KafkaTemplate<String, String> kafkaTemplate) {
        this.dogRepository = dogRepository;
        this.kafkaTemplate = kafkaTemplate;
    }
    @Transactional
    public void createNewDog(DogDto dogDto){
        Dog dog = Dog.builder()
                        .age(dogDto.getAge())
                        .price(dogDto.getPrice())
                        .name(dogDto.getName())
                        .build();
        dogRepository.save(dog);
        kafkaTemplate.send("my-topic-transaction","dog was created");
    }

    @Override
    public List<DogDto> getAllDogs() {
        List<DogDto> dtoList = dogRepository
                .findAll()
                .stream()
                .map(dogEntity -> DogDto.builder()
                        .age(dogEntity.getAge())
                        .name(dogEntity.getName())
                        .price(dogEntity.getPrice())
                        .build()).toList();
        return dtoList;
    }

}

