package com.example.demo.dto;

import com.example.demo.entity.Cat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Cat}
 */
@Value
@Getter
@Setter
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CatDto implements Serializable {
    String name;
    Integer age;
    Integer price;
}