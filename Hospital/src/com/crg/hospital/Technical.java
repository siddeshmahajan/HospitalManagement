package com.crg.hospital;

import java.util.Scanner;

public class Technical extends Staff{
	Scanner scanInput=  new Scanner(System.in);
	/* method to scan the patients based on the requirement */
	String patientScan(String scanType){
		switch(scanType) {
		case "1":
			System.out.println("Scan Done by Technical Staff and Reprots are Sent to the Doctor");
			return "MRI report";
		case "2":
			System.out.println("Scan Done by Technical Staff and Reprots are Sent to the Doctor");
			return "X-Ray report";
		case "3":
			System.out.println("Scan Done by Technical Staff and Reprots are Sent to the Doctor");
			return "CT Scan report";
		case "4":return "Invalid Input";
		}
		return scanType;
	}
}