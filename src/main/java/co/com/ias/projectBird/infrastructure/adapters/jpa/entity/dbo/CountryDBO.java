package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.projectBird.domain.model.country.Country;
import co.com.ias.projectBird.domain.model.country.CountryId;
import co.com.ias.projectBird.domain.model.country.CountryName;
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

	public CountryDBO(Long id, String countryName) {
		this.id = id;
		this.countryName = countryName;
	}

	public static CountryDBO fromDomain(Country country){
		return new CountryDBO(
				country.getId().getValue(),
				country.getCountryName().getValue()
		);
	}

	public static Country toDomain(CountryDBO countryDBO){
		return new Country(
				new CountryId(countryDBO.getId()),
				new CountryName(countryDBO.getCountryName())
		);
	}
}
