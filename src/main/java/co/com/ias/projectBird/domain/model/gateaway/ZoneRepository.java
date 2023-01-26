package co.com.ias.projectBird.domain.model.gateaway;

import co.com.ias.projectBird.domain.model.zone.Zone;

import java.util.List;

public interface ZoneRepository  {

	Zone saveZone(Zone zone);

	Zone updateZone(Zone zone);

	Zone findZoneById(Long id);

	List<Zone> findAllZones();

	Boolean deleteZone(Long id);
}
