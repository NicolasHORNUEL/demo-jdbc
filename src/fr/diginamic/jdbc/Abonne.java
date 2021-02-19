package fr.diginamic.jdbc;

import java.sql.Date;

public class Abonne {

	private String prenom;
	private String nom;
	private Date date_naissance;
	private String Adresse;
	private Integer code_postal;
	private String ville;
	private Date date_inscription;
	private Date date_fin_abo;
	/**
	 * @param prenom
	 * @param nom
	 * @param date_naissance
	 * @param adresse
	 * @param code_postal
	 * @param ville
	 * @param date_inscription
	 * @param date_fin_abo
	 */
	public Abonne(String prenom, String nom, Date date_naissance, String adresse, Integer code_postal, String ville,
			Date date_inscription, Date date_fin_abo) {
		this.prenom = prenom;
		this.nom = nom;
		this.date_naissance = date_naissance;
		this.Adresse = adresse;
		this.code_postal = code_postal;
		this.ville = ville;
		this.date_inscription = date_inscription;
		this.date_fin_abo = date_fin_abo;
	}
	@Override
	public String toString() {
		return "Abonne : " + prenom + nom + ", date_naissance : " + date_naissance + ", Adresse : "
				+ Adresse + " " + code_postal + " " + ville + ", date_inscription : "
				+ date_inscription + ", date_fin_abo : " + date_fin_abo;
	}
	
	
}
