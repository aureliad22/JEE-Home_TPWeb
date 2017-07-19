/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni_ecole.tpweb.bo.Formation;

/**
 * Classe en charge de gérer la couche d'accès à la BdD
 * 
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
public class DAOFormation implements IDAOBase<Formation, Integer> {

	private static final String RQ_ALL = "SELECT * FROM formations";

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#insert(java.lang.Object)
	 */
	@Override
	public void insert(Formation data) throws Exception {
		// TODO Auto-generated method stub

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
				Formation f = new Formation(rs.getString("libelle"), 
						                    rs.getString("description"), 
						                    rs.getDate("debut"), 
						                    rs.getDate("fin"));
				listeFormations.add(f);				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception("Problème d'affichage des formations à partir de la base TPJavaEE_GestionFormations!");
		}
		return listeFormations;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#getById(java.lang.Object)
	 */
	@Override
	public Formation getById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#update(java.lang.Object)
	 */
	@Override
	public void update(Formation data) throws Exception {
		// TODO Auto-generated method stub

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see fr.eni_ecole.tpweb.dao.IDAOBase#delete(java.lang.Object)
	 */
	@Override
	public void delete(Formation data) throws Exception {
		// TODO Auto-generated method stub

	}

}
