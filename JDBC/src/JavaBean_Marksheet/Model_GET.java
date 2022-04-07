package JavaBean_Marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Model_GET {
	public void get(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(" select * from marksheet1 where rollno = ?  ");
		ps.setString(1, Bean.getRollno());

		ResultSet rs = ps.executeQuery();
		conn.commit();

		while (rs.next()) {

			System.out.print(rs.getString(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getString(3));
			System.out.print("\t" + rs.getString(4));
			System.out.print("\t" + rs.getString(5));
			System.out.print("\t" + rs.getString(6));
			System.out.print("\t" + rs.getString(7));

		}

		rs.close();
		ps.close();
		conn.close();
	}

}