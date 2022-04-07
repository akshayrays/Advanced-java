package Connection_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Ps_Update {

	public static void main(String[] args) throws Exception {
		testUpdate();

	}

	private static void testUpdate() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		String lname = "JOSHI";
		int id = 7;

		PreparedStatement ps = conn.prepareStatement("update emp8 set lname =? where id=?");
		ps.setString(1, lname);
		ps.setInt(2, id);

		int re = ps.executeUpdate();
		System.out.println("re + UPDATED");

	}
}
