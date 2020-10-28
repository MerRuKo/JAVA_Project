package kumi1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
/*
 *사용자가 예약을 완료하면
 *이름,영화,시간,좌석,예매번호, 폰번호, 결제시각,결제방법 등등을 
 *TicketManager에서 가져와서 txt파일로저장
 */
public class IoManager {
	
	//폴더 유무 확인 후 존재하지않을경우 폴더 생성
	public IoManager(){
		try {
			setFolder();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void setFolder() throws IOException{
		//폴더 유무 확인 후 존재하지않을경우 폴더 생성
		File Folder = new File("C:\\TeamProject1");
		if (!Folder.exists()) {
			Folder.mkdir(); //폴더를 생성합니다.
		}
	}
	
	public void setFile(String[] Info, int movieNameSelect, int timeChoice, int[] seatNumBer) throws IOException {
		//파일 유무 확인 후 존재하지않을경우 파일 생성
		String fileName = "C:\\TeamProject1\\" + "영수증" + Info[Info.length-1].substring(7) + ".txt";
		
		FileWriter fw = new FileWriter(fileName, false);//false 덮어쓰기  true 추가하기

		PrintWriter out = new PrintWriter(fw, true);
		out.println("[영수증]");
		for(String s : Info) {
			out.println(s);
		}
		MovieList theMovie = new MovieList();
		String[] s;
		out.println();
		out.println("\t         스크린");
		if(seatNumBer[2] == -1) {
			switch (movieNameSelect) {
			case 1:
				s = theMovie.movie1.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			case 2:
				s = theMovie.movie2.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			case 3:
				s = theMovie.movie3.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			default:
				break;
			}
		} else {
			switch (movieNameSelect) {
			case 1:
				s = theMovie.movie1.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1], seatNumBer[2]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			case 2:
				s = theMovie.movie2.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1], seatNumBer[2]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			case 3:
				s = theMovie.movie3.get(timeChoice).tempShowRoom(seatNumBer[0], seatNumBer[1], seatNumBer[2]);
				for(String temp : s) {
					out.println(temp);
				}
				break;
			default:
				break;
			}
		}
	}

}