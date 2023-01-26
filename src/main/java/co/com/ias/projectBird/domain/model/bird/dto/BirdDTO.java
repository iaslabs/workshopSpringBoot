package co.com.ias.projectBird.domain.model.bird.dto;

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
}
