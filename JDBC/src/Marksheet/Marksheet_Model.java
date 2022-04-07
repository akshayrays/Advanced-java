package Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Marksheet_Model {

	public void Add(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert  into  marksheet1 values(?,?,?,?,?,?,?)");
		ps.setInt(1, Bean.getId());
		ps.setString(2, Bean.getRollno());
		ps.setString(3, Bean.getFname());
		ps.setString(4, Bean.getLname());
		ps.setInt(5, Bean.getPhy());
		ps.setInt(6, Bean.getChem());
		ps.setInt(7, Bean.getMat());

		int  i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();

	}

}
