package fr.gameon.controller;

import fr.gameon.entity.GameEntity;
import fr.gameon.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameEntity> getGames() {
        return gameService.getGames();
    }

    @GetMapping("/{value}")
    public ResponseEntity<GameEntity> getGameByIdOrSlug(@PathVariable String value) {
        try {
            Long id = Long.parseLong(value);
            return gameService.getGameById(id);
        } catch (NumberFormatException e) {
            return gameService.getGameBySlug(value);
        }
    }

    @GetMapping("/filter")
    public ResponseEntity<List<GameEntity>> getFilteredGames(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice,
            @RequestParam(required = false) Integer minPlayers,
            @RequestParam(required = false) Integer maxPlayers,
            @RequestParam(required = false) Integer minDuration,
            @RequestParam(required = false) Integer maxDuration,
            @RequestParam(required = false) List<Integer> mechanisms) {

        if (mechanisms != null && mechanisms.isEmpty()) {
            mechanisms = null;
        }

        Integer mechanismsSize = (mechanisms != null) ? mechanisms.size() : 0;
        List<GameEntity> filteredGames = gameService.getGamesByFilters(minPrice, maxPrice, minPlayers, maxPlayers, minDuration, maxDuration, mechanisms, mechanismsSize);
        return ResponseEntity.ok(filteredGames);
    }

    @GetMapping("/byMechanism/{gameId}")
    public ResponseEntity<List<GameEntity>> getGamesByMechanismId(@PathVariable String mechanismId) {
        List<GameEntity> games = gameService.getGamesByMechanismId(mechanismId);
        return ResponseEntity.ok(games);
    }

    @GetMapping("/withMechanisms/{gameId}")
    public ResponseEntity<List<GameEntity>> findGamesWithMechanisms(@PathVariable String gameId) {
        List<GameEntity> filteredGames = gameService.findGamesWithMechanisms(gameId);
        return ResponseEntity.ok(filteredGames);
    }

    @PostMapping
    public ResponseEntity<GameEntity> createGame(@RequestBody GameEntity game) {
        return gameService.createGame(game);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GameEntity> updateGame(@PathVariable Long id, @RequestBody GameEntity game) {
        return gameService.updateGame(id, game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
    }
}
