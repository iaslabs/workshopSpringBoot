package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.infrastructure.adapters.jpa.IBirdRepositoryAdapter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BirdRepositoryAdapter implements IBirdRepository {

    private final IBirdRepositoryAdapter iBirdRepositoryAdapter;

    @Override
    public Bird saveBird(Bird bird) {
        return null;
    }

    @Override
    public Bird updateBird(Bird bird) {
        return null;
    }

    @Override
    public Bird findBirdById(Long id) {
        return null;
    }

    @Override
    public List<Bird> findAllBirds() {
        return null;
    }

    @Override
    public Boolean deleteBird(Long id) {
        return null;
    }
}
