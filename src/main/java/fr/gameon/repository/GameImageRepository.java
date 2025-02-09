package fr.gameon.repository;

import fr.gameon.entity.GameImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameImageRepository extends JpaRepository<GameImageEntity, Long> {
}
