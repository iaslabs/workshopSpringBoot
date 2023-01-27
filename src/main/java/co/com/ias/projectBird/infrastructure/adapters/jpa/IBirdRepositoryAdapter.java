package co.com.ias.projectBird.infrastructure.adapters.jpa;

import co.com.ias.projectBird.domain.model.bird.dto.BirdDTO;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.BirdDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBirdRepositoryAdapter extends JpaRepository<BirdDBO, Long> {

}
