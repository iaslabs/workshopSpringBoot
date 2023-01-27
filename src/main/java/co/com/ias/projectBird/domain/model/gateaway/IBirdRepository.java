package co.com.ias.projectBird.domain.model.gateaway;

import co.com.ias.projectBird.domain.model.bird.Bird;

import java.util.List;

public interface IBirdRepository {

	Bird saveBird(Bird bird);

	Bird updateBird(Bird bird);

	Bird findBirdById(Long id);

	List<Bird> findAllBirds();

	Boolean deleteBird(Long id);

}
