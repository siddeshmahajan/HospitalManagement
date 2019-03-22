package com.crg.hospital;
import java.util.*;
public class Doctor {
	String dName;
    String dSpeciality;
    String dSpecial;
	
	public Doctor(String dName,String dSpeciality,String dSpecial) {
		this.dName=dName;
		this.dSpeciality=dSpeciality;
		this.dSpecial=dSpecial;
	}
	
	public Doctor() {}
	
	/* Method will return values of the constructor*/
	public String toString() {
		return dName+" "+dSpeciality+" ("+dSpecial+")";
	}
	
	Scanner sc=new Scanner(System.in);
	ArrayList<Doctor> ad=new ArrayList<Doctor>();
	
	/* Method to add doctors */
	public ArrayList<Doctor> addDoctors() {
		
		ad.add(new Doctor("Stiv","eye","Ophthalmologist"));
		ad.add(new Doctor("Rogger","heart","Cardiology"));
		return ad;
	}
	
	/* Method to get details of doctors*/
	public void showDoctors(ArrayList<Doctor> ar){
		System.out.println("Doctor's Details: ");
		for(int i=0;i<ar.size();i++) {
			System.out.println(ar.get(i).toString());
		}
	}
	
	/*Method to take action on patient*/
	void takeAction() {
		System.out.println("Choose the action you want to take on patient: ");
		System.out.println("1.Surgery\n2.Tablets");
		int n=sc.nextInt();
		switch(n){
			case 1: System.out.println("Report has been examined and surgery will be performed");
					break;
			case 2: System.out.println("Prescription has been given to patient");
					break;
			default: System.out.println("Invalid Input");
					takeAction();
		}
	}
	/* Method will return Specialty of doctor*/
	public String getSpeciality() {
		return dSpeciality;
	}
	
	/*Method will return name of doctors*/
	public String getDname() {
		return dName;
	}
	
	/* Method will return scientific term of specialty*/
	public String getSpecial() {
		return dSpecial;
	}
}
