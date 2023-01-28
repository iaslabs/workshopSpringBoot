package co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo;

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
	private List<CountryDBO> countriesList;
}
