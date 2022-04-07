package TransacionHandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PS_TryAndCatch {

	public static void main(String[] args) throws Exception {

		testinsert();

	}

	private static void testinsert() throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");

		/*
		 * int dept_id = 14; String dept_name = "Mkb";
		 */
         int id = 9;
         String fname = "Shahrukh";
         String lname = "Khan";
         int salary = 50000;
         int dept_id = 1;
         
		conn.setAutoCommit(false);
		try {
			PreparedStatement ps = conn.prepareStatement("insert into employee values(?,?,?,?,?)");

			conn.commit();

			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setInt(4, id);
			ps.setInt(5, dept_id);
			
			
			int r = ps.executeUpdate();

			System.out.println(r + "me try hu");

		} catch (Exception e) {

			conn.rollback();
			System.out.println("catch chlra hu");
		}

		System.out.println("inserted");

		conn.close();
	}
}
