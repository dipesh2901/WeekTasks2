package com.neosoft.programs;
import java.util.*;

public class EmployeeDetails {
	
	String ename;
	int esal;
	EmployeeDetails(String ename,int esal){
		
		this.ename=ename;
		this.esal=esal;
	}

	public static void main(String[] args) {
		int val;
		ArrayList<Integer> ai=new ArrayList<Integer>();
		Map<Integer,EmployeeDetails> emp2=new LinkedHashMap<Integer,EmployeeDetails>();
		Map<Integer,EmployeeDetails> emp=new TreeMap<Integer,EmployeeDetails>();
		emp.put(2, new EmployeeDetails("Hitesh",15000));
		emp.put(3, new EmployeeDetails("Satish",14000));
		emp.put(4, new EmployeeDetails("Hiren",25000));
		emp.put(1, new EmployeeDetails("Rudra",15000));
		emp.put(5, new EmployeeDetails("Anshika",12000));
		emp.put(6, new EmployeeDetails("Vijayalakshmi",40000));
		emp.put(7, new EmployeeDetails("Surya",15000));
		emp.put(8, new EmployeeDetails("Achiket",25000));
		emp.put(9, new EmployeeDetails("Hadra",35000));
		emp.put(10, new EmployeeDetails("Vinayak",15000));
		
		System.out.println("Displaying Data in sorted form: ");
		for(Map.Entry<Integer, EmployeeDetails> empPair:emp.entrySet()) {
			System.out.println(empPair.getKey()+":"+empPair.getValue().ename+" "+empPair.getValue().esal);
		}
		
		/*for(Map.Entry<String,EmployeeDetails> empPair2:emp.entrySet()) {	
			if(empPair2.getValue().esal<15000f) {
				String val=empPair2.getKey();
				emp.remove(val);
			}
		}*/
		
		
		for(Map.Entry<Integer, EmployeeDetails> empPair2:emp.entrySet()) {
			if(empPair2.getValue().esal<15000) {
				 val=empPair2.getKey();
				 ai.add(val);
			}
			else {
				emp2.put(empPair2.getKey(), empPair2.getValue());
			}
		}
		for(Integer i:ai) {
			emp.remove(i);
		}
		
		
		
		System.out.println("Fetching employees whose salary is greater than 15000");
		for(Map.Entry<Integer, EmployeeDetails> empPair3:emp2.entrySet()) {
			System.out.println(empPair3.getKey()+":"+empPair3.getValue().ename+" "+empPair3.getValue().esal);
		}
		
	}

}
