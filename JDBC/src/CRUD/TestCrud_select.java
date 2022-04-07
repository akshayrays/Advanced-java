package CRUD;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCrud_select {

	public static void main(String[] args) throws Exception {

		testselect();
	

	}

	public static void testselect() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from emp8 ");

		while (rs.next()) {
			System.out.print("\t" + rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.println("\t" + rs.getString(5));

		}

		stmt.close();
		conn.close();
		rs.close();

	}
}