package com.example.demo.dto;

import com.example.demo.dto.constants.PayeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayeeRequestDto {
    private BigDecimal valueOfMoney;
    private PayeeType payeeType;
    private List<PropertyForPayee> propertyForPayee;
}
