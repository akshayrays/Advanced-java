package JavaBean_Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Model_Update {

	public void Add(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("update marksheet1 set fname =? where id = ? ");
		ps.setInt(2, Bean.getId());
		ps.setString(1, Bean.getFname());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();
	}
}