package co.com.ias.projectBird.domain.model.country.dto;

import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.country.CountryId;
import co.com.ias.projectBird.domain.model.country.CountryName;

public class CountryDTO {

    private Long id;
    private String countryName;
    private String countryZone;

    public CountryDTO(Long id, String countryName) {
        this.id = id;
        this.countryName = countryName;
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

    public Country toDomain(CountryDTO in) {
        return new Country(new CountryId(in.getId()), new CountryName(in.getCountryName()));
    }

    public static CountryDTO fromDomain(Country in) {
        return new CountryDTO(in.getId().getValue(), in.getCountryName().getValue());
    }
}
