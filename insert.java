package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
	String jdbcURL="jdbc:mysql://localhost:3306/mydb1";
	String dbuname="root";
	String dbpwd="Password@12";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(jdbcURL,dbuname,dbpwd);
	String q="insert into student3 values(?,?,?,?)";
	PreparedStatement ptsmt=con.prepareStatement(q);
	ptsmt.setInt(1,17);
	ptsmt.setString(2, "Radha");
	ptsmt.setInt(3, 88);
	ptsmt.setInt(4, 60);
	int rowinserted=ptsmt.executeUpdate();
	if(rowinserted>0) {
		System.out.println("A new student was inserted");
	}
	con.close();
	}
}
