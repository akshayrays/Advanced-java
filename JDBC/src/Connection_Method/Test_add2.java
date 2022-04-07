package Connection_Method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test_add2 {
	public static void main(String[] args) throws Exception {

		testadd();

	}

	private static void testadd() throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		
		
		
		int id =7;
		String fname = "Akshay";
		String lname = "Joshi";
		int salary = 50000;
		int did = 1;
		
		PreparedStatement ps = conn.prepareStatement("?,?,?,?,?");
		
		String s = "insert into emp8 values("+id+",'"+ fname+"','"+lname+"',"+salary+","+did+")";
				int i = ps.executeUpdate(s);
		System.out.println(i + "Inserted");
		//ps.close();
		conn.close();	
	}

}
