package com.accolite.serialize;
import java.io.*;
public class SerializeStudent {

		String pathName = "C:/Users/sivagami.s/Desktop/SerializedStudentFile.ser";

		public static void printdata(Student stu) {
			System.out.println(stu);
		}

		public void writObjectToFile(Student s) {
			try {

				FileOutputStream fos = new FileOutputStream(pathName);
				ObjectOutputStream out = new ObjectOutputStream(fos);
				out.writeObject(s);
				out.close();
				out.flush();
				fos.close();
				System.out.println("SERIALIZED\n" + "Data before Deserialization:");
				printdata(s);
			} catch (IOException ex) {
				System.out.println("IOException is caught");
			}
		}

		public Student readObjectFromFile() {
			Student s = null;
			try {
				FileInputStream fis = new FileInputStream(pathName);
				ObjectInputStream in = new ObjectInputStream(fis);
				s = (Student) in.readObject();
				in.close();
				fis.close();
				System.out.println("DESERIZLIZED\n" + "Data after Deserialization:");
				printdata(s);
			} catch (IOException ex) {
				System.out.println("IOException is caught");
			} catch (ClassNotFoundException ex) {
				System.out.println("ClassNotFoundException" + " is caught");
			}
			return s;
		}

		public static void main(String[] args) {
			Address add=new Address("No 9 Officerslane","Vellore","TamilNadu",632221);
			Student s=new Student("Sivagami","S",3011,12,"B",75,add);
			SerializeStudent ss=new SerializeStudent();
			ss.writObjectToFile(s);
			ss.readObjectFromFile();
			Student s1=new Student("Pavitra","Rajesekar",3611,12,"C",90,add);
			ss.writObjectToFile(s1);
			ss.readObjectFromFile();

		}

}
