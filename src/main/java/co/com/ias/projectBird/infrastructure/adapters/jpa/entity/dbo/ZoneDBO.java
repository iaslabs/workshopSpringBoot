package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.projectBird.domain.model.zone.Zone;
import co.com.ias.projectBird.domain.model.zone.ZoneId;
import co.com.ias.projectBird.domain.model.zone.ZoneName;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "zone")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ZoneDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String zoneName;

	public static ZoneDBO fromDomain(Zone zone){
		return new ZoneDBO(
				zone.getZoneId().getValue(),
				zone.getZoneName().getValue()
		);
	}

	public static Zone toDomain(ZoneDBO zoneDBO){
		return new Zone(
				new ZoneId(zoneDBO.getId()),
				new ZoneName(zoneDBO.getZoneName())
		);
	}
}
