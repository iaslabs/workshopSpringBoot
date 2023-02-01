package co.com.ias.projectBird.domain.model.gateaway;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.country.Country;

import java.util.List;

public interface IBirdRepository {

	Bird saveBird(Bird bird, List<Country> countries);

	Bird updateBird(Bird bird);

	Bird findBirdById(Long id);

	List<Bird> findAllBirds();

	Boolean deleteBird(Long id);

}
