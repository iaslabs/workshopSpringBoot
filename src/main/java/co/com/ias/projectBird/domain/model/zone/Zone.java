package co.com.ias.projectBird.domain.model.zone;

public class Zone {

    ZoneId zoneId;
    ZoneName zoneName;

    public Zone(ZoneId zoneId, ZoneName zoneName) {
        this.zoneId = zoneId;
        this.zoneName = zoneName;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public ZoneName getZoneName() {
        return zoneName;
    }

    public void setZoneName(ZoneName zoneName) {
        this.zoneName = zoneName;
    }
}
