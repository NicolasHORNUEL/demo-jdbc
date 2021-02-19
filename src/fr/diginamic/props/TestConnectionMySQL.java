package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnectionMySQL {

	public static void main(String[] args) {
		
		ResourceBundle fichierConf = ResourceBundle.getBundle("mySQL");
		String url = fichierConf.getString("mySQL.url");
		String driver = fichierConf.getString("mySQL.driver");
		String user = fichierConf.getString("mySQL.user");
		String password = fichierConf.getString("mySQL.password");
		
		try {
			// ETAPE 1 : charger le driver qui est fourni par la librairie MySQL
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("impossible de charger le driver MySQL");
		}
		
		try {
			// ETAPE2 : je demande au driverManager de me fournir une connexion à une base de type MySQL
			Connection connection = DriverManager.getConnection(url, user, password);
			connection.close();
			System.out.println(connection.isClosed());
			
		} catch (SQLException e) {
			if (e.getErrorCode() == 1045 ) {
				System.out.println("impossible de se connecter à la base de données: " + e.getMessage());
			} else {
				System.out.println("Pb de requête: " + e.getMessage());
			}
		}

	}

}