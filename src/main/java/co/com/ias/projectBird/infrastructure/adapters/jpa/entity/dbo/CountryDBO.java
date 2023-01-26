package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

public class CountryDBO {

	private Long id;
	private String countryName;
	private String countryZone;

	public CountryDBO(Long id, String countryName, String countryZone) {
		this.id = id;
		this.countryName = countryName;
		this.countryZone = countryZone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryZone() {
		return countryZone;
	}

	public void setCountryZone(String countryZone) {
		this.countryZone = countryZone;
	}
}
