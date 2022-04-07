package Stored_Procedures;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class UserCount {

	public static void main(String[] args) throws Exception {
		testcallable();

	}

	private static void testcallable() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		CallableStatement cal = conn.prepareCall("{call empCount(?)}");
		cal.registerOutParameter(1, Types.INTEGER);
		cal.execute();
		System.out.println("empCount : " + cal.getInt(1));

	}

}
