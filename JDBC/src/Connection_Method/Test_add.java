package Connection_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_add {

	public static void main(String[] args) throws Exception {
		testadd();

	}

	private static void testadd() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		int id = 8;
		String fname = "Champak";
		String lname = "lal";
		int salary = 30000;
		int did = 4;

		// ek bar compile hogyi
		PreparedStatement ps = conn.prepareStatement("insert into emp8 values (?,?,?,?,?)");

		
	
		ps.setInt(1, id);
		ps.setString(2, fname);
		ps.setString(3, lname);
		ps.setInt(4, salary);
		ps.setInt(5, did);

		int i = ps.executeUpdate();
		System.out.println(i + "Inserted");
		ps.close();
		conn.close();

	}
}
