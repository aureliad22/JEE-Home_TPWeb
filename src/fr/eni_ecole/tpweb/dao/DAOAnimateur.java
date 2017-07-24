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

import fr.eni_ecole.tpweb.bean.Animateur;

/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class DAOAnimateur implements IDAOBase<Animateur, Integer>{
	
	private static final String RQ_INSERT = "INSERT INTO animateurs (nom, prenom, email, motdepasse) VALUES (?,?,?,?)";
	private static final String RQ_UPDATE = "UPDATE animateurs SET (nom=?, prenom=?, email=?, motdepasse=?) WHERE id = ?";
	private static final String RQ_DELETE = "DELETE FROM animateurs WHERE id=?";
	private static final String RQ_ALL = "SELECT * FROM animateurs";
	private static final String RQ_BYID = "SELECT * FROM animateurs WHERE id=?";
	
	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Animateur anim) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_INSERT, Statement.RETURN_GENERATED_KEYS);
			stm.setString(1,  anim.getNom());
			stm.setString(2, anim.getPrenom());
			stm.setString(3, anim.getEmail());
			stm.setString(4, anim.getMotdepasse());
			stm.executeUpdate();
			
			ResultSet rs = stm.getGeneratedKeys();
			if(rs.next()){
				anim.setId(rs.getInt(1));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'insertion de l'animateur dans la base TPJavaEE_GestionFormations!");
		}		
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Animateur anim) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_UPDATE);
			stm.setString(1,  anim.getNom());
			stm.setString(2, anim.getPrenom());
			stm.setString(3, anim.getEmail());
			stm.setString(4, anim.getMotdepasse());
			stm.setInt(5, anim.getId());
			stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de modification de l'animateur dans la base TPJavaEE_GestionFormations!");
		}			
	}

	/**
	 * En charge de supprimer l'animateur passé en parametre
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#delete(java.lang.Object)
	 * @param Animateur
	 */
	@Override
	public void delete(Animateur anim) throws Exception {
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_DELETE);
			stm.setInt(1, anim.getId());
			stm.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème de suppression de l'animateur dans la base TPJavaEE_GestionFormations!");
		}		
	}

	/**
	 * Methode en charge de retourner l'ensemble des animateurs 
	 * a partir de la BdD
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getAll()
	 */
	@Override
	public List<Animateur> getAll() throws Exception {
		List<Animateur> listeAnimateurs = new ArrayList<>();
		
		try(Connection cnx = DBConnection.getConnection()){
			PreparedStatement stm = cnx.prepareStatement(RQ_ALL);
			ResultSet rs = stm.executeQuery();
			
			if(rs.next()){
				listeAnimateurs.add(animateurBuilder(rs));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage des animateurs à partir de la base TPJavaEE_GestionFormations!");
		}
		return listeAnimateurs;
	}

	/**
	 * Méthode en charge de construire un objet de type Animateur
	 * @param rs ResultSet
	 * @return un Animateur
	 * @throws SQLException 
	 */
	private Animateur animateurBuilder(ResultSet rs) throws SQLException {
		Animateur anim = new Animateur();
		anim.setNom(rs.getString("nom"));
		anim.setPrenom(rs.getString("prenom"));
		anim.setEmail(rs.getString("email"));
		anim.setMotdepasse(rs.getString("motdepasse"));
		
		return anim;
	}

	/**
	 * {@inheritDoc}
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getById(java.lang.Object)
	 */
	@Override
	public Animateur getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
