package com.example.demo.Unit.Services;

import com.example.demo.dto.DogDto;
import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import com.example.demo.service.impl.DogServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class DogServiceImplTest {
    @InjectMocks
    private DogServiceImpl dogService;
    @Mock
    private DogRepository dogRepository;

    private UUID uuid = UUID.randomUUID();
    private DogDto dogDto;
    private List<Dog> dogList;
    private Dog dog;
    @BeforeEach
    void setUp() {
        dogDto = DogDto.builder()
                .age(10)
                .name("Lulu")
                .price(1000)
                .build();

        dog = Dog.builder()
                .uuid(uuid)
                .age(14)
                .name("Poofy")
                .price(1500)
                .build();

        dogList = List.of
                (new Dog(uuid,"Brad",12,500)
                ,new Dog(uuid,"Bob",5,900)
                ,new Dog(uuid,"Floopy",8,400));
    }

    @Test
    @DisplayName("Create new Dog if success , should call method save(dog)")
    void createNewDog() throws Exception{
        //ARRANGE
        //ACT
        dogService.createNewDog(dogDto);
        //VERIFY
        verify(dogRepository).save(any(Dog.class));
    }

    @Test
    @DisplayName("Get all dogs if success , should return all Dogs")
    void getAllDogs_IfSuccess_shouldReturnDogs() {
        //ARRANGE
        when(dogRepository.findAll()).thenReturn(dogList);
        //ACT
        dogService.getAllDogs();
        List<DogDto>dogDtoList = dogService.getAllDogs();
        //VERIFY
        System.out.println(dogService.getAllDogs());
        assertThat(dogDtoList.get(1)).isInstanceOf(DogDto.class);

    }

}