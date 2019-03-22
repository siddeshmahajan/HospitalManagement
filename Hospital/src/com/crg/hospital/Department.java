package com.crg.hospital;
import java.text.ParseException;
import java.util.*;
public class Department {
	String deptId;
	String deptName;
	public Department(String deptId,String deptName){
		this.deptId = deptId;
		this.deptName = deptName;
	}
	
	public Department() {}
	
	@Override
	public String toString() {
		return deptId+" "+deptName;
	}
	Scanner sc =new Scanner(System.in);
	HashMap<String,Department> hm = new HashMap<String, Department>();
	Staff stf=new Staff();
	
	/* Method to add Department */
	public HashMap<String, Department> addDepartment() {
		hm.put("Dept1", new Department("Dept1","Ophthalmologist"));
		hm.put("Dept2", new Department("Dept2","Cardiologists"));;
		return hm;
	}
	
	/*Method to add new Department */
	HashMap<String,Department> addNewDepartment(String deptId1,String deptName1){
		hm.put(deptId1, new Department(deptId1,deptName1));
		System.out.println("Record added succesfully..!");
		return hm;
	}
	
	/* Method to get department detail*/
	public void showDepartment(HashMap<String, Department> hm2) throws ParseException {
		Set<String> s = hm2.keySet();
		Iterator<String> it = s.iterator();
		System.out.println("Department ID   Department Name");
		while(it.hasNext()) {
			System.out.println(hm2.get(it.next()));
		}
		System.out.println("Enter Department ID: ");
		String deptId2=sc.nextLine();
		staffInfo(deptId2);
	}	
	
	/* Method to get staff information */
	public void staffInfo(String d_Id2) throws ParseException {
		System.out.println("1.See Staff's\t2.Add Staff");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:stf.displayStaffs(d_Id2);
		break;
		case 2:stf.addStaffInfo(d_Id2);
		break;
		default : System.out.println("Invalid Input");
	}
}
}
