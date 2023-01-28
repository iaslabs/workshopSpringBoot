package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.country.dto.CountryDTO;
import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CountryUseCase {

    private final ICountryRepository iCountryRepository;
    private final IBirdRepository iBirdRepository;
    private final IZoneRepository iZoneRepository;

    public CountryUseCase(ICountryRepository iCountryRepository, IBirdRepository iBirdRepository,
                          IZoneRepository iZoneRepository) {
        this.iCountryRepository = iCountryRepository;
        this.iBirdRepository = iBirdRepository;
        this.iZoneRepository = iZoneRepository;
    }


    public CountryDTO saveCountry(CountryDTO countryDTO){
       Country country = countryDTO.toDomain(countryDTO);
       return CountryDTO.fromDomain(this.iCountryRepository.saveCountry(country));
    }

public CountryDTO updateCountry(CountryDTO countryDTO){
    Country country = countryDTO.toDomain(countryDTO);
    return CountryDTO.fromDomain(iCountryRepository.updateCountry(country));
}

public CountryDTO findCountryById(Long id) {
    Country country = this.iCountryRepository.findCountryById(id);
    if (country != null) {
        return CountryDTO.fromDomain(country);
    }
    return null;
}

public ArrayList<CountryDTO> findAllCountries() {
    List<Country> countries = this.iCountryRepository.findAllCountries();
    return (ArrayList<CountryDTO>) countries.stream().map(CountryDTO::fromDomain).collect(Collectors.toList());
}

public Boolean deleteCountry(Long id){
    return iCountryRepository.deleteCountry(id);
}
}
