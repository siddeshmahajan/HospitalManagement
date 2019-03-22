package com.crg.hospital;

import java.math.BigInteger;
import java.text.ParseException;
import java.util.*;

public class Staff extends Person {
	String sid;
	String education;
	String language;
	Date joined;
	String certification;
	String fullName;
	
	static Scanner sc1=new Scanner(System.in);
	
	public Staff(String sid,String education,String language,Date joined,String certification,
			String personTitle,String givenName,String middleName,String familyName,
			Date birthDate,String gender,String address,BigInteger phone) {
		this.sid=sid;
		this.education=education;
		this.language=language;
		this.joined=joined;
		this.certification=certification;
		this.personTitle = personTitle;
		this.givenName = givenName;
		this.middleName = middleName;
		this.familyName = familyName;
		this.birthDate=birthDate;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.fullName = givenName +" "+ middleName +" "+ familyName;
	}
	public Staff() {}
	
	public String toString() {
		return fullName+" "+education+" "+language;
	}
	
	ArrayList<Staff> ar=new ArrayList<Staff>();
	
	/* Method to add staff details */
	void addStaffInfo(String sid2) throws ParseException {
		try {
				System.out.print("\nEnter the Person Title : ");
				personTitle = sc.next();
				System.out.print("\nEnter the Person Given Name : ");
				givenName = sc.next();
				System.out.print("\nEnter the Person Middle Name : ");
				middleName = sc.next();
				System.out.print("\nEnter the Person Family Name : ");
				familyName = sc.next();
				System.out.print("\nEnter the Person Birth Date (YYYY-MMM-DD): ");
				String date = sc.next();
				birthDate = dateFormat.parse(date);
				System.out.print("\nEnter the Person Phone Number : ");
				phone = sc.nextBigInteger();
				System.out.print("\nEnter the Person Address : ");
				address = sc.next()+sc.nextLine();
				System.out.print("\nEnter the Person Gender(Male(or)Female) : ");
				gender = sc.next();
				sid=sid2;
				System.out.println("Enter the staff joined Date (YYYY-MMM-DD)");
				String date1 = sc.next();
				birthDate = dateFormat.parse(date1);
				System.out.println("Enter The staff's education details: ");
				education = sc.next()+sc.nextLine();
				System.out.println("Enter The staff's certification details: ");
				certification = sc.next()+sc.nextLine();
				System.out.println("Enter The staff's lenguages konwn [give space between each]");
				language = sc.next()+sc.nextLine();
				long phn = phone.longValue();
				double calc = phn/1000000000;
				
				if((gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")) && calc>1&&calc<10){
					ar.add(new Staff(sid,education,language,joined, certification,personTitle,
								givenName,middleName,familyName,birthDate,gender,address,phone));
					System.out.println("\nStaff Information Successfully added");
				}
				
				displayStaffs(sid2);
					
				System.out.println("\n1.Add Another Staff\t2.Exit");
				String c=sc.next();
				if(c.equals("1")) {
					addStaffInfo(sid2);
				}else {
					MainClass.start();
				}
		}catch(Exception e) {
			System.out.println("Invalid Input...");
			addStaffInfo(sid2);
		}
			
	}
	
	/*Method to display details of Staff*/
	public void displayStaffs(String sid2) throws ParseException {
		if(ar.size()==0) {
			System.out.println("No Staff's to Display");
			System.out.println("Enter 1 to Add Staff");
			String c1=sc.next();
			if(c1.equals("1")) {
				addStaffInfo(sid2);
			}else {
				MainClass.start();
			}
		}
		for(int i=0;i<ar.size();i++) {
			if(ar.get(i).sid.equals(sid2)) {
				System.out.println(ar.get(i).toString());
			}
		}
	}
}
