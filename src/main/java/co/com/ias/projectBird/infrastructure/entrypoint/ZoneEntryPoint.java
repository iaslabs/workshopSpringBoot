package co.com.ias.projectBird.infrastructure.entrypoint;

import co.com.ias.projectBird.domain.model.zone.dto.ZoneDTO;
import co.com.ias.projectBird.domain.usecase.BirdUseCase;
import co.com.ias.projectBird.domain.usecase.ZoneUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zone")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ZoneEntryPoint {

    private final ZoneUseCase zoneUseCase;

    @GetMapping
    public ResponseEntity<?> get(){

        List<ZoneDTO> zones = zoneUseCase.findAllZones();
        if(zones.isEmpty()){
            return new ResponseEntity(zones, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity(zones, HttpStatus.OK);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        return new ResponseEntity(zoneUseCase.findZoneById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ZoneDTO zoneDTO){
        return new ResponseEntity(zoneUseCase.saveZone(zoneDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody ZoneDTO zoneDTO){
        return new ResponseEntity(zoneUseCase.updateZone(zoneDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
        public ResponseEntity<?> delete(@PathVariable(name = "id") Long id){
        return new ResponseEntity(zoneUseCase.deleteZone(id), HttpStatus.OK);
    }
}
