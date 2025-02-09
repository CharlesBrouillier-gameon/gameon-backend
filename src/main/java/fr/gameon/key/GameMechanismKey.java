package fr.gameon.key;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameMechanismKey implements Serializable {

    private Long gameId;
    private Long mechanismId;

    public GameMechanismKey() {
    }

    public GameMechanismKey(Long gameId, Long mechanismId) {
        this.gameId = gameId;
        this.mechanismId = mechanismId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getMechanismId() {
        return mechanismId;
    }

    public void setMechanismId(Long mechanismId) {
        this.mechanismId = mechanismId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameMechanismKey that = (GameMechanismKey) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(mechanismId, that.mechanismId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, mechanismId);
    }
}