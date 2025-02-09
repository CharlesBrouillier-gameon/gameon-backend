package fr.gameon.repository;

import fr.gameon.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
}
