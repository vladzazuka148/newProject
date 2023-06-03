package com.example.demo.service;

import com.example.demo.dto.DogDto;
import com.example.demo.entity.DogEntity;
import org.springframework.stereotype.Service;

@Service
public interface DogService {
    void createNewDog(DogDto dogDto);
}
