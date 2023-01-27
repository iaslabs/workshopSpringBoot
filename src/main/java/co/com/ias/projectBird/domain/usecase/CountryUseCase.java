package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;

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
}
