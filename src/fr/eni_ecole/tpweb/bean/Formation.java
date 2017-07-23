/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.bean;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class Formation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String libelle;
	private String description;
	private Date dateDebut;
	private Date dateFin;
	
	/**
	 * Constructeur vide.
	 */
	public Formation() {
		super();
	}

	/**
	 * Constructeur.
	 * @param libelle
	 * @param description
	 * @param dateDebut
	 * @param dateFin
	 */
	public Formation(String libelle, String description, Date dateDebut,
			Date dateFin) {
		super();
		this.setLibelle(libelle);
		this.setDescription(description);
		this.setDateDebut(dateDebut);
		this.setDateFin(dateFin);
	}

	/**
	 * {@inheritDoc}
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Formation [id=");
		builder.append(id);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append(", description=");
		builder.append(description);
		builder.append(", dateDebut=");
		builder.append(dateDebut);
		builder.append(", dateFin=");
		builder.append(dateFin);
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Getter pour id.
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour id.
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour libelle.
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter pour libelle.
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter pour description.
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Setter pour description.
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Getter pour dateDebut.
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter pour dateDebut.
	 * @param dateDebut the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter pour dateFin.
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Setter pour dateFin.
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
}
