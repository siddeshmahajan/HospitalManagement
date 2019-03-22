package com.crg.hospital;

import java.text.ParseException;
import java.util.*;
public class MainClass {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws ParseException {
			start();
	}
	static void start() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome...");
		System.out.println("Enter your choice: ");
		System.out.println("1.Admin");
		System.out.println("2.Hospital");
		System.out.println("3.Reception");
		
		int choice = sc.nextInt();
		
		Hospital h=new Hospital();
		Doctor d=new Doctor();
		Department dept=new Department();
		Staff st=new Staff();
		Patient p=new Patient();
		Technical t=new Technical();
		
		switch(choice) {
			case 1:
					boolean auth = adminAuth();
					if(auth) {
						System.out.println("Hospitals");
						ArrayList ar=h.addHospital();
						h.displayHospital(ar);
					}else {
						System.out.println("Invalid username/password");
						start();
					}
					break;
			case 2: 
					boolean auth1 = hospitalAuth();
					if(auth1) {
						System.out.println("Add doctor and staff");
						ArrayList ar1=d.addDoctors();
						d.showDoctors(ar1);
						System.out.println("Do you want to add department? Y/N");
						Scanner sc1=new Scanner(System.in);
						String ch=sc1.nextLine();
						dept:{
							if(ch.equalsIgnoreCase("Y")) {
								System.out.println("Enter department key: ");
								String depId = sc1.nextLine();
								System.out.println("Enter department name: ");
								String depName=sc1.nextLine();
								dept.addDepartment();
								HashMap val=dept.addNewDepartment(depId,depName);
								dept.showDepartment(val);
							}else {
								start();
							}
						}
					}else {
						System.out.println("Invalid username/password");
						start();
					}
					break;
			case 3: 
					boolean auth2 = staffAuth();
					if(auth2) {
						System.out.println("Add Patient: ");
				        ArrayList<Patient> v1= p.addPatientInfo();
				        p.displayPatientInfo(v1);
				        System.out.println("\nDo you want to add another patient then press 1: "+"Get Scan Report 0");
				        int ch1=sc.nextInt();
				        if(ch1 == 1) {
				        	v1= p.addPatientInfo();
				        	p.displayPatientInfo(v1);
				        }else {
				        	System.out.println("Get scan report: ");
				        	System.out.println("Choose the scan type");
							System.out.println("1.MRI\n2.X-Ray\n3.CT Scan");
							String scanType = sc.next();
							String scanReport = t.patientScan(scanType);
							System.out.println("\nScan report : "+scanReport);
							d.takeAction();
				        }
					}else {
						System.out.println("Invalid username/password");
						start();
					}
			default : System.out.println("Enter Correct Choice");
						start();
						break;
		}
	}
	
	/* Admin authentication*/
	private static boolean adminAuth() {
		System.out.print("Enter Admin UserName : ");
		String adminName = sc.next();
		System.out.print("\nEnter the Password : ");
		String adminPassword = sc.next();
		if(adminName.equalsIgnoreCase("siddesh")&&adminPassword.equals("1234")) {
			return true;
		}
		return false;
	}
	
	/* Staff authentication*/
	private static boolean staffAuth() {
		System.out.print("Enter staff UserName : ");
		String staffName = sc.next();
		System.out.print("\nEnter the Password : ");
		String staffPassword = sc.next();
		if(staffName.equalsIgnoreCase("siddesh")&&staffPassword.equals("1234")) {
			return true;
		}
		return false;
	}
	
	/* hospital authentication*/
	private static boolean hospitalAuth() {
		System.out.print("Enter hospital UserName : ");
		String hName = sc.next();
		System.out.print("\nEnter the Password : ");
		String hPassword = sc.next();
		if(hName.equalsIgnoreCase("siddesh")&&hPassword.equals("1234")) {
			return true;
		}
		return false;
	}
}
