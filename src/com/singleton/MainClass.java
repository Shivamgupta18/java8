package com.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class MainClass {
	public static void main(String[] args) throws Exception {
		DesignPattern d1 = DesignPattern.getInstance();
		System.out.println(d1.hashCode());
		DesignPattern d2 = DesignPattern.getInstance();
		System.out.println(d2.hashCode());

		// Reflection api
		// deerilization
		// clonable
		/*
		 * Constructor<DesignPattern> f1 = DesignPattern.class.getDeclaredConstructor();
		 * f1.setAccessible(true); 
		 * DesignPattern d5=f1.newInstance();
		 * System.out.println(d5.hashCode());
		 */
		/*
		 * FileOutputStream f1=new FileOutputStream("C:\\Shivam\\serilization.txt");
		 * ObjectOutputStream d7=new ObjectOutputStream(f1); 
		 * d7.writeObject(d2);
		 * 
		 * FileInputStream f7=new FileInputStream("C:\\Shivam\\serilization.txt");
		 * ObjectInputStream d8=new ObjectInputStream(f7); 
		 * DesignPattern
		 * 
		 * d5=(DesignPattern) d8.readObject(); 
		 * System.out.println(d5.hashCode());
		 */

		DesignPattern s1 = (DesignPattern) d1.clone();
		System.out.println(s1.hashCode());

	}
}
