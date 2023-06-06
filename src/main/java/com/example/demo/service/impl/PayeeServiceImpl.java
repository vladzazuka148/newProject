package com.example.demo.service.impl;

import com.example.demo.dto.PayeeRequestDto;
import com.example.demo.dto.PropertyForPayee;
import com.example.demo.entity.Payee;
import com.example.demo.entity.PayeeProp;
import com.example.demo.repository.PayeeRepository;
import com.example.demo.service.PayeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PayeeServiceImpl implements PayeeService {
    private final PayeeRepository payeeRepository;

    public PayeeServiceImpl(PayeeRepository payeeRepository) {
        this.payeeRepository = payeeRepository;
    }

    @Override
    @Transactional
    public void createNewPayee(PayeeRequestDto payeeRequestDto) {
        Payee payee = new Payee();
        payee.setPayeeType(payeeRequestDto.getPayeeType());
        payee.setValueOfMoney(payeeRequestDto.getValueOfMoney());
        for (PropertyForPayee pr:payeeRequestDto.getPropertyForPayee()){
            if(payee.getPayeeProps()==null){
                payee.setPayeeProps(new ArrayList<>());
            }
            payee.getPayeeProps().add(PayeeProp.builder()
                            .name(pr.getName())
                            .value(pr.getValue())
                            .payee(payee)
                            .build());
        }
        payeeRepository.save(payee);
    }
}
