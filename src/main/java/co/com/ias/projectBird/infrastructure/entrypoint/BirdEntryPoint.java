package co.com.ias.projectBird.infrastructure.entrypoint;

import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.country.dto.CountryDTO;
import co.com.ias.projectBird.domain.usecase.BirdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bird")
@AllArgsConstructor
public class BirdEntryPoint {

    private final BirdUseCase birdUseCase;

    @GetMapping
    public ResponseEntity<?> get(){
        return new ResponseEntity(birdUseCase.findAllBirds(), HttpStatus.OK);
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
}
