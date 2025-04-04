package database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class armed_Forces {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your age");
		int age=s.nextInt();
		System.out.println("Are you specially abled y/n? ");
		char s_abled=s.next().charAt(0);
		System.out.println("Note : If your state or union territory contains more than one word use '_' to connect them. Eg.Andaman_and_Nicobar_Islands");
		System.out.println("Enter your State or Union Territory               ");
		String loc=s.next();
		List<String> list=new ArrayList<>();
		list.add("Andaman_and_Nicobar_Islands");
		list.add("Delhi");
		list.add("New_Delhi");
		list.add("Lakshadweep");
		list.add("Chandigarh");
		list.add("Dadra_and_Nagar_Haveli");
		list.add("Daman_and_Diu");
		list.add("Puducherry");
		list.add("Jammu_and_Kashmir");
		list.add("Ladakh");
		if((age>=18 && age<=35) && (s_abled=='n') && !list.contains(loc) ) {
			System.out.println("Enter your name");
			String name=s.next();
			System.out.println(name+" is eligible");
		}
		else {
			System.out.println("Not   leligible");
		}
	}

}
