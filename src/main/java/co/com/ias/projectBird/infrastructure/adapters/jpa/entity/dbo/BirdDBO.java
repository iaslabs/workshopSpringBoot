package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

public class BirdDBO {

	private Long id;

	private String commonName;

	private String scientificName;

	public BirdDBO(Long id, String commonName, String scientificName) {
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
