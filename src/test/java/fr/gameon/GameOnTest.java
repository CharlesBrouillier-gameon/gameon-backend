package fr.gameon;

import fr.gameon.entity.*;
import fr.gameon.exception.ResourceNotFoundException;
import fr.gameon.repository.*;
import fr.gameon.service.GameService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameOnTest {

	@Mock
	private GameRepository gameRepository;
	@Mock
	private IllustratorRepository illustratorRepository;
	@Mock
	private MechanismRepository mechanismRepository;
	@Mock
	private AuthorRepository authorRepository;
	@Mock
	private GameImageRepository gameImageRepository;
	@Mock
	private PublisherRepository publisherRepository;

	private GameService gameService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		gameService = new GameService(gameRepository, illustratorRepository, mechanismRepository,
				authorRepository, gameImageRepository, publisherRepository);
	}

	@Test
	void getGameById_ok() {
		Long gameId = 1L;
		GameEntity game = new GameEntity();
		game.setId(gameId);

		when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

		ResponseEntity<GameEntity> response = gameService.getGameById(gameId);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(gameId, response.getBody().getId());
	}

	@Test
	void getGameById_ko() {
		Long gameId = 1L;

		when(gameRepository.findById(gameId)).thenReturn(Optional.empty());

		ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () ->
				gameService.getGameById(gameId)
		);

		assertEquals("Game not found with id : 1", exception.getMessage());
	}

	@Test
	void createGame_ok() {
		GameEntity game = new GameEntity();
		game.setName("New Game");
		game.setSlug("new-game");
		game.setPrice(30.0);

		GameEntity savedGame = new GameEntity();
		savedGame.setId(1L);
		savedGame.setName("New Game");

		when(gameRepository.save(any(GameEntity.class))).thenReturn(savedGame);

		ResponseEntity<GameEntity> response = gameService.createGame(game);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1L, response.getBody().getId());
		assertEquals("New Game", response.getBody().getName());
	}

	@Test
	void deleteGame_ok() {
		Long gameId = 1L;
		GameEntity game = new GameEntity();
		game.setId(gameId);

		when(gameRepository.findById(gameId)).thenReturn(Optional.of(game));

		gameService.deleteGame(gameId);

		verify(gameRepository, times(1)).delete(game);
	}

	@Test
	void deleteGame_ko() {
		Long gameId = 1L;

		when(gameRepository.findById(gameId)).thenReturn(Optional.empty());

		EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () ->
				gameService.deleteGame(gameId)
		);

		assertEquals("Game not found with id: 1", exception.getMessage());
	}
}
