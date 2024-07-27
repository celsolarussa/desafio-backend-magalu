package tech.buildrun.magalums.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnectionChecker {

	private String dbHost;
	private String dbName;
	private String user;
	private String pass;
	private final Logger LOGGER = Logger.getLogger(DatabaseConnectionChecker.class.getName());

	public DatabaseConnectionChecker(String dbHost, String dbName, String user, String pass) {
		this.dbHost = dbHost;
		this.dbName = dbName;
		this.user = user;
		this.pass = pass;
	}

	public void checkDatabaseConnection() {
		boolean isConnected = false;
		int attempt = 0;
		String dbUrl = "jdbc:mysql://" + this.dbHost + ":3306/" + this.dbName;

		while (!isConnected && attempt < 30) {
			try (Connection conn = DriverManager.getConnection(dbUrl, this.user, this.pass)) {
				LOGGER.info("Successfully connected to the database.");
				isConnected = true; // Atualiza o status de isConnected para true após uma conexão bem-sucedida
			} catch (SQLException e) {
				LOGGER.warning("Attempt " + (attempt + 1) + ": Waiting for database to become available...");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException ie) {
					Thread.currentThread().interrupt();
					LOGGER.severe("Thread interrupted while waiting for database");
					break; // Sai do loop se a thread for interrompida
				}
			}
			attempt++;
		}

		if (!isConnected) {
			LOGGER.severe("Failed to connect to the database after " + attempt + " attempts.");
		}
	}
}