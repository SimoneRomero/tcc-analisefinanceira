package br.unioeste.foz.cc.tcc.infra;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;

public class QueryMakerSingleton {

	private Connection conn;

	private static QueryMakerSingleton qm = null;

	private PreparedStatement setValue(PreparedStatement ps, Object value, Integer position) throws SQLException {
		String class_name = value.getClass().getName();
		if (class_name == "java.lang.Integer") {
			ps.setInt(position,(Integer)value);
		}
		if (class_name == "java.lang.String") {
			ps.setString(position,(String)value);
		}
		if (class_name == "java.sql.Date") {
			ps.setDate(position,(Date)value);
		}
		if (class_name == "java.sql.Time") {
			ps.setTime(position,(Time)value);
		}
		if (class_name == "java.sql.Timestamp") {
			ps.setTimestamp(position,(Timestamp)value);
		}
		if (class_name == "java.lang.Float") {
			ps.setFloat(position,(Float)value);
		}
		if (class_name == "java.lang.Double") {
			ps.setDouble(position,(Double)value);
		}
		if (class_name == "java.lang.Boolean") {
			ps.setBoolean(position,(Boolean)value);
		}
		return ps;

	}

	private QueryMakerSingleton() throws SQLException{
		try {
			conn = ConexaoSingleton.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static QueryMakerSingleton getInstance() throws SQLException{
		if (qm == null) {
			qm = new QueryMakerSingleton();
		}
		return qm;
	}

	public ResultSet select(String table, String columns) throws SQLException{
		String sql_st = String.format("SELECT %s FROM %s;", columns, table);
		ResultSet result = conn.prepareStatement(sql_st).executeQuery();
		result.next();
		return result;
	}

	public ResultSet select(String table) throws SQLException{
		String sql_st = String.format("SELECT * FROM %s;",table);
		ResultSet result = conn.prepareStatement(sql_st).executeQuery();
		result.next();
		return result;
	}

	public ResultSet selectWhere(String table, String columns, String condition, Object value) throws SQLException{
		String sql_st = String.format("SELECT %s FROM %s WHERE %s;", columns, table, condition);
		PreparedStatement ps = conn.prepareStatement(sql_st);
		ps = setValue(ps, value, 1);
		ResultSet result = ps.executeQuery();
		result.next();
		return result;
	}

	public void deleteWhere(String table, String condition, int value) throws SQLException{
		String sql_st = String.format("DELETE FROM %s WHERE %s;", table, condition);
		PreparedStatement ps = conn.prepareStatement(sql_st);
		ps = setValue(ps, value, 1);
		ps.executeUpdate();
	}

	public ResultSet selectAllWhere(String table, String condition, Object value) throws SQLException{
		String sql_st = String.format("SELECT * FROM %s WHERE %s;", table, condition);
		PreparedStatement ps = conn.prepareStatement(sql_st);
		ps = setValue(ps, value, 1);
		ResultSet result = ps.executeQuery();
		result.next();
		return result;
	}

	public int selectSequence(String sequence) throws SQLException{
		String sql_st = String.format("SELECT nextval('%s');", sequence);
		PreparedStatement ps = conn.prepareStatement(sql_st);
		ResultSet result = ps.executeQuery();
		result.next();
		return result.getInt(1);
	}

	public Integer insert(String table, String columns, Object[] values) throws SQLException {
		String str_values = "";
		for (Integer i = 0; i < values.length-1; i++){
			str_values += "?,";
		}
		str_values += "?";
		String sql_st = String.format("INSERT INTO %s(%s) VALUES (%s)", table, columns, str_values);
		PreparedStatement ps = conn.prepareStatement(sql_st,Statement.RETURN_GENERATED_KEYS);

		for (Integer i = 0; i < values.length; i++){
			ps = setValue(ps,values[i],i+1);
		}

		ps.execute();
		return (Integer) values[0];
	}

	public Integer updateWhere(String table, String[] columns, String condition,
							   Object[] values, Object condition_value) throws SQLException{
		String str_values = "";
		Integer i;
		for (i = 0; i < values.length-1; i++){
			str_values += columns[i]+" = ?, ";
		}
		str_values += columns[i]+" = ? ";
		String sql_st = String.format("UPDATE %s SET %s WHERE %s", table, str_values, condition);
		PreparedStatement ps = conn.prepareStatement(sql_st);

		for (i = 0; i < values.length; i++){
			ps = setValue(ps,values[i],i+1);
		}
		ps = setValue(ps, condition_value, values.length+1);

		ps.execute();
		return ps.getUpdateCount();
	}

	public int countResultSet(String table) throws SQLException{
		String sql_st = String.format("SELECT COUNT(*) FROM %s;", table);
		PreparedStatement ps = conn.prepareStatement(sql_st);
		ResultSet result = ps.executeQuery();
		result.next();
		return result.getInt(1);
	}
}
