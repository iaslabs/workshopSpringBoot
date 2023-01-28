package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

import jakarta.persistence.*;
import lombok.*;

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

}
