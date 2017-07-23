/**
 * @author oreade
 * @date 22 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.bean;

import java.io.Serializable;

/**
 * @author oreade
 * @date 22 juil. 2017
 * @version Home_TPWeb V1.0
 */
public abstract class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String motdepasse;
	
	/**
	 * Constructeur par défaut.
	 */
	public User(){
		
	}

	/**
	 * Méthode en charge de retourner vrai si login donné = email enregistré et
	 * password donné = mot de passe enregistré
	 * 
	 * @param login:
	 *            email à verifier
	 * @param password:
	 *            mot de passe à vérifier
	 * @return true si login = email et password = mot de passe
	 */
	public boolean validation(String login, String password) {
		boolean valid = false;
		if (login == null) {
			System.out.println("Renseignez l'identifiant");
		} else if (password == null) {
			System.out.println("Mot de passe obligatoire");
		} else {
			if (login.equals(getEmail()) && password.equals(getMotdepasse())) {
				valid = true;
			}
		}
		return valid;
	}

	/**
	 * Getter pour id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id.
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour nom.
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour nom.
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter pour prenom.
	 * 
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter pour prenom.
	 * 
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter pour email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter pour email.
	 * 
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Getter pour motdepasse.
	 * 
	 * @return the motdepasse
	 */
	public String getMotdepasse() {
		return motdepasse;
	}

	/**
	 * Setter pour motdepasse.
	 * 
	 * @param motdepasse the motdepasse to set
	 */
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
}