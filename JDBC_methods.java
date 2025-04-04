package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC_methods extends Assignment1  {
	void insertvalue(String o,Connection con,double avg,int id) throws SQLException {
		PreparedStatement ftsmt = con.prepareStatement(o);
		ftsmt.setDouble(1,avg);
		ftsmt.setInt(2, id);
		int rowinserted=ftsmt.executeUpdate();
		 if(rowinserted>0) { 
			 System.out.println(rowinserted);
			 }	 
	}

}
