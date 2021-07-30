package com.neosoft.programs;
import java.util.*;

enum Subject{
	JAVA,CPP,C,PYTHON
}

public class Student_enum {

	int stid,marks;
	String stname;
	Subject subject;
	
	public Student_enum(int stid,String stname,Subject subject,int marks){
		this.stid=stid;
		this.stname=stname;
		this.subject=subject;
		this.marks=marks;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student_enum[] se=new Student_enum[5];
		se[0]=new Student_enum(101,"Dipesh",Subject.C,80);
		se[1]=new Student_enum(102,"Satish",Subject.CPP,85);
		se[2]=new Student_enum(103,"Anshika",Subject.JAVA,80);
		se[3]=new Student_enum(104,"kinjal",Subject.PYTHON,90);
		se[4]=new Student_enum(105,"Akash",Subject.JAVA,75);

		System.out.println("Enter a subject name to display the details of respective students: ");
		String user_subject=sc.nextLine().toUpperCase();
		for(int i=0;i<se.length;i++) {
			if(Subject.valueOf(user_subject).equals(se[i].subject)) {
				System.out.println("\nSTUDENT ID: "+se[i].stid+"\nSTUDENT NAME: "+se[i].stname+"\nSTUDENT SUBJECT: "+se[i].subject+"\nSTUDENT MARKS: "+se[i].marks);
			}
		}
		
	}

}
