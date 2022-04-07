package JavaBean_Marksheet;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Marksheet_Model {

	public void Add(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement("insert  into  marksheet2 values(?,?,?,?,?,?,?)");
		ps.setInt(1, Bean.getId());
		ps.setString(2, Bean.getRollno());
		ps.setString(3, Bean.getFname());
		ps.setString(4, Bean.getLname());
		ps.setInt(5, Bean.getPhy());
		ps.setInt(6, Bean.getChem());
		ps.setInt(7, Bean.getMaths());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();

	}

	public void Update(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("update marksheet2 set fname =? where id = ? ");
		ps.setInt(2, Bean.getId());
		ps.setString(1, Bean.getFname());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();
	}

	public void Delete(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement("delete from marksheet2 where id = ? ");
		ps.setInt(1, Bean.getId());

		int i = ps.executeUpdate();
		conn.commit();
		System.out.println(i + "Inserted");

		ps.close();
		conn.close();
	}

	public void get(Marksheet_Bean Bean) throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(" select * from marksheet2 where rollno = ?  ");
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

	public ArrayList<Marksheet_Bean> getMeritList() throws Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dhoom", "root", "root");
		conn.setAutoCommit(false);

		PreparedStatement ps = conn.prepareStatement(" select * ,(phy+chem+maths) as total, (phy+chem+maths)/3 as percentage from marksheet2 where (phy,chem,maths)>(40,40,40) order by percentage desc limit 3");
		ResultSet rs = ps.executeQuery();
		ArrayList<Marksheet_Bean> list = new ArrayList<Marksheet_Bean>();
		while (rs.next()) {

			Marksheet_Bean bean = new Marksheet_Bean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getString(2));
			bean.setFname(rs.getString(3));
			bean.setLname(rs.getString(4));
			bean.setPhy(rs.getInt(5));
			bean.setChem(rs.getInt(6));
			bean.setMaths(rs.getInt(7));

			list.add(bean);
		}
		conn.commit();
		ps.close();
		return list;

	}
}
