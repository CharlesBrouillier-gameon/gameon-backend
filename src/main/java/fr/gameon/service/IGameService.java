package fr.gameon.service;

import fr.gameon.entity.GameEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IGameService {
    public List<GameEntity> getGames();
    public ResponseEntity<GameEntity> getGameById(Long id);
    public ResponseEntity<GameEntity> getGameBySlug(String slug);
    public List<GameEntity> getGamesByFilters(Double minPrice, Double maxPrice, Integer minPlayers, Integer maxPlayers, Integer minDuration, Integer maxDuration, List<Integer> mechanisms, Integer mechanismsSize);
    public List<GameEntity> getGamesByMechanismId(String mechanismId);
    public List<GameEntity> findGamesWithMechanisms(String GameId);
    public ResponseEntity<GameEntity> createGame(GameEntity gameEntity);
    public ResponseEntity<GameEntity> updateGame(Long id, GameEntity gameEntity);
    public void deleteGame(Long id);
}
