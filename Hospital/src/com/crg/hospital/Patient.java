package com.crg.hospital;

import java.math.BigInteger;
import java.util.*;
import java.text.ParseException;
import java.util.Date;

/*class to add Patients and display Patients Information*/
public class Patient extends Person{
	String patientId,sickness;
	int patientAge;
	Date admissionDate;
	String prescriptions,specialReqs;
	String allergies;
	String patientFullName;
	ArrayList<Patient> patientsRecord = new ArrayList<Patient>();

	
	/* Constructor to intialize Patient*/
	public Patient(String personTitle, String givenName, String middleName, String familyName, Date birthDate,
			String gender, String address, BigInteger phone, String patientId, String sickness, int patientAge, 
			Date admissionDate, String prescriptions2, String allergies2, String specialReqs2) {
		this.patientId=patientId;
		this.sickness=sickness;
		this.patientAge=patientAge;
		this.admissionDate=admissionDate;
		this.prescriptions=prescriptions2;
		this.allergies=allergies2;
		this.specialReqs=specialReqs2;
		this.personTitle = personTitle;
		this.givenName = givenName;
		this.middleName = middleName;
		this.familyName = familyName;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.patientFullName = givenName +" "+ middleName +" "+ familyName;
	}
	public Patient() {
	}
	
	/*method to add Patient Information*/
	ArrayList<Patient> addPatientInfo()  {
		try {
			System.out.print("\nEnter the Person Title : ");
			personTitle = sc.next();
			System.out.print("\nEnter the Patient Given Name : ");
			givenName = sc.next();
			System.out.print("\nEnter the Patient Middle Name : ");
			middleName = sc.next();
			System.out.print("\nEnter the Patient Family Name : ");
			familyName = sc.next();
			System.out.print("\nEnter the Patient Birth Date (DD-MON-YYYY): ");
			String date = sc.next();
			birthDate = dateFormat.parse(date);
			System.out.print("\nEnter the Patient Address : ");
			address = sc.next()+sc.nextLine();
			System.out.print("\nEnter the Patient Gender(Male or Female) : ");
			gender = sc.next();
			System.out.print("\nEnter the Patient Phone Number : ");
			phone = sc.nextBigInteger();
			System.out.print("\nEnter the Patient ID : ");
			patientId = sc.next();
			System.out.print("\nEnter the Patient Sickness : ");
			sickness = sc.next();
			System.out.print("\nEnter the Patient Age : ");
			patientAge = sc.nextInt();
			System.out.print("\nEnter the Patient date accepted(DD-MON-YYYY): ");
			String date1 = sc.next();
			admissionDate = dateFormat.parse(date1);
			System.out.println("Enter The Patient allergies [give space between each]");
			allergies = sc.next()+sc.nextLine();
			System.out.println("Enter The Patient special requests [give space between each]");
			specialReqs = sc.next()+sc.nextLine();
			long phn = phone.longValue();
			double calc = phn/1000000000;
			
			Patient pt1 = new Patient(personTitle,givenName,middleName,familyName,birthDate,gender,address,phone, 
			patientId,sickness,patientAge,admissionDate,prescriptions, allergies,specialReqs);
			
			if((gender.equalsIgnoreCase("Male")||gender.equalsIgnoreCase("Female")) && calc>1&&calc<10){
				patientsRecord.add(pt1);
				System.out.println("Patient Added Sucessfully\n\n");
				assignDoctor(sickness);
				return patientsRecord;
			}else {
				addPatientInfo();
			}
		}catch(Exception e) {
			System.out.println("Invalid Input...");
			addPatientInfo();
		}
		return 	patientsRecord;	
	}
	
	/*Method to display patients Information*/
	public ArrayList<Patient> displayPatientInfo(ArrayList<Patient> patientsRecord1) {
		if(patientsRecord.size()>0) {
			System.out.println("Full Name\tSickness\tPatient Id\tAllergies");
			for(int i=0;i<patientsRecord1.size();i++) {
				System.out.println((patientsRecord.get(i)).info());
			}
			return patientsRecord;
		}
		System.out.println("No Patients TO Display");
		return patientsRecord;
	}
	
	/* method which return patients info*/
	String info() {
		return "\n"+patientFullName+"\t"+sickness+"\t"+patientId+"\t"+allergies;
	}
	
	Doctor d=new Doctor();
	ArrayList<Doctor> dr=d.addDoctors();
	
	/*Assign Doctors to Patient*/
	void assignDoctor(String sickness) {
		for(int i=0;i<dr.size();i++) {
			String a=sickness;
			if(a.equalsIgnoreCase(dr.get(i).getSpeciality())) {
				System.out.println("Patient have been assigned with : Dr." +dr.get(i).getDname()+" ("+dr.get(i).getSpecial()+")\n");
			}
		}
	}
}