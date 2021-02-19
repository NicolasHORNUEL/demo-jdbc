package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TestLecture {

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
			Statement statement = connection.createStatement();
			//int resultat = statement.executeUpdate("INSERT INTO genre (nom_genre) VALUES ('Fantastique')");
			ResultSet curseur = statement.executeQuery("SELECT * FROM abonne WHERE ville = 'MONTPELLIER' ORDER BY nom, prenom");
			List<Abonne> liste = new ArrayList<>();
			while (curseur.next()) {
				String prenom = curseur.getString("prenom");
				String nom = curseur.getString("nom");
				Date date_naissance = curseur.getDate("date_naissance");
				String adresse = curseur.getString("adresse");
				Integer code_postal = curseur.getInt("code_postal");
				String ville = curseur.getString("ville");
				Date date_inscription = curseur.getDate("date_inscription");
				Date date_fin_abo = curseur.getDate("date_fin_abo");
				Abonne abonne = new Abonne(prenom, nom, date_naissance, adresse, code_postal, ville, date_inscription, date_fin_abo);
				liste.add(abonne);
				System.out.println(abonne);
			}
			// Fermeture dans l'ordre inverse d'ouverture
			curseur.close();
			statement.close();
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
