package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class UtilsBD {
	public static Connection ConectarBD() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/starwars", "root", "usuario");

			return con;
		} catch (Exception e) {
			// el printStackTrace muestra el error de la excepcion si ocurre el error
			e.printStackTrace();
		}
		return null;
	}

}
