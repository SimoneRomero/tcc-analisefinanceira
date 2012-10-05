package br.unioeste.foz.cc.tcc.infra;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexaoSingleton {

	private static Connection con;

	public static Connection getInstance() throws SQLException,
			FileNotFoundException, IOException, ClassNotFoundException {
		Properties properties = new Properties();
		properties.load(ConexaoSingleton.class
				.getResourceAsStream("dbconnection.properties"));
		Class.forName(properties.getProperty("driver"));
		con = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("username"),
				properties.getProperty("password"));
		return con;

	}
}