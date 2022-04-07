package TransacionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TryAndCatch {

	public static void main(String[] args) throws Exception {

		testinsert();

	}

	private static void testinsert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);
		Statement stmt = conn.createStatement();

		try {

			int r = stmt.executeUpdate("insert into department values(13, 'Assistant')  ");
			r = stmt.executeUpdate("insert into department values(12, 'lab')");

			conn.commit();
			System.out.println("me try hu");

		} catch (Exception e) {

			conn.rollback();
			System.out.println("catch chla");
		}

		System.out.println("inserted");
		stmt.close();
		conn.close();
	}

}
