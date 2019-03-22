package com.crg.hospital;
import java.text.ParseException;
import java.util.*;

public class Hospital {
	String hname;
	String haddress;
	long hphoneNo;
	
	public Hospital(String hname,String haddress,long hphoneNo) {
		this.hname=hname;
		this.haddress=haddress;
		this.hphoneNo=hphoneNo;
	}
	
	@Override
	public String toString() {
		return hname+" "+haddress+" "+hphoneNo;
	}
	
	Hospital(){}
	
	ArrayList<Hospital> ar=new ArrayList<Hospital>();
	Scanner sc=new Scanner(System.in);
	
	/* Method to add hospital */
	public ArrayList<Hospital> addHospital() {
		ar.add(new Hospital("Appollo","Baswangudi",9886481));
		ar.add(new Hospital("KLE","Belgaum",8753729));
		return ar;
	}
	
	/* Method to show details of hospital */
	public void displayHospital(ArrayList<Hospital> al2) throws ParseException {
		System.out.println("Hospital Name: ");
		for(int i=0;i<al2.size();i++) {
			System.out.println(i+"\t"+al2.get(i).toString());
		}
		MainClass.start();
	}
}
