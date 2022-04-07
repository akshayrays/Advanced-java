package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestCRUD2_ADD {

	public static void main(String[] args) throws Exception {

		testAdd();

	}

	public static void testAdd() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		Statement stmt = conn.createStatement();
		int rs = stmt.executeUpdate("insert into emp8 values(7,'akshay','joshi',5000,1)");
		System.out.println(rs + "insert");

		conn.close();
		stmt.close();

	}

}
