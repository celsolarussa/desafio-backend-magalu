package tech.buildrun.magalums;

import io.github.cdimascio.dotenv.Dotenv;
import tech.buildrun.magalums.config.DatabaseConnectionChecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MagalumsApplication {

	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure().ignoreIfMalformed().ignoreIfMissing().load();
		System.getProperties().putAll(System.getenv());
		System.setProperty("DB_HOST", dotenv.get("DB_HOST"));
		System.setProperty("DB_NAME", dotenv.get("DB_NAME"));
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

		DatabaseConnectionChecker databaseChecker = new DatabaseConnectionChecker(
				System.getProperty("DB_HOST"),
				System.getProperty("DB_NAME"),
				System.getProperty("DB_USER"),
				System.getProperty("DB_PASSWORD"));

		databaseChecker.checkDatabaseConnection();

		SpringApplication.run(MagalumsApplication.class, args);
	}

}
