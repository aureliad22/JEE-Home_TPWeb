/**
 * @author oreade
 * @date 19 juil. 2017
 * @version Home_TPWeb V1.0
 */
package fr.eni_ecole.tpweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;



/**
 * Classe en charge de gérer la connexion à une base de données de type SQL Server.
 * @author oreade
 * @date 18 juil. 2017
 * @version DemoServlet V1.0
 */
public class DBConnection {
	
	public static Connection getConnection() throws SQLException {
			// Chargement du pilote
			DriverManager.registerDriver(new Driver());
			// Ouverture de la connexion
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://Server/TPJavaEE_GestionFormations", "username", "password");
			return connection;
		}
}