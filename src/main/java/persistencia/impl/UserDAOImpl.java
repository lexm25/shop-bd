package persistencia.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import persistencia.UserDAO;

public class UserDAOImpl implements UserDAO {

	@Override
	public boolean login(String username, String password) {
		boolean loginSuccess=false;
		Connection conexion = getConection();
		
		String sql = "SELECT * FROM Users WHERE username = ? AND password = ?;";
		
		PreparedStatement sentencia;
		try {
			sentencia = conexion.prepareStatement(sql);
			sentencia.setString(1, username);
			sentencia.setString(2, password);
			ResultSet resultado = sentencia.executeQuery();
			loginSuccess = resultado.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return loginSuccess;
	}

	private Connection getConection() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:6033/shop","developer","programaciondaw");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
	}
}
