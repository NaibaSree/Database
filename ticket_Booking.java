package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ticket_Booking {
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		String jdbcURL="jdbc:mysql://localhost:3306/assignmentdb";
		String jdbcRoot="root";
		String jdbcPwd="Password@12";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(jdbcURL, jdbcRoot, jdbcPwd);
		Statement stmt = con.createStatement();
		String a = "select * from busroute";
		ResultSet rs = stmt.executeQuery(a);
		data_function d=new data_function();
		String q="insert into booking values(?,?,?,?)";
		PreparedStatement ptsmt=con.prepareStatement(q);
		Scanner sc=new Scanner(System.in);
		d.getData(rs);
		d.putData(ptsmt,stmt,a,sc);
		
	}

	

}
