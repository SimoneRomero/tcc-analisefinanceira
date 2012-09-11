package br.unioeste.foz.cc.tcc.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConexaoSingleton {

	private static Connection con;

	public static Connection getInstance() throws SQLException, FileNotFoundException, IOException {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("dbconnection.properties"));
			Class.forName(properties.getProperty("driver"));
			con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
			return con;
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}

	public static void main(String[] args) throws SQLException {
		QueryMakerSingleton q = QueryMakerSingleton.getInstance();

		ResultSet rsRua = q.select("ATRIBUTO");

		JOptionPane.showMessageDialog(null, rsRua.getString(2));
	}
}