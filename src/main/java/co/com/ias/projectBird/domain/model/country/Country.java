package co.com.ias.projectBird.domain.model.country;

public class Country {

    private final CountryId id;
    private final CountryName countryName;
    private final CountryZone countryZone;

    public Country(CountryId id, CountryName countryName, CountryZone countryZone) {
        this.id = id;
        this.countryName = countryName;
        this.countryZone = countryZone;
    }

    public CountryId getId() {
        return id;
    }

    public CountryName getCountryName() {
        return countryName;
    }

    public CountryZone getCountryZone() {
        return countryZone;
    }
}
