/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.Driver;



/**
 * Classe en charge de gérer la connexion à une base de données de type SQL Server.
 * @author oreade
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */
public class DBConnection {
	
	public static Connection getConnection() throws Exception {
		Connection cnx = null;
		
		try {
			Context jndi = new InitialContext();
			DataSource ds = (DataSource) jndi.lookup("java:comp/env/jdbc/TPJavaEE_GestionFormations");
			cnx = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			throw new Exception("L'accès à la base est impossible pour le moment");
		}
		return cnx;
	}
	
	public static Connection getConnectionWithoutPool() throws SQLException {
			// Chargement du pilote
			DriverManager.registerDriver(new Driver());
			// Ouverture de la connexion
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TPJavaEE_GestionFormations", "root", "");
			return connection;
		}
}