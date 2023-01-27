package co.com.ias.projectBird.domain.model.zone.dto;

import co.com.ias.projectBird.domain.model.zone.Zone;
import co.com.ias.projectBird.domain.model.zone.ZoneId;
import co.com.ias.projectBird.domain.model.zone.ZoneName;

public class ZoneDTO {

    private Long id;
    private String zoneName;

    public ZoneDTO(Long id, String zoneName) {
        this.id = id;
        this.zoneName = zoneName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Zone toDomain(ZoneDTO in) {
        return new Zone(new ZoneId(in.getId()), new ZoneName(in.getZoneName()));
    }

    public ZoneDTO fromDomain(Zone in) {
        return new ZoneDTO(in
                                   .getZoneId()
                                   .getValue(), in
                                   .getZoneName()
                                   .getValue());
    }
}
