package Connection_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PS_Delete {

	public static void main(String[] args) throws Exception {
		testDelete();

	}

	private static void testDelete() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		int id = 7;

		PreparedStatement ps = conn.prepareStatement("delete from emp8 where id=?");
		ps.setInt(1, id);

		int re = ps.executeUpdate();
		System.out.println("re + UPDATED");

		ps.close();
		conn.close();
	}

}
