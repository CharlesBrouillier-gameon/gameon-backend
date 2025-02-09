package fr.gameon.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameAuthorKey implements Serializable {

    private Long gameId;
    private Long authorId;

    public GameAuthorKey() {
    }

    public GameAuthorKey(Long gameId, Long authorId) {
        this.gameId = gameId;
        this.authorId = authorId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameAuthorKey that = (GameAuthorKey) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(authorId, that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, authorId);
    }
}