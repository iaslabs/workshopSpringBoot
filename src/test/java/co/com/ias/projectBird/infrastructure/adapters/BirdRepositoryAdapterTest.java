package co.com.ias.projectBird.infrastructure.adapters;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.BirdCommonName;
import co.com.ias.projectBird.domain.model.bird.BirdId;
import co.com.ias.projectBird.domain.model.bird.BirdScientificName;
import co.com.ias.projectBird.infrastructure.adapters.jpa.IBirdRepositoryAdapter;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ActiveProfiles("test")
class BirdRepositoryAdapterTest {
    @InjectMocks
    private BirdRepositoryAdapter birdRepositoryAdapter;
    @Autowired
    IBirdRepositoryAdapter repository;
    @BeforeAll
    void init(){
        birdRepositoryAdapter = new BirdRepositoryAdapter(repository);
    }


    @Test
    @DisplayName("Save Bird")
    void saveBird() {
        //Arrange
        Bird bird = new Bird(new BirdCommonName("Piolin"),new BirdId(1L),new BirdScientificName("Pajaro"));
        //Act
        Bird res = birdRepositoryAdapter.saveBird(bird);
        //Assert
        Assertions.assertEquals("Piolin",res.getName().getValue());
        Assertions.assertEquals("Pajaro",res.getScientificName().getValue());
        Assertions.assertEquals(1,res.getId().getValue());
    }

    @Test
    @DisplayName("Update Bird")
    void updateBird() {
        //Arrange
        Bird bird = new Bird(new BirdCommonName("Piolin"),new BirdId(1L),new BirdScientificName("Pajaro"));
        bird = birdRepositoryAdapter.saveBird(bird);
        Bird newBird = new Bird(new BirdCommonName("Alberto"),new BirdId(1L),new BirdScientificName("Pajaro"));
        //Act
        Bird res = birdRepositoryAdapter.updateBird(newBird);
        //Assert
        Assertions.assertEquals("Alberto",res.getName().getValue());
    }

    @Test
    void findBirdById() {
        //Arrange
        Bird bird = new Bird(new BirdCommonName("Piolin"),new BirdId(1L),new BirdScientificName("Pajaro"));
        birdRepositoryAdapter.saveBird(bird);
        //Act
        Bird birdFound = birdRepositoryAdapter.findBirdById(bird.getId().getValue());
        //Assert
        Assertions.assertEquals("Piolin",birdFound.getName().getValue());
        Assertions.assertEquals("Pajaro",birdFound.getScientificName().getValue());
        Assertions.assertEquals(1,birdFound.getId().getValue());
    }

    @Test
    void findAllBirds() {
        //Arrange
        Bird bird1 = new Bird(new BirdCommonName("Piolin"),new BirdId(1L),new BirdScientificName("Pajaro"));
        Bird bird2 = new Bird(new BirdCommonName("Carlos"),new BirdId(2L),new BirdScientificName("Pajaro"));
        Bird bird3 = new Bird(new BirdCommonName("Antonio"),new BirdId(3L),new BirdScientificName("Pajaro"));
        birdRepositoryAdapter.saveBird(bird1);
        birdRepositoryAdapter.saveBird(bird2);
        birdRepositoryAdapter.saveBird(bird3);
        //Act
        List<Bird> birds = birdRepositoryAdapter.findAllBirds();
        //Assert
        Assertions.assertEquals(3,birds.size());
        List <Long> birdsIds = birds.stream().map(b->b.getId().getValue()).collect(Collectors.toList()); //Lista después de haberse hecho el get
        List <Long> birdsIdsReal = new ArrayList<>();
        birdsIdsReal.add(bird1.getId().getValue());
        birdsIdsReal.add(bird2.getId().getValue());
        birdsIdsReal.add(bird3.getId().getValue());
        Assertions.assertEquals(birdsIds,birdsIdsReal);

        List <String> birdsNames = birds.stream().map(b->b.getName().getValue()).collect(Collectors.toList()); //Lista después de haberse hecho el get
        List <String> birdNamesReal = new ArrayList<>();
        birdNamesReal.add(bird1.getName().getValue());
        birdNamesReal.add(bird2.getName().getValue());
        birdNamesReal.add(bird3.getName().getValue());
        Assertions.assertEquals(birdsNames,birdNamesReal);

        List <String> birdScNames = birds.stream().map(b->b.getScientificName().getValue()).collect(Collectors.toList()); //Lista después de haberse hecho el get
        List <String> birdScNamesReal = new ArrayList<>();
        birdScNamesReal.add(bird1.getScientificName().getValue());
        birdScNamesReal.add(bird2.getScientificName().getValue());
        birdScNamesReal.add(bird3.getScientificName().getValue());
        Assertions.assertEquals(birdScNames,birdScNamesReal);
    }

    @Test
    void deleteBird() {
        //Arrange
        Bird bird = new Bird(new BirdCommonName("Piolin"),new BirdId(1L),new BirdScientificName("Pajaro"));
        bird = birdRepositoryAdapter.saveBird(bird);
        //Act
        boolean res = birdRepositoryAdapter.deleteBird(bird.getId().getValue());
        //Assert
        Assertions.assertTrue(res);
    }
}