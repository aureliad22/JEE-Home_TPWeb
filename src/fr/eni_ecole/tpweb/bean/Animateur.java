/**
 * @author oreade
 * @date 22 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.bean;

/**
 * @author oreade
 * @date 22 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class Animateur extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut.
	 */
	public Animateur() {
		super();
	}

	/**
	 * Constructeur.
	 * 
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param motdepasse
	 */
	public Animateur(String nom, String prenom, String email, String motdepasse) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setEmail(email);
		this.setMotdepasse(motdepasse);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Animateur [id=");
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
