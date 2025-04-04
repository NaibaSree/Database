package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class delete {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String jdbcURL="jdbc:mysql://localhost:3306/mydb1";
		String dbuname="root";
		String dbpwd="Password@12";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(jdbcURL,dbuname,dbpwd);
		String updatesql="delete from student3 where sid=?";
		PreparedStatement ptsmt=con.prepareStatement(updatesql);
		ptsmt.setInt(1,12);
		int rowdeleted=ptsmt.executeUpdate();
		if(rowdeleted>0) {
			System.out.println("A row from student3 table was deleted");
		}
		con.close();
	}

}
