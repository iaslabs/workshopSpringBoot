package co.com.ias.projectBird.domain.model.gateaway;

import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.zone.Zone;

import java.util.List;

public interface ICountryRepository {

	Country saveCountry(Country country, Zone zone);

	Country updateCountry(Country country);

	Country findCountryById(Long id);

	List<Country> findAllCountries();

	Boolean deleteCountry(Long id);
}
