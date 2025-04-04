package database;

public class student extends Assignment1 {
	int sid;
	String sname;
	int phy;
	int chem;
	static double avg;
	student(){}
	student(int sid, String sname,int phy,int chem,double avg){
		this.sid=sid;
		this.sname=sname;
		this.phy=phy;
		this.chem=chem;
	}
	public static double average(int phy,int chem) {
		avg=(phy+chem)/2;
		return avg;
	}

}
