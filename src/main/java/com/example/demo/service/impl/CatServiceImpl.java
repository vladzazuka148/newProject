package com.example.demo.service.impl;

import com.example.demo.dto.CatDto;
import com.example.demo.entity.Cat;
import com.example.demo.repository.CatRepository;
import com.example.demo.service.CatService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatServiceImpl implements CatService {

    private final CatRepository catRepository;

    public CatServiceImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    @Transactional
    public void createCat(CatDto catDto) {
        Cat cat = Cat.builder()
        .age(catDto.getAge())
        .price(catDto.getPrice())
        .name(catDto.getName())
        .build();
        catRepository.save(cat);
    }
}
