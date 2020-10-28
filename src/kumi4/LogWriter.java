package kumi4;

import java.io.File;
import java.io.FileWriter;

public class LogWriter {
	static public void logWriter(String str) {
		String path = "C:\\workspace\\my_Project\\src\\kumi4_1\\TextRPG.txt";
		File file = new File(path);
		FileWriter fileWriter = null;
		
		try {
			if (file.exists() == false) {
				file.createNewFile();
			}
			
			fileWriter = new FileWriter(file, true);
			fileWriter.write(str + "\n");
			fileWriter.close();
			
		} catch (Exception e) {
			System.out.println("등록에 실패");
		}
	}
}