package com.example.demo.service;

import com.example.demo.dto.PayeeRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface PayeeService {
    void createNewPayee(PayeeRequestDto payeeRequestDto);
}
