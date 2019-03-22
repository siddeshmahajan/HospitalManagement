package com.crg.hospital;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;

public class Person {
		String personTitle,givenName,middleName,familyName;
		Date birthDate;
		String gender,address;
		BigInteger phone;
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MMM-dd");
		
		ArrayList<Person> al = new ArrayList<Person>();
		
		/* Constructor for person class */
		Person(String personTitle,String givenName,String middleName,String familyName,
				Date birthDate,String gender,String address,BigInteger phone){
			this.personTitle = personTitle;
			this.givenName = givenName;
			this.middleName = middleName;
			this.familyName = familyName;
			this.gender = gender;
			this.address = address;
			this.phone = phone;
		}
		Person() {
		}
}

