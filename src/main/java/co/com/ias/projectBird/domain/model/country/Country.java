package co.com.ias.projectBird.domain.model.country;

public class Country {

    private final CountryId id;
    private final CountryName countryName;


    public Country(CountryId id, CountryName countryName) {
        this.id = id;
        this.countryName = countryName;
    }

    public CountryId getId() {
        return id;
    }

    public CountryName getCountryName() {
        return countryName;
    }


}
