package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;

public class BirdUseCase {

    private final IBirdRepository iBirdRepository;

    private final ICountryRepository iCountryRepository;
    public BirdUseCase(IBirdRepository iBirdRepository, ICountryRepository iCountryRepository) {
        this.iBirdRepository = iBirdRepository;
        this.iCountryRepository = iCountryRepository;
    }
}
