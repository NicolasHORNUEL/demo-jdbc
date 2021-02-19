package fr.diginamic.props;

import java.util.ResourceBundle;

public class TestConfiguration {

	public static void main(String[] args) {
		
		ResourceBundle monFichierConf = ResourceBundle.getBundle("database");
		String driverName = monFichierConf.getString("database.driver");
		
		System.out.println(driverName);

	}

}
