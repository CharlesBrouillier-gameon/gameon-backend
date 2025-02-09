package fr.gameon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Illustrators")
public class IllustratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @ManyToMany(mappedBy = "illustrators")
    @JsonIgnore
    private Set<GameEntity> games = new HashSet<>();

    public IllustratorEntity() {
    }

    public IllustratorEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public IllustratorEntity(Long id, String name, Set<GameEntity> games) {
        this.id = id;
        this.name = name;
        this.games = games;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GameEntity> getGames() {
        return games;
    }

    public void setGames(Set<GameEntity> games) {
        this.games = games;
    }
}
