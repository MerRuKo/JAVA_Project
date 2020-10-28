package kumi2;

import java.io.File;

public class FileDelete {

	static void run() {
		try {
			String fileName = "./BUS.txt";
			File file = new File(fileName);
			if(file.exists()) {
				System.out.println(file.delete());		//파일삭제
			} else {
				System.out.println(fileName + "파일이 존재하지 않습니다.");
			}
			
		}catch(Exception e) {
			System.out.println("파일 접근 실패 : " + e);
		}

	}

}