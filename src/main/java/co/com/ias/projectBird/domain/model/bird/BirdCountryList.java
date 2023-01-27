package co.com.ias.projectBird.domain.model.bird;

import co.com.ias.projectBird.domain.model.country.Country;

import java.util.List;

public class BirdCountryList {

    private final List<Country> value;

    public BirdCountryList(List<Country> value) {
        this.value = value;
    }

    public List<Country> getValue() {
        return value;
    }

}
