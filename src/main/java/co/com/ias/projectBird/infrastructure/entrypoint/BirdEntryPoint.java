package co.com.ias.projectBird.infrastructure.entrypoint;

import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.country.dto.CountryDTO;
import co.com.ias.projectBird.domain.usecase.BirdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bird")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BirdEntryPoint {

    private final BirdUseCase birdUseCase;

    @GetMapping
    public ResponseEntity<?> get(){
        List<BirdDTO> birds = birdUseCase.findAllBirds();
        if(birds.isEmpty()){
            return new ResponseEntity(birds, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(birds, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity(birdUseCase.findBirdById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody BirdDTO birdDTO){
        return new ResponseEntity(birdUseCase.saveBird(birdDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody BirdDTO birdDTO){
        return new ResponseEntity(birdUseCase.updateBird(birdDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity(birdUseCase.deleteBird(id), HttpStatus.OK);
    }
}
