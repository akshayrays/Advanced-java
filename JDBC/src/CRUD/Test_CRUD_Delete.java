package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test_CRUD_Delete {

	public static void main(String[] args) throws Exception {

		testDelete();
	}

	public static void testDelete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		Statement stmt = conn.createStatement();
		int re = stmt.executeUpdate("delete from emp8 where id = 7");
		System.out.println(re + "updated");

		stmt.close();
		conn.close();
	}

}
