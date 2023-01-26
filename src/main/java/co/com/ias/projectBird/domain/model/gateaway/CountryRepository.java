package co.com.ias.projectBird.domain.model.gateaway;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.country.Country;

import java.util.List;

public interface CountryRepository {

	Country saveCountry(Country country);

	Country updateCountry(Country country);

	Country findCountryById(Long id);

	List<Country> findAllCountries();

	Boolean deleteCountry(Long id);
}
