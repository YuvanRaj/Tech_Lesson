package com.tech.encoding;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeAndDeserialize {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serialize();
		deserialize();

	}

	private static void deserialize() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("C:\\Users\\Yuvaraj\\Desktop\\f.txt"));  
		Employee e=(Employee)in.readObject();  
		  System.out.println(e.getEmpId()+" "+e.getName());  
		  in.close();  
		
	}

	private static void serialize() throws IOException {
		Employee e1 =new Employee(211,"ravi");//creating object  
		  //writing object into file  
		  FileOutputStream f=new FileOutputStream("C:\\Users\\Yuvaraj\\Desktop\\f.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(f);  
		  out.writeObject(e1);  
		  out.flush();  
		  
		  out.close();  
		  f.close();  
		  System.out.println("success");
		
	}

}
