package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Country")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CountryDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String countryName;

	@ManyToOne
	@JoinColumn(name = "zone_id")
	private ZoneDBO countryZone;

	@ManyToMany
	@JoinTable(
			name = "birds_list",
			joinColumns = @JoinColumn(name = "bird_id"),
			inverseJoinColumns = @JoinColumn(name = "country_id"))
	@JsonIgnoreProperties("countriesList")
	private List<BirdDBO> birdsList;
}
