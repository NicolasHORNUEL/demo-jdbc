package fr.diginamic.props;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class TestConfiguration {

	public static void main(String[] args) {
		
		ResourceBundle monFichierConf = ResourceBundle.getBundle("mySQL");
		String driverName = monFichierConf.getString("mySQL.driver");
		
		System.out.println(driverName);

		// get the keys
		Enumeration<String> keys = monFichierConf.getKeys();

		// print all the keys
		while (keys.hasMoreElements()) { 
			String key = keys.nextElement();
			String valeur = monFichierConf.getString(key);
			System.out.println(key + " = " + valeur);
		}

	}

}
