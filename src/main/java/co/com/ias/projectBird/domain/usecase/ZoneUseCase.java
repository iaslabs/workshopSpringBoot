package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;

public class ZoneUseCase {
    private final IZoneRepository iZoneRepository;
    private final ICountryRepository iCountryRepository;

    public ZoneUseCase(IZoneRepository iZoneRepository, ICountryRepository iCountryRepository) {
        this.iZoneRepository = iZoneRepository;
        this.iCountryRepository = iCountryRepository;
    }
}
