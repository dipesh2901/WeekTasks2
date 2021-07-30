package com.neosoft.programs;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Employee_program16 implements Serializable,Comparable<Employee_program16> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int empId,esal,dno;
	String empName;
	
	@Override
	public int compareTo(Employee_program16 e) {
		if(this.esal>e.esal)
			return 1;
		else if(this.esal<e.esal)
			return -1;
		else
			return 0;
	}

	public Employee_program16(int empId, int esal, int dno, String empName) {
		this.empId = empId;
		this.esal = esal;
		this.dno = dno;
		this.empName = empName;
	}



	public static void main(String[] args) {
		Map<String,Integer> emp_maxSalary=new TreeMap<String,Integer>();
		ArrayList<Employee_program16> ai=new ArrayList<Employee_program16>();
		ObjectOutputStream os=null;
		ObjectInputStream is;
		String file="resources/emp.db";
		
		String emp_name;
		int emp_id,emp_sal,d_no;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Employee_program16[] emp=new Employee_program16[5];
		try {
		for(int i=0;i<emp.length;i++) {
			System.out.println("Enter Employee ID: ");
			emp_id=Integer.parseInt(br.readLine());
			System.out.println("Enter Employee Name: ");
			emp_name=br.readLine();
			System.out.println("Enter Employee Salary: ");
			emp_sal=Integer.parseInt(br.readLine());
			System.out.println("Enter Department Number: ");
			d_no=Integer.parseInt(br.readLine());
			emp[i]=new Employee_program16(emp_id,emp_sal,d_no,emp_name);	
		}
			
	
		
		os=new ObjectOutputStream(new FileOutputStream(file));
		is=new ObjectInputStream(new FileInputStream(file));
		
		for(Employee_program16 ep:emp) {
			os.writeObject(ep);
		}
		
		while(true) {
			
			Employee_program16 empRead=(Employee_program16)is.readObject();
			if(empRead.dno==10)
			{
				ai.add(empRead);
			}
			
		}
		
		
		
		}
		catch(EOFException eof) {
			System.out.println("The Following Information Inlcudes:  ");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
				Collections.sort(ai,Collections.reverseOrder());
				int sal=ai.get(0).esal;
				for(Employee_program16 a:ai) {
					if(a.esal==sal)
						System.out.println("Employee Name: "+a.empName+"\t Employee Salary: "+a.esal);
				}
				
			try {
			if(os!=null) {
				os.close();
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
