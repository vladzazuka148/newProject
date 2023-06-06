package com.example.demo.entity;

import com.example.demo.dto.PropertyForPayee;
import com.example.demo.dto.constants.PayeeType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "payee")
public class Payee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "uuid")
    private UUID uuid;
    @Column(name = "value")
    private BigDecimal valueOfMoney;
    @Column(name = "payeetype")
    @Enumerated(EnumType.STRING)
    private PayeeType payeeType;
    @OneToMany(mappedBy = "payee",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<PayeeProp>payeeProps;
}

