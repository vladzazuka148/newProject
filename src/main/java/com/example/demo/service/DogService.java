package com.example.demo.service;

import com.example.demo.dto.DogDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {
    void createNewDog(DogDto dogDto);

    List<DogDto> getAllDogs();
}
