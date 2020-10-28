package kumi2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWrite {
		static void run()  {
			// 파일 쓰기
			FileWriter fw = null;
			PrintWriter out = null;
			try {
				String fileName = "./BUS.txt";
				//파일쓰기모드에서파일이 없으면 생성됨.
				//true : 추가(append)
				//false : 덮어쓰기
				fw = new FileWriter(fileName,  false);
				out = new PrintWriter(fw, true);
				
				ArrayList<Info> info= Main.array;
				
				//DayTime date = new DayTime();
				//저장되야 하는 것 : ㅇ월 ㅇ일 ㅇ시 ㅇ분 ㅇㅇ자리 예약완료되었습니다.
//				String name = info.getName();
//				String phone = info.getPhoneNumber();
				out.println("예약자 이름 : " + info.get(info.size()-1).getName());
				out.println("예약자 전화번호 : " + info.get(info.size()-1).getPhoneNumber());
				out.println("예약 날짜 : " + info.get(info.size()-1).getDate());
				out.println("예약 시간 : " + info.get(info.size()-1).getTime());
				out.println("으로 예약완료되었습니다.");
			}catch(Exception e){
				System.out.println("파일 쓰기 실패 : "+ e);
			}finally {
				try {
					out.close();
					fw.close();
				}catch(Exception e) {	}
			}

		}//main-end

}//class-end