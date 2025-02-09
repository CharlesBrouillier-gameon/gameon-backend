package fr.gameon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Game_Images")
public class GameImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    @JsonIgnore
    private GameEntity game;

    public GameImageEntity() {
    }

    public GameImageEntity(Long id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public GameImageEntity(Long id, String imageUrl, GameEntity game) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }
}