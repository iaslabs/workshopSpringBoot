package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.infrastructure.adapters.BirdRepositoryAdapter;
import co.com.ias.projectBird.infrastructure.adapters.jpa.IBirdRepositoryAdapter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
class BirdUseCaseTest {

    @InjectMocks
    private BirdUseCase birdUseCase;
    @Mock
    private IBirdRepository iBirdRepository;

    @Test
    @DisplayName("Save Bird")
    void saveBird() {
        //Arrange
        BirdDTO birdDTO = new BirdDTO(1L,"Piolin","Pajaro");
        Bird bird =  BirdDTO.toDomain(birdDTO);
        when(iBirdRepository.saveBird(any(Bird.class))).thenReturn(bird);
        //Act && Assert
        BirdDTO birdActual = birdUseCase.saveBird(birdDTO);
        Assertions.assertNotNull(birdActual);
        assertEquals(birdActual.getCommonName(),"Piolin");
    }

    @Test
    void findBirdById() {
        //Arrange
        BirdDTO birdDTO = new BirdDTO(1L,"Piolin","Pajaro");
        Bird bird =  BirdDTO.toDomain(birdDTO);
        when(iBirdRepository.findBirdById(1L)).thenReturn(bird);
        //Act && Assert
        BirdDTO birdActual = birdUseCase.findBirdById(1L);
        Assertions.assertNotNull(birdActual);
        assertEquals(birdActual.getCommonName(),"Piolin");
    }

    @Test
    void findAllBirds() {
        //Arrange
        List<Bird> list =  new ArrayList<>();
        when(iBirdRepository.findAllBirds()).thenReturn(list);
        //Act && Assert
        List<BirdDTO> response = birdUseCase.findAllBirds();
        assertEquals(response,new ArrayList<>());
    }

    @Test
    void deleteBird() {
        //Arrange
        when(iBirdRepository.deleteBird(1L)).thenReturn(true);
        //Act && Assert
        boolean response = birdUseCase.deleteBird(1L);
        assertTrue(response);
    }

    @Test
    void updateBird() {
        //Arrange
        BirdDTO birdDTO = new BirdDTO(1L,"Piolin","Pajaro");
        Bird bird =  BirdDTO.toDomain(birdDTO);
        when(iBirdRepository.updateBird(any(Bird.class))).thenReturn(bird);
        //Act && Assert
        BirdDTO birdActual = birdUseCase.updateBird(birdDTO);
        Assertions.assertNotNull(birdActual);
        assertEquals(birdActual.getCommonName(),"Piolin");
    }
}