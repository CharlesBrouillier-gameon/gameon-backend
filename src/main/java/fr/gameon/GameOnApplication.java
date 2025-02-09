package fr.gameon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GameOnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameOnApplication.class, args);
	}

}
