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
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import fr.eni_ecole.tpweb.bean.Stagiaire;

/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class DAOStagiaire implements IDAOBase<Stagiaire, Integer>{

	private static final String RQ_INSERT = "INSERT INTO stagiaires (nom, prenom, email, motdepasse) VALUES (?,?,?,?)";
	private static final String RQ_UPDATE = "UPDATE stagiaires SET (nom=?, prenom=?, email=?, motdepasse=?) WHERE id = ?";
	private static final String RQ_DELETE = "DELETE FROM stagiaires WHERE id=?";
	private static final String RQ_ALL = "SELECT * FROM stagiaires";
	private static final String RQ_BYID = "SELECT * FROM stagiaires WHERE id=?";
	
	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Stagiaire data) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_INSERT, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1,  data.getNom());
			stm.setString(2, data.getPrenom());
			stm.setString(3, data.getEmail());
			stm.setString(4, data.getMotdepasse());
			stm.executeUpdate();
			
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()){
				data.setId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'insertion du stagiaire dans la base TPJavaEE_GestionFormations!");
		}			
	}
	
	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Stagiaire data) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_UPDATE);
			stm.setString(1,  data.getNom());
			stm.setString(2, data.getPrenom());
			stm.setString(3, data.getEmail());
			stm.setString(4, data.getMotdepasse());
			stm.setInt(5, data.getId());
			stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de modification du stagiaire dans la base TPJavaEE_GestionFormations!");
		}			
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#delete(java.lang.Object)
	 */
	@Override
	public void delete(Stagiaire data) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_DELETE);
			stm.setInt(1, data.getId());
			stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de suppression du stagiaire dans la base TPJavaEE_GestionFormations!");
		}			
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getAll()
	 */
	@Override
	public List<Stagiaire> getAll() throws Exception {
		List<Stagiaire> listeStagiaires = new ArrayList<>();
		
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_ALL);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				listeStagiaires.add(stagiaireBuilder(rs));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage des stagiaires à partir de la base TPJavaEE_GestionFormations!");
		}
		return listeStagiaires;
	}

	/**
	 * Méthode en charge de construire un objet de type Stagiaire
	 * @param rs ResultSet
	 * @return un Animateur
	 * @throws SQLException 
	 */
	private Stagiaire stagiaireBuilder(ResultSet rs) throws SQLException {
		Stagiaire stagiaire = new Stagiaire();
		stagiaire.setNom(rs.getString("nom"));
		stagiaire.setPrenom(rs.getString("prenom"));
		stagiaire.setEmail(rs.getString("email"));
		stagiaire.setMotdepasse(rs.getString("motdepasse"));
		
		return stagiaire;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getById(java.lang.Object)
	 */
	@Override
	public Stagiaire getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
