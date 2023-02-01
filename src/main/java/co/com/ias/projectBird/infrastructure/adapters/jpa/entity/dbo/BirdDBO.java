package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.bird.BirdCommonName;
import co.com.ias.projectBird.domain.model.bird.BirdId;
import co.com.ias.projectBird.domain.model.bird.BirdScientificName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Bird")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BirdDBO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String commonName;

	private String scientificName;

	@ManyToMany(fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			},
			mappedBy = "birdsList")
	@JsonIgnoreProperties("birdsList")
//	@ManyToMany(mappedBy = "birdsList")
//	@ManyToMany
//	@JoinTable(
//		name = "bird_country",
//		joinColumns = @JoinColumn(name = "bird_id"),
//		inverseJoinColumns = @JoinColumn(name = "country_id"))
	private List<CountryDBO> countriesList;

	public BirdDBO(Long id, String commonName, String scientificName) {
		this.id = id;
		this.commonName = commonName;
		this.scientificName = scientificName;
	}

	public static Bird toDomain(BirdDBO birdDBO){
		return new Bird(
				new BirdCommonName(birdDBO.getCommonName()),
				new BirdId(birdDBO.getId()),
				new BirdScientificName(birdDBO.getScientificName())
		);
	}

	public static BirdDBO fromDomain(Bird bird){
		return new BirdDBO(
				bird.getId().getValue(),
				bird.getName().getValue(),
				bird.getScientificName().getValue()
		);
	}
}
