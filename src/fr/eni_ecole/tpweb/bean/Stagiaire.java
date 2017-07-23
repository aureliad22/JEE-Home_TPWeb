/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.bean;

/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class Stagiaire extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut.
	 */
	public Stagiaire() {
		super();
	}

	/**
	 * Constructeur.
	 * 
	 * @param email
	 * @param motdepasse
	 */
	public Stagiaire(String email, String motdepasse) {
		super();
		this.setEmail(email);
		this.setMotdepasse(motdepasse);
	}

	/**
	 * Constructeur.
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motdepasse
	 */
	public Stagiaire(String nom, String prenom, String email, String motdepasse) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stagiaire [id=");
		builder.append(getId());
		builder.append(", nom=");
		builder.append(getNom());
		builder.append(", prenom=");
		builder.append(getPrenom());
		builder.append(", email=");
		builder.append(getEmail());
		builder.append(", motdepasse=");
		builder.append(getMotdepasse());
		builder.append("]");
		return builder.toString();
	}
}
