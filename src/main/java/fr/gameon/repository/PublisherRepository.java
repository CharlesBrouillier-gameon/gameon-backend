package fr.gameon.repository;

import fr.gameon.entity.PublisherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<PublisherEntity, Long> {
}
