package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;

import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.gateaway.CountryRepository;
import co.com.ias.projectBird.infrastructure.adapters.jpa.ICountryRepositoryAdapter;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.CountryDBO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CountryRepositoryAdapter implements CountryRepository{
    private final ICountryRepositoryAdapter iCountryRepositoryAdapter;

    @Override
    public Country saveCountry(Country country) {
        return null;
    }

    @Override
    public Country updateCountry(Country country) {
        return null;
    }

    @Override
    public Country findCountryById(Long id) {
        return null;
    }

    @Override
    public List<Country> findAllCountries() {
        return null;
    }

    @Override
    public Boolean deleteCountry(Long id) {
        return null;
    }
}
