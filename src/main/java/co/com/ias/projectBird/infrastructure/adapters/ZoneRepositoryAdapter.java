package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;

import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;
import co.com.ias.projectBird.domain.model.zone.Zone;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ZoneRepositoryAdapter implements IZoneRepository {

    @Override
    public Zone saveZone(Zone zone) {
        return null;
    }

    @Override
    public Zone updateZone(Zone zone) {
        return null;
    }

    @Override
    public Zone findZoneById(Long id) {
        return null;
    }

    @Override
    public List<Zone> findAllZones() {
        return null;
    }

    @Override
    public Boolean deleteZone(Long id) {
        return null;
    }
}
