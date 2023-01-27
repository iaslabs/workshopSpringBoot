package co.com.ias.projectBird.domain.model.bird.dto;

import co.com.ias.projectBird.domain.model.bird.*;
import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.country.dto.CountryDTO;

import java.util.List;

public class BirdDTO {

    private Long id;

    private String commonName;

    private String scientificName;




    public BirdDTO(Long id, String commonName, String scientificName) {
        this.id = id;
        this.commonName = commonName;
        this.scientificName = scientificName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public Bird toDomain(BirdDTO birdDTO){
        return  new Bird(
                new BirdCommonName(birdDTO.getCommonName()),
                new BirdId(birdDTO.getId()), new BirdScientificName(birdDTO.getScientificName())
                );
    }

    public  BirdDTO fromDomain(Bird bird){
        return  new BirdDTO(bird.getId().getValue(),
                bird.getName().getValue(),
                bird.getScientificName().getValue());
    }
}
