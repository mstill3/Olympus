package com.stillwell.olympus.athena.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;

public class StudentHandler
{

	public void registerStudent(int id, String name)
	{
		Student s1 = new Student(id, name);
		try
		{
			FileOutputStream fout = new FileOutputStream("res/" + id + ".txt");
			try
			{
				ObjectOutputStream out = new ObjectOutputStream(fout);
				
				out.writeObject(s1);
				out.flush();
				out.close();
				System.out.println("success");

			} catch (IOException e) {
				System.out.println("ERROR: Could not write to location");
			}

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File Not Found");
		}
	}

	public void readStudentFile(int id)
	{
		try
		{
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("res/" + id + ".txt"));
			Student s;
			try
			{
				s = (Student) in.readObject();

				System.out.println(s.id + "  " + s.name);
				in.close();
			} catch (ClassNotFoundException e) {
				System.out.println("ERROR: Class Not Found");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Could not read from location");
		}
	}

//	public static String encrypt(String key, String initVector, String value) {
//		try {
//			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
//
//			byte[] encrypted = cipher.doFinal(value.getBytes());
//			System.out.println("encrypted string: "
//					+ DatatypeConverter.printBase64Binary(encrypted));
//
//			return DatatypeConverter.printBase64Binary(encrypted);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return null;
//	}
//
//	public static String decrypt(String key, String initVector, String encrypted) {
//		try {
//			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
//			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
//
//			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
//			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
//
//			byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));
//
//			return new String(original);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return null;
//	}

	public String[] getIDsInSystm()
	{
		File dir = new File("res/");
		return dir.list();
	}

}
