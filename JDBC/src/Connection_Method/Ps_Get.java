package Connection_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Ps_Get {
	public static void main(String[] args) throws Exception {

		testGet(4);
	}

	private static void testGet(int pk) throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		PreparedStatement ps = conn.prepareStatement(("select * from emp8 where id = ? "));

		ps.setInt(1, 4);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.println("\t" + rs.getString(5));

		}
		rs.close();
		conn.close();
		ps.close();

	}

}
