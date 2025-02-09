package fr.gameon.key;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class GameIllustratorKey implements Serializable {

    private Long gameId;
    private Long illustratorId;

    public GameIllustratorKey() {
    }

    public GameIllustratorKey(Long gameId, Long illustratorId) {
        this.gameId = gameId;
        this.illustratorId = illustratorId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getIllustratorId() {
        return illustratorId;
    }

    public void setIllustratorId(Long illustratorId) {
        this.illustratorId = illustratorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameIllustratorKey that = (GameIllustratorKey) o;
        return Objects.equals(gameId, that.gameId) && Objects.equals(illustratorId, that.illustratorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, illustratorId);
    }
}