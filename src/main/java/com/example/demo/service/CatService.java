package com.example.demo.service;

import com.example.demo.dto.CatDto;
import org.springframework.stereotype.Service;

@Service
public interface CatService {
    void createCat(CatDto catDto);
}
