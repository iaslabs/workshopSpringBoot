package co.com.ias.projectBird.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import co.com.ias.projectBird.domain.model.bird.Bird;
import co.com.ias.projectBird.domain.model.gateaway.IBirdRepository;
import co.com.ias.projectBird.infrastructure.adapters.jpa.IBirdRepositoryAdapter;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.BirdDBO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class BirdRepositoryAdapter implements IBirdRepository {

    private final IBirdRepositoryAdapter iBirdRepositoryAdapter;

    @Override
    public Bird saveBird(Bird bird) {
        BirdDBO birdSaved = iBirdRepositoryAdapter.save(BirdDBO.fromDomain(bird));
        return BirdDBO.toDomain(birdSaved);

    }

    @Override
    public Bird updateBird(Bird bird) {
        BirdDBO dbo = BirdDBO.fromDomain(bird);
        Optional<BirdDBO> elementFound = iBirdRepositoryAdapter.findById(dbo.getId());
        if(elementFound.isEmpty()){
            throw new NullPointerException("No existe pájaro con el id: " + bird.getId().getValue());

        } else {
            BirdDBO birdSaved =  iBirdRepositoryAdapter.save(dbo);
            return BirdDBO.toDomain(birdSaved);
        }
    }

    @Override
    public Bird findBirdById(Long id) {
        Optional<BirdDBO> dbo = iBirdRepositoryAdapter.findById(id);
        if (dbo.isEmpty()){
            throw new NullPointerException("No existe pájaro con el id: " + id);
        } else {
            return BirdDBO.toDomain(dbo.get());
        }
    }

    @Override
    public List<Bird> findAllBirds() {
        return iBirdRepositoryAdapter.findAll().stream().map(BirdDBO::toDomain).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteBird(Long id) {
        AtomicReference<Boolean> bool = new AtomicReference<>(false);
        Optional<BirdDBO> dbo = iBirdRepositoryAdapter.findById(id);
        dbo.ifPresent(value->{
            iBirdRepositoryAdapter.deleteById(id);
            bool.set(true);
        });
        return bool.get();
    }
}
