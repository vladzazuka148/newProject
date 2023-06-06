package com.example.demo.dto;

import com.example.demo.dto.constants.PayeeType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PayeeRequestDto {
    private UUID uuid;
    private BigDecimal valueOfMoney;
    private PayeeType payeeType;
    private List<PropertyForPayee> propertyForPayee;
}
