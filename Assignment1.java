package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Assignment1 {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/assignmentdb";
		String jdbcRoot = "root";
		String jdbcPwd = "Password@12";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(jdbcURL, jdbcRoot, jdbcPwd);
		String q = "insert into student(sid,sname,phy,chem) values(?,?,?,?)";
		PreparedStatement ptsmt = con.prepareStatement(q);
		String o = "update student set avg=? where sid=?";
		
		
		 ptsmt.setInt(1,4);
		 ptsmt.setString(2, "Sam");
		 ptsmt.setInt(3, 82);
		 ptsmt.setInt(4, 74);
		 int rowinserted=ptsmt.executeUpdate();
		 if(rowinserted>0) { 
			 //System.out.println(rowinserted);
			 }
	
		Map<Integer, student> map = new HashMap<>();
		student s1;
		student s2;
		student s3;
		student s4;
		JDBC_methods j=new JDBC_methods();
		Statement stmt = con.createStatement();
		String a = "select * from student";
		ResultSet rs = stmt.executeQuery(a);
		while (rs.next()) {
			int id = rs.getInt("sid");
			String n = rs.getString("sname");
			int p = rs.getInt("phy");
			int c = rs.getInt("chem");
			double ag = (p + c) / 2;
			j.insertvalue(o,con,ag,id);
			s1 = new student(id, n, p, c, ag);
			map.put(s1.sid, s1);
		}
		for (Map.Entry<Integer, student> e : map.entrySet()) {
			student s = e.getValue();
			System.out.println(" ID : " + e.getKey() + " Name : " + s.sname);
		}	
	}
}
