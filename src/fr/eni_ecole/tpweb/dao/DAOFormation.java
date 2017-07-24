/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni_ecole.tpweb.bean.Formation;
import fr.eni_ecole.tpweb.tools.ManipDate;

/**
 * Classe en charge de gérer la couche d'accès à la BdD
 * 
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class DAOFormation implements IDAOBase<Formation, Integer> {

	private static final String RQ_INSERT = "INSERT INTO formations (libelle, description, debut, fin) VALUES (?,?,?,?)";
	private static final String RQ_UPDATE = "UPDATE formations SET (libelle=?, description=?, debut=?, fin=?) WHERE id = ?";
	private static final String RQ_DELETE = "DELETE FROM formations WHERE id=?";
	private static final String RQ_ALL = "SELECT * FROM formations";
	private static final String RQ_BYID = "SELECT * FROM formations WHERE id=?";


	/**
	 * {@inheritDoc} Methode en charge d'inserer une nouvelle formation a la BdD
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Formation data) throws Exception {
		PreparedStatement cmd = null;

		try (Connection cnx = DBConnection.getConnection()) {
			cmd = cnx.prepareStatement(RQ_INSERT, Statement.RETURN_GENERATED_KEYS);
			cmd.setString(1, data.getLibelle());
			cmd.setString(2, data.getDescription());
			cmd.setDate(3, ManipDate.dateUtilVersSQL(data.getDateDebut()));
			cmd.setDate(4, ManipDate.dateUtilVersSQL(data.getDateFin()));
			cmd.executeUpdate();

			ResultSet rs = cmd.getGeneratedKeys();
			if (rs.next()) {
				data.setId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'insertion de la formation dans la base TPJavaEE_GestionFormations!");
		}
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Formation data) throws Exception {
		PreparedStatement cmd = null;

		try (Connection cnx = DBConnection.getConnection()) {
			cmd = cnx.prepareStatement(RQ_UPDATE);
			cmd.setString(1, data.getLibelle());
			cmd.setString(2, data.getDescription());
			cmd.setDate(3, ManipDate.dateUtilVersSQL(data.getDateDebut()));
			cmd.setDate(4, ManipDate.dateUtilVersSQL(data.getDateFin()));
			cmd.setInt(5, data.getId());
			cmd.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de modification de la formation dans la base TPJavaEE_GestionFormations!");
		}
	}

	/**
	 * {@inheritDoc} Methode en charge de supprimer dans la BdD la formation
	 * sélectionnée.
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#delete(java.lang.Object)
	 */
	@Override
	public void delete(Formation data) throws Exception {
		PreparedStatement cmd = null;
		try (Connection cnx = DBConnection.getConnection()) {
			cmd = cnx.prepareStatement(RQ_DELETE);
			cmd.setInt(1, data.getId());
			cmd.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de suppression de la formation dans la base TPJavaEE_GestionFormations!");
		}
	}
	
	/**
	 * {@inheritDoc} Méthode en charge de retourner l'ensemble des formations a
	 * partir de la BdB
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getAll()
	 */
	@Override
	public List<Formation> getAll() throws Exception {
		List<Formation> listeFormations = new ArrayList<>();

		try (Connection cnx = DBConnection.getConnection()) {
			PreparedStatement cmd = cnx.prepareStatement(RQ_ALL);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				listeFormations.add(formationBuilder(rs));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage des formations à partir de la base TPJavaEE_GestionFormations!");
		}
		return listeFormations;
	}

	/**
	 * {@inheritDoc}
	 * Methode en charge de retourner la formation dont l'identifiant est passé en parametre
	 * @param id identifiant de la formation à retourner
	 * @return Formation
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getById(java.lang.Object)
	 */
	@Override
	public Formation getById(Integer id) throws Exception {
		PreparedStatement cmd = null;
		Formation f = null;
		try(Connection cnx = DBConnection.getConnection()){
			cmd = cnx.prepareStatement(RQ_BYID);
			cmd.setInt(1, id);
			ResultSet rs = cmd.executeQuery();
			
			if(rs.next()){
				 f = formationBuilder(rs);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage de la formation à partir de la base TPJavaEE_GestionFormations!");
		}
		return f;
	}

	/**
	 * Méthode en charge de construire un objet Formation 
	 * à partir des données de la BdD
	 * @param rs
	 * @return Formation
	 * @throws SQLException
	 */
	private Formation formationBuilder(ResultSet rs) throws SQLException {
		Formation f = new Formation();
		f.setLibelle(rs.getString("libelle"));
		f.setDescription(rs.getString("description"));
		f.setDateDebut(rs.getDate("debut"));
		f.setDateFin(rs.getDate("fin"));
		return f;
	}
}
