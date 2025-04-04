package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class selcts1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String jdbcURL="jdbc:mysql://localhost:3306/mydb1";
		String dbuname="root";
		String dbpwd="Password@12";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(jdbcURL,dbuname,dbpwd);
		Statement stmt=con.createStatement();
		String q="select * from student3";
		ResultSet rs=stmt.executeQuery(q);
		while(rs.next()) {
			int id=rs.getInt("sid");
			String n=rs.getString("st_name");
			System.out.println(id+" "+n);
		}
		con.close();
	}

}
