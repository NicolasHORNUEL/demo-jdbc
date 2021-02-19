package fr.diginamic.props;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TestConnectionCleverCloud {

	public static void main(String[] args) {
		
		ResourceBundle fichierConf = ResourceBundle.getBundle("cleverCloud");
		String url = fichierConf.getString("MYSQL_ADDON_URI");
		String driver = fichierConf.getString("MYSQL_ADDON_DRIVER");
		String user = fichierConf.getString("MYSQL_ADDON_USER");
		String password = fichierConf.getString("MYSQL_ADDON_PASSWORD");
		
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