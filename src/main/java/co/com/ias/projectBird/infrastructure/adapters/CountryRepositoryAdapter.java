package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.zone.Zone;
import co.com.ias.projectBird.infrastructure.adapters.jpa.ICountryRepositoryAdapter;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.CountryDBO;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.ZoneDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CountryRepositoryAdapter implements ICountryRepository {

    private final ICountryRepositoryAdapter iCountryRepositoryAdapter;

    @Override
    public Country saveCountry(Country country, Zone zone) {
        ZoneDBO zoneDBO = ZoneDBO.fromDomain(zone);
        CountryDBO countrySaved = CountryDBO.fromDomain(country);
        countrySaved.setCountryZone(zoneDBO);
        return CountryDBO.toDomain(iCountryRepositoryAdapter.save(countrySaved));
    }

    @Override
    public Country updateCountry(Country country) {
        CountryDBO countryDBO = CountryDBO.fromDomain(country);
        Optional<CountryDBO> dbo = iCountryRepositoryAdapter.findById(countryDBO.getId());
        if (dbo.isEmpty()){
            throw new NullPointerException("No existe pais con el id: " + country.getId().getValue());
        } else {
            CountryDBO countrySaved = iCountryRepositoryAdapter.save(countryDBO);
            return CountryDBO.toDomain(countrySaved);
        }
    }

    @Override
    public Country findCountryById(Long id) {
        Optional<CountryDBO> dbo = iCountryRepositoryAdapter.findById(id);
        if (dbo.isEmpty()){
            throw new NullPointerException("No existe pais con el id: " + id);
        } else {
            return CountryDBO.toDomain(dbo.get());
        }
    }

    @Override
    public List<Country> findAllCountries() {
        return iCountryRepositoryAdapter.findAll().stream().map(CountryDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteCountry(Long id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<CountryDBO> dbo = iCountryRepositoryAdapter.findById(id);
        dbo.ifPresent(value -> {
            iCountryRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }
}
