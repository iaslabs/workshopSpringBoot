package co.com.ias.projectBird.infrastructure.entrypoint;

import co.com.ias.projectBird.domain.model.country.dto.CountryDTO;
import co.com.ias.projectBird.domain.model.zone.dto.ZoneDTO;
import co.com.ias.projectBird.domain.usecase.CountryUseCase;
import co.com.ias.projectBird.domain.usecase.ZoneUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@AllArgsConstructor
public class CountryEntryPoint {

    private final CountryUseCase countryUseCase;

    @GetMapping
    public ResponseEntity<?> get(){
        List<CountryDTO> countries = countryUseCase.findAllCountries();
        if(countries.isEmpty()){
            return new ResponseEntity(countries, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(countries, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity(countryUseCase.findCountryById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CountryDTO countryDTO){
        return new ResponseEntity(countryUseCase.saveCountry(countryDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody CountryDTO countryDTO){
        return new ResponseEntity(countryUseCase.updateCountry(countryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        return new ResponseEntity(countryUseCase.deleteCountry(id), HttpStatus.OK);
    }
}
