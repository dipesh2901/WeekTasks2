package com.neosoft.programs;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Program19 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

		
		String id,number,name,email;
		String regex_mobile = "^9{1}8{1}\\d{8}";
		String regex_email = "^[a-zA-Z]+[0-9]*@{1}gmail{1}[.]{1}[a-z]{2,}";
		
		List<Student2> list = new ArrayList<Student2>();
		
		System.out.println("Enter 5 student details");
		for(int i=0;i<5;i++) {
			System.out.println("Enter Student Id: ");
			id=sc.next();
			System.out.println("Enter Student Name: ");
			name=sc.next();
			System.out.println("Enter Student Number ");
			number=sc.next();
			System.out.println("Enter Student Email: ");
			email=sc.next();
			list.add(new Student2(id,number,name,email));
		}
		
		
		
		System.out.println("-------Student details whose numbers starting from 98-----"); 

		System.out.println();
		
		list.stream().filter(student -> Pattern.matches(regex_mobile, student.mobile))
				.forEach(student -> System.out.println("Student ID: " + student.stdid + "\t Student Name: "
						+ student.name + "\tStudent Mobile: " + student.mobile + "\t Student email: " + student.email));

		System.out.println(
				"---------------Students details whose emailid is gmail with the Help of Collectors--------------------------------------------------------------------------------------------------------------------------------------------------------");

		System.out.println();
		
		List<Student2> list_students=list.stream().filter(student -> Pattern.matches(regex_email, student.email)).collect(Collectors.toList());
		for(Student2 s:list_students) {
			System.out.println(" Student ID: "+s.stdid+" Student Name: "+s.name+ " Student Email: "+s.email);
		}
		

		System.out.println(
				"---------------------------Number of Students not having gmail id ------------------------------------------------------------------------------------------------------------");

		System.out.println();
		
		long counter_Gmail = list.stream().filter(student -> Pattern.matches(regex_email, student.email)).count();
		long counter2 = list.size() - counter_Gmail;
		System.out.println("Number of Students: "+counter2);

		

	}

}

class Student2 {
	String stdid;
	String mobile;
	String name, email;

	public Student2(String stdid, String mobile, String name, String email) {
		super();
		this.stdid = stdid;
		this.mobile = mobile;
		this.name = name;
		this.email = email;
	}

}
