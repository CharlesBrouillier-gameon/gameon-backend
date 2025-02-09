package fr.gameon.repository;

import fr.gameon.entity.MechanismEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanismRepository extends JpaRepository<MechanismEntity, Long> {
}
