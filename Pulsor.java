package com.neosoft.programs;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pulsor implements Cloneable,Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	float engineDisplay;
	int maxPower;
	String fuelType,tyreType;
	
	 public Pulsor(float engineDisplay, int maxPower, String fuelType, String tyreType) {
		this.engineDisplay = engineDisplay;
		this.maxPower = maxPower;
		this.fuelType = fuelType;
		this.tyreType = tyreType;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		ObjectOutputStream os=null;
		ObjectInputStream is=null;
		String file="resources/pulsorDetails.txt";
		Pulsor pulsor=new Pulsor(149.5f,14,"Petrol","Tubeless");
		/*Pulsor pulsor_1=(Pulsor)pulsor.clone();
		Pulsor pulsor_2=(Pulsor)pulsor.clone();
		Pulsor pulsor_3=(Pulsor)pulsor.clone();
		Pulsor pulsor_4=(Pulsor)pulsor.clone();
		Pulsor pulsor_5=(Pulsor)pulsor.clone();*/
		
		Pulsor[] pulsor_objects=new Pulsor[5];
		for(int i=0;i<5;i++) {
			pulsor_objects[i]=(Pulsor)pulsor.clone();
		}
		
		try {
			os=new ObjectOutputStream(new FileOutputStream(file));
			for(Pulsor p:pulsor_objects) {
				os.writeObject(p);
			}
			is=new ObjectInputStream(new FileInputStream(file));
			while(true) {
				Pulsor p_details=(Pulsor)is.readObject();
				System.out.println("Engine Details: "+p_details.engineDisplay+"\t Maximum Power: "+p_details.maxPower+"\t Fuel Type: "+p_details.fuelType+"\t Tyre Type: "+p_details.tyreType);
			}
			
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(EOFException eof) {
			System.out.println("These were all information about the clones of Pulsor Bike");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(os!=null)
				os.close();
			
			if(is!=null)
				is.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
