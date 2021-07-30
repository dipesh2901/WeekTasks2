package com.neosoft.programs;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Program15 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String line;
		int c;
		String[] line2 = new String[3];
		int j = 0;
		try {
			File email_file = new File(args[0]);
			File domain_file = new File(args[1]);
			FileWriter email_writer = new FileWriter(email_file);
			FileWriter domain_writer = new FileWriter(domain_file);
			FileReader email_reader = new FileReader(email_file);
			BufferedWriter bufferWriter_email = new BufferedWriter(email_writer);
			BufferedWriter bufferWriter_domain = new BufferedWriter(domain_writer);
			BufferedReader bufferReader_email = new BufferedReader(email_reader);

			String[] emails = new String[3];
			System.out.println("Enter 3 Email Ids which you want to store: ");
			for (int i = 0; i < emails.length; i++) {
				System.out.println("Enter " + (i + 1) + " Email Id: ");
				emails[i] = sc.nextLine();
			}
			for (int i = 0; i < emails.length; i++) {
				bufferWriter_email.write(emails[i]);
				bufferWriter_email.newLine();
			}
			bufferWriter_email.flush();
			while ((line = bufferReader_email.readLine()) != null) {
				line2[j++] = line;
			}
			for (String s : line2) {
				c = s.indexOf('@');
				bufferWriter_domain.write(s.substring(c + 1));
				bufferWriter_domain.newLine();

			}
			bufferWriter_domain.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
