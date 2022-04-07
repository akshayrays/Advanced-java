package JavaBean_Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Marksheet_Model_delete {

	public void Delete(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement( "delete from marksheet1 where id = ? ");
		ps.setInt(1, Bean.getId());
		

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();
	}
}