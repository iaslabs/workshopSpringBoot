package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import co.com.ias.projectBird.domain.model.gateaway.IZoneRepository;
import co.com.ias.projectBird.domain.model.zone.Zone;
import co.com.ias.projectBird.infrastructure.adapters.jpa.IZoneRepositoryAdapter;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.CountryDBO;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.ZoneDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;

@Repository
@AllArgsConstructor
public class ZoneRepositoryAdapter implements IZoneRepository {

    IZoneRepositoryAdapter iZoneRepositoryAdapter;

    @Override
    public Zone saveZone(Zone zone) {
        ZoneDBO zoneSaved = iZoneRepositoryAdapter.save(ZoneDBO.fromDomain(zone));
        return ZoneDBO.toDomain(zoneSaved);
    }
    @Override
    public Zone updateZone(Zone zone) {
        Optional<ZoneDBO> dbo = iZoneRepositoryAdapter.findById(zone.getZoneId().getValue());
        if (dbo.isEmpty()){
            throw new NullPointerException("No existe zona con el id: " + zone.getZoneId().getValue());
        } else {
            ZoneDBO zoneSaved = iZoneRepositoryAdapter.save(ZoneDBO.fromDomain(zone));
            return ZoneDBO.toDomain(zoneSaved);
        }
    }

    @Override
    public Zone findZoneById(Long id) {

        Optional<ZoneDBO> dbo = iZoneRepositoryAdapter.findById(id);
        if (dbo.isEmpty()){
            throw new NullPointerException("No existe zona con el id: " + id);
        } else {
            return ZoneDBO.toDomain(dbo.get());
        }
    }
    @Override
    public List<Zone> findAllZones() {
        return iZoneRepositoryAdapter.findAll().stream().map(ZoneDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteZone(Long id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<ZoneDBO> dbo = iZoneRepositoryAdapter.findById(id);
        dbo.ifPresent(value -> {
            iZoneRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }
}
