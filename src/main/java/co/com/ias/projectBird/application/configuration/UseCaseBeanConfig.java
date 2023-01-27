package co.com.ias.projectBird.application.configuration;

import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;
import co.com.ias.projectBird.domain.usecase.BirdUseCase;
import co.com.ias.projectBird.domain.usecase.CountryUseCase;
import co.com.ias.projectBird.domain.usecase.ZoneUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    @Bean
    public BirdUseCase birdUseCase(IBirdRepository iBirdRepository, ICountryRepository iCountryRepository){
        return new BirdUseCase(iBirdRepository,iCountryRepository);
    }

    @Bean
    public CountryUseCase countryUseCase(
            ICountryRepository iCountryRepository,
            IBirdRepository iBirdRepository,
            IZoneRepository iZoneRepository){
        return new CountryUseCase(
                iCountryRepository,
                iBirdRepository,
                iZoneRepository
        );
    }

    @Bean
    public ZoneUseCase zoneUseCase(IZoneRepository iZoneRepository, ICountryRepository iCountryRepository){
        return new ZoneUseCase(iZoneRepository, iCountryRepository);
    }
}
