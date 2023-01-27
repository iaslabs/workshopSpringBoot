package co.com.ias.projectBird.infrastructure.adapters.jpa;

import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.BirdDBO;
import co.com.ias.projectBird.infrastructure.adapters.jpa.entity.dbo.ZoneDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IZoneRepositoryAdapter extends JpaRepository<ZoneDBO, Long> {
}
