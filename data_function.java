package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class data_function {
	Map<Integer,Integer> map1=new HashMap<>();
	data_function(){
	map1.put(101,30);
	map1.put(102,30);
	map1.put(103,30);
	map1.put(104,30);
	map1.put(105,30);
	}
	Map<Integer,Integer> map2=new HashMap<>();
	public void getData(ResultSet rs) throws SQLException, ClassNotFoundException {
		
		while (rs.next()) {
			int id=rs.getInt("route_id");
			String fr=rs.getString("From_");
			String to=rs.getString("To_");
			int totseat=rs.getInt("TotalSear");
			int remseat=rs.getInt("rem_seat");
			int cost=rs.getInt("cost");
			display(id, fr, to, totseat, remseat, cost);
			
			
		}
		
	}
	public static int cal_amt(ResultSet rs,int id,int b_seat) throws SQLException, ClassNotFoundException{
		int idd=0,val;
		while(rs.next()) {
			idd=rs.getInt("route_id");
			if(idd==id) {
				val= rs.getInt("cost");
				return b_seat*val;
			}
		 }
		return 0;
	}
	public void display(int id,String fr,String to,int totseat,int remseat,int cost) {
		System.out.println("Route ID : "+id+" From : "+fr+" To : "+to+" Total seat : "+totseat+" Remaining Seat : "+remseat+" Cost : "+cost);
	}
	public void bookseat(PreparedStatement ptsmt,Statement stmt,String a,Scanner sc) throws SQLException, ClassNotFoundException{
		System.out.println("In Bookseat");
		System.out.println("Enter booking_id");
		int id=sc.nextInt();
		System.out.println("Enter route_id");
		int rid=sc.nextInt();
		System.out.println("Enter the number of seats you are booking");
		int b_seat=sc.nextInt();
		ResultSet rs = stmt.executeQuery(a);
		int tot=cal_amt(rs,rid,b_seat);
		int rem;
		if(map1.containsKey(rid)) {
			rem=map1.getOrDefault(rid, 0);
			if(rem>=b_seat) {
			rem-=b_seat;
			ptsmt.setInt(1,id);
			ptsmt.setInt(2, rid);
			ptsmt.setInt(3, b_seat);
			ptsmt.setInt(4, tot);
			ptsmt.executeUpdate();
			map2.put(id, tot);
			}
			else
				System.out.println("OOOPS Seat not available...!!!");
			map1.put(rid, rem);
		}
					
	}
	public void putData(PreparedStatement ptsmt,Statement stmt,String a,Scanner sc)  throws SQLException, ClassNotFoundException{
		System.out.println("Enter 1 to continue 4 to exit");
		int i=sc.nextInt();
		while(i==1) {
			bookseat(ptsmt,stmt,a,sc);
			System.out.println("Enter 1 to continue 4 to exit");
			i=sc.nextInt();
		}
		System.out.println("Remaining number of seats on each routebuses : ");
		for (Map.Entry<Integer, Integer> e : map1.entrySet()) {
			Integer s = e.getValue();
			System.out.println(" ID : " + e.getKey() + " value : "+ s);
		}	
		int grandtotal=0;
		System.out.println("Toatal amount for each Booked customers");
		for (Map.Entry<Integer, Integer> e : map2.entrySet()) {
			Integer s = e.getValue();
			grandtotal+=s;
			System.out.println(" ID : " + e.getKey() + " value : "+ s);
		}
		System.out.println("Grandtotal : "+grandtotal);
	}

}
