package com.neosoft.basicPrograms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileAssignment {

	public static void main(String[] args) {
		int counter=0,noOfWords=0;
	
		File fileRead,fileRead2, fileWrite = null;
		FileReader fileReader = null,fileReader2=null;
		BufferedReader bufferedReader = null,bufferedReader2=null;
		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
	

	
	try {
		fileRead = new File("resources/File1.txt");
		fileWrite = new File("resources/File2.txt");
		fileRead2=new File("resources/File2.txt");

		fileReader = new FileReader(fileRead);
		fileReader2=new FileReader(fileRead2);
		
		bufferedReader = new BufferedReader(fileReader);
		bufferedReader2 = new BufferedReader(fileReader2);

		fileWriter = new FileWriter(fileWrite);
		bufferedWriter = new BufferedWriter(fileWriter);

		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			if(line.contains("java")) {
				
				//System.out.println(line.length());
				//System.out.println(line);
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			}
		}
		bufferedWriter.flush();
		String line2=null;
		String[] line3;
		while((line2=bufferedReader2.readLine())!=null) {
			counter++;
			line3=line2.split(" ");
			for(int i=1;i<=line3.length;i++) {
				noOfWords++;
			}
		}
		System.out.println(counter);
		System.out.println(noOfWords);
		
		}
		
		
		
	catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (fileReader != null)
				fileReader.close();
			if (bufferedReader != null)
				bufferedReader.close();
			if (fileWriter != null)
				fileWriter.close();
			if (bufferedWriter != null)
				bufferedWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
}
	}
}
