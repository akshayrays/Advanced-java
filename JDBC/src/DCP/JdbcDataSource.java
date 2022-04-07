package DCP;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
//import com.mysql.jdbc.Statement;

//import com.mysql.jdbc.Connection;

public final class JdbcDataSource {

	// JDBC Datasource static object
	private static JdbcDataSource jds = null;

	// c3P0 database connection pool
	private ComboPooledDataSource ds = null;

	// Make default constructor private
	private JdbcDataSource() {
		try {
			// Create data sourcee
			ds = new ComboPooledDataSource();
			// Set DS Properties
			ds.setDriverClass("com.mysql.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/dhoom");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(2);
			ds.setAcquireIncrement(1);
			ds.setMaxPoolSize(3);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	// get singleton class instance
	public static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	// gets connection from DCP
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		} catch (SQLException e) {

			return null;
		}
	}

	// Close Connection
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Close connection
	public static void closeconnection(Connection conn, Statement stmt) {
		closeConnection(conn, stmt, null);
	}

	// close connection
	public static void closeConnection(Connection conn) {
		closeConnection(conn, null, null);

		// Now let's get a connection from JdbcDatasource and execute a query:

	}

	public static void main(String[] args) throws Exception {
		testSelect();
		// testInsert();
	}

	private static void testSelect() throws Exception {
		Connection conn = JdbcDataSource.getConnection();

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("Select * from marksheet2");
		// ResultSet r = stmt.executeQuery("Select * from employee");

		while (rs.next()) {
			System.out.print(rs.getString(1));
			System.out.print(rs.getString(2));
			System.out.print(rs.getString(3));
			System.out.print(rs.getString(4));
			System.out.print(rs.getString(5));
			System.out.println(rs.getString(6));
			System.out.println(rs.getString(7));
		}

		stmt.close();
		conn.close();
		JdbcDataSource.closeConnection(conn, stmt, rs);
	}
}
