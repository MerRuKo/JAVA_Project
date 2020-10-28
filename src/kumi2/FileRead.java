package kumi2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {
	static void run() {
		     try{
		             
		    	 File file = new File("C:\\workspace\\basicJava\\BUS.txt");
		             
		         Scanner scan = new Scanner(file);
		         while(scan.hasNextLine()){
		          System.out.println(scan.nextLine());
		         }
		             
		     }catch (FileNotFoundException e) {
		             // TODO: handle exception
		        }
	}
}
