package fr.gameon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Publishers")
public class PublisherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private Set<GameEntity> games = new HashSet<>();

    public PublisherEntity() {
    }

    public PublisherEntity(Long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public PublisherEntity(Long id, String name, String url, Set<GameEntity> games) {
        this.id = id;
        this.name = name;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<GameEntity> getGames() {
        return games;
    }

    public void setGames(Set<GameEntity> games) {
        this.games = games;
    }
}
