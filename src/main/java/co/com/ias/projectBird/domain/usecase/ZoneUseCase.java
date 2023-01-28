package co.com.ias.projectBird.domain.usecase;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.domain.model.gateaway.ICountryRepository;
import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;
import co.com.ias.projectBird.domain.model.zone.Zone;
import co.com.ias.projectBird.domain.model.zone.dto.ZoneDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static co.com.ias.projectBird.domain.model.zone.dto.ZoneDTO.fromDomain;

public class ZoneUseCase {
    private final IZoneRepository iZoneRepository;
    private final ICountryRepository iCountryRepository;

    public ZoneUseCase(IZoneRepository iZoneRepository, ICountryRepository iCountryRepository) {
        this.iZoneRepository = iZoneRepository;
        this.iCountryRepository = iCountryRepository;
    }


public ZoneDTO saveZone(ZoneDTO zoneDTO) {
    Zone zone = zoneDTO.toDomain(zoneDTO);
    return fromDomain(this.iZoneRepository.saveZone(zone));
}



    public ZoneDTO updateZone(ZoneDTO zoneDTO){
        Zone zone = zoneDTO.toDomain(zoneDTO);
        return ZoneDTO.fromDomain(iZoneRepository.updateZone(zone));
    }



    public ZoneDTO findZoneById(Long id) {
        Zone zone = this.iZoneRepository.findZoneById(id);
        if (zone != null) {
            return ZoneDTO.fromDomain(zone);
        }
        return null;
    }


public ArrayList<ZoneDTO> findAllZones() {
    List<Zone> zone = this.iZoneRepository.findAllZones();
    return (ArrayList<ZoneDTO>) zone.stream().map(ZoneDTO::fromDomain).collect(Collectors.toList());
}


public Boolean deleteZone(Long id){
    return iZoneRepository.deleteZone(id);
}
}
