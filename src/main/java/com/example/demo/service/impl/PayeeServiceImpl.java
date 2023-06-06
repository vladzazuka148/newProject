package com.example.demo.service.impl;

import com.example.demo.dto.PayeeRequestDto;
import com.example.demo.dto.PropertyForPayee;
import com.example.demo.service.PayeeService;
import org.springframework.stereotype.Service;

@Service
public class PayeeServiceImpl implements PayeeService {
    @Override
    public void createNewPayee(PayeeRequestDto payeeRequestDto) {
        System.out.println(payeeRequestDto.getPayeeType());
        System.out.println(payeeRequestDto.getUuid());
        System.out.println(payeeRequestDto.getValueOfMoney());
        for (PropertyForPayee property:payeeRequestDto.getPropertyForPayee()){
            System.out.println(property.getName());
            System.out.println(property.getValue());
        }
    }
}
