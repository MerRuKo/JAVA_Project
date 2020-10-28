package kumi1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
/*
 * 대충하는설명
 *while문으로 무한반복을 돌리고
 *switch case 문으로 메인 메뉴를 선택 
 *1. 영화예매 선택시 ->1.1영화종류 선택 -> 1.2시간 선택->
 *	  1.3 좌석 선택->1.4이름입력->1.5전화번호입력->
 *	   이름 전화번호 영화제목 영화시간 좌석번호 를TicketManager를 ArrayList로 생성해 저장 후
 *	   예약이 완료되었습니다.
 *	   예약자명 : 김개똥 
 *	   예매번호 : 85145011340
 *   영화제목 : 엄복동
 *   상영시간 : 00시00분
 *   좌석번호 : 3F
 *   결제금액 : 000원
 *   등등 출력
 *	 
 *	 출력 후 txt파일로 위 정보 전부저장
 * 	 후 메인메뉴로돌아감
 * -----------------------------------------------------------
 *   각종 예외사항 해결해야함ex)scanner사용시 정수형에 문자입력하는경우 등등
 * -----------------------------------------------------------
 *   2. 예매확인 선택시 ...
 *   예약자 이름, 휴대폰 번호 입력을 받고
 *   TicketManager.zise 만큼 for문을 돌려서 
 *   TicketManager.get(i).getGustName 과 TicketManager.get(i).getGusPhone가 입력 값과 일치하는지 확인
 *   후 일치하면 theTicket.get(i).getAllInfo() 실행
 *   getAllInfo() 는 리턴값이 배열이며 예약후 출력되는 모든 정보가 담겨있음
 * -----------------------------------------------------------
 *   3. 예매취소 선택시 ...
 *   예약자 이름, 휴대폰 번호 입력을 받고
 *   TicketManager.zise 만큼 for문을 돌려서 
 *   TicketManager.get(i).getGustName 과 TicketManager.get(i).getGusPhone가 입력 값과 일치하는지 확인
 *   theMovie.deleteSeats를 사용하여 좌석배열에 1로 되있는것을 0 으로 돌린후 
 *   TicketManager.remove(i)를 실행하여 정보를 삭제
 */
	
//	멤버변수로 선언한 이유는 scannerErrCheck클래스에서
//	MovieList theMovie = Main.theMovie; 로 사용하기 위함	아래 선언문을 클래스 안에 넣으면
//	scannerErrCheck클래스에서 new MovieList()로 생성해야하는데 new로 생성하면 메인에있는 theMovie와 다른 새로운것을 만드는것이기 때문에
//	좌석예약시 중복된 좌석을 예약시 에러메시지가 나오지 않음.
	static MovieList theMovie = new MovieList();
	
	//좌석 입력을 1A, 1AC <-의형태로 받기때문에 2차원배열로 되있는 좌석에 적용하기위해 사용
	//1A입력시 00리턴 1AB입력시 001리턴  (A=0, B=1, C=2, D=3....)
	public static int[] SeatsNumber(String selectSeats) {
		int x = -1;
		String y = "", y1 = "";
		int num = -1, num1 = -1;
		int[] result = {-1, -1, -1};
		
		//한자리 이상 예약할 경우
		if(selectSeats.length() == 3) {
			x = Integer.parseInt(selectSeats.substring(0, 1));
			y = selectSeats.substring(1, 2);
			y1 = selectSeats.substring(2, 3);
			//ex)[x][y~y1]
			
			//한자리 예약할 경우
		} else if (selectSeats.length() == 2) {
			x = Integer.parseInt(selectSeats.substring(0, 1));
			y = selectSeats.substring(1, 2);
		}
		switch (y) {
		case "A": num = 0;break;	case "B": num = 1;break;
		case "C": num = 2;break;	case "D": num = 3;break;
		case "E": num = 4;break;	case "F": num = 5;break;
		case "G": num = 6;break;	case "H": num = 7;break;
		case "I": num = 8;break;	case "J": num = 9;break;
		case "K": num = 10;break;	case "L": num = 11;break;
		default:
			break;
		}
		if(y1 != "") {
			switch (y1) {
			case "A": num1 = 0;break;	case "B": num1 = 1;break;
			case "C": num1 = 2;break;	case "D": num1 = 3;break;
			case "E": num1 = 4;break;	case "F": num1 = 5;break;
			case "G": num1 = 6;break;	case "H": num1 = 7;break;
			case "I": num1 = 8;break;	case "J": num1 = 9;break;
			case "K": num1 = 10;break;	case "L": num1 = 11;break;
			default:
				break;
			}
			result[0] = x-1; result[1] = num; result[2] = num1;
		} else {
			result[0] = x-1; result[1] = num;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<TicketManager> theTicket = new ArrayList<TicketManager>();
		MenuInfo theMenu = new MenuInfo();
		IoManager theIO = new IoManager();
		ScannerErrCheck scanErr = new ScannerErrCheck();
		
		while(true) {
			System.out.println("[메인 메뉴]");
			theMenu.mainMenu();						//메뉴목록 출력
			System.out.print("선택해 주세요 >>"); 
			int menuSelect = 0;						//메뉴선택 변수
			menuSelect = scanErr.menuNumCheck(sc);	//메뉴선택입력  문자입력이나 1~4까지의 숫자입력방지를 위해 scanErr클래스 사용
			
			int movieNameSelect = 0;				//영화선택 변수
			int timeChoice = 0;						//시간선택 변수
			String selectSeats = "";				//좌석선택 변수
			
			switch (menuSelect) {					//메뉴선택 스위치문
			case 1:
				System.out.println("[영화 선택]");
				theMenu.selectName();				//영화리스트 출력
				movieNameSelect = scanErr.movieNumCheck(sc);	//영화선택입력 문자입력이나 1~3까지의 숫자입력방지를 위해 scanErr클래스 사용
				if(movieNameSelect == -1) {						//입력값이 -1이면 메뉴선택으로 돌아감
					continue;
				}
				
				theMovie.seleceTime(movieNameSelect);		//선택한 영화의 시간대 + 남은 좌석 수를 보여줌 
				timeChoice = scanErr.movieNumCheck(sc);		//영화시간 선택 문자입력이나 1~3까지의 숫자입력방지를 위해 scanErr클래스 사용
				if(timeChoice == -1) {						//입력값이 -1이면 메뉴선택으로 돌아감
					continue;
				}
				
				theMovie.showSeats(movieNameSelect, timeChoice);	//좌석배치도 표시
				System.out.println("선택 예시 (한자리 : 1A),(한자리 이상 : 1AC)");
				System.out.print("좌석 선택 >>");
				selectSeats = scanErr.selectSeatsCheck(sc, movieNameSelect, timeChoice);	//좌석 번호입력
				if (selectSeats.equals("-1")) {				//입력값이 -1이면 메뉴선택으로 돌아감
					continue;
				}
				
//				selectSeats = theMenu.SeatsCheck("좌석", selectSeats);//좌석을 잘못입력했을 때를 대비해 입력한 값이 맞는 값인지 확인
				
				int[] seatNumBer = SeatsNumber(selectSeats);	//숫자로 되있는 좌석번호를 전부 숫자로 바꿔줌 ex)1A=00, 1B=01, 2C=12, 3AD=213

				System.out.print("이름을 입력해 주세요 >>");
				String gustName = scanErr.nameCheck(sc);		//이름 입력 숫자입력 방지를 위해 scanErr.nameCheck사용
				if (gustName.equals("-1")) {					//입력값이 -1이면 메뉴선택으로 돌아감
					continue;
				}
				
//				gustName = theMenu.nameCheck("이름", gustName);//이름을 잘못입력했을 때를 대비해 입력한 값이 맞는 값인지 확인
				
				System.out.print("핸드폰번호를 입력해 주세요 >>");
				String gustPhone = scanErr.phoneCheck(sc);		//핸드폰 번호 입력 문자입력 방지, 11자리입력을 위해 scanErr.nameCheck사용
				if (gustPhone.equals("-1")) {					//입력값이-1이면 메뉴선택으로 돌아감
					continue;
				}
//				gustPhone = theMenu.phoneCheck("핸드폰번호", gustPhone);//핸드폰번호를 잘못입력했을 때를 대비해 입력한 값이 맞는 값인지 확인
				
				//이름 전화번호 영화제목 영화시간 좌석번호 저장
				theTicket.add(new TicketManager(gustName, gustPhone, theMovie.getMovieName(movieNameSelect), theMovie.getMovieTime(movieNameSelect, timeChoice), theMovie.getPrice(movieNameSelect, timeChoice), selectSeats));
				
				if(seatNumBer[2] == -1) {
					//한자리 예약
					theMovie.selectSeats(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1]);
					//예약정보 저장
					theTicket.get(theTicket.size()-1).setData(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1]);
				} else {
					//여러자리예약
					theMovie.selectSeats(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1], seatNumBer[2]);
					//예약정보 저장
					theTicket.get(theTicket.size()-1).setData(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1], seatNumBer[2]);
				}
				System.out.println("예매가 완료되었습니다.");
				System.out.printf("\n\n");
				System.out.println("[예매정보]");
				String[] s = theTicket.get(theTicket.size()-1).getAllInfo();
//				예약 정보 출력
				for(String i : s) {
					System.out.println(i);
				}
//				C:\TeamProject1 에 TXT파일 출력
				theIO.setFile(theTicket.get(theTicket.size()-1).getAllInfo(), movieNameSelect, timeChoice, seatNumBer);
				
				System.out.println("영수증출력완료");
				System.out.printf("\n\n");
				break;
			case 2:
				//2. 예매확인
				// 이름 전화번호를 입력받고 theTicket의 사이즈만큼 반복문을 돌려서
				// 입력받은 이름 전화번호랑 일치하는 값이 있으면 해당인덱스의 getAllInfo(예매자 정보)를 출력함
				System.out.print("예약자 이름을 입력하세요 >>");
				String ticketName = scanErr.nameCheck(sc);
				if (ticketName.equals("-1")) {
					continue;
				}
				System.out.print("예약자 핸드폰 번호를 입력하세요 >>");
				String ticketPhone = scanErr.phoneCheck(sc);
				if (ticketPhone.equals("-1")) {
					continue;
				}
				boolean flag = true;
				for(int i = 0; i < theTicket.size(); i++) {
					
					//입력받은 이름 전화번호랑 일치하는 값이 있는지 확인
					if(theTicket.get(i).getGustName().equals(ticketName) && theTicket.get(i).getGustPhone().equals(ticketPhone)) {
						System.out.println("[예매정보]");
						
						//정보 출력
						for(String temp : theTicket.get(i).getAllInfo()) {
							System.out.println(temp);
						}
						flag = false;
					}
					if(!flag) {
						break;
					}
				}
				if(flag) {
					System.out.println("일치하는 정보가 없습니다.");
				}
				break;
			case 3:
				//3. 예매취소
				System.out.print("예약자 이름을 입력하세요 >>");
				ticketName = scanErr.nameCheck(sc);
				if (ticketName.equals("-1")) {
					continue;
				}
				System.out.print("예약자 핸드폰 번호를 입력하세요 >>");
				ticketPhone = scanErr.phoneCheck(sc);
				if (ticketPhone.equals("-1")) {
					continue;
				}
				flag = true;
				for(int i = 0; i < theTicket.size(); i++) {
					if(theTicket.get(i).getGustName().equals(ticketName) && theTicket.get(i).getGustPhone().equals(ticketPhone)) {
						TicketManager t = theTicket.get(i);
						
						if(theTicket.get(i).getSeat2() == -1) {
							theMovie.deleteSeats(t.getMovieNameSelect(), t.getTimeChoice(), t.getSeat(), t.getSeat1());
						} else {
							theMovie.deleteSeats(t.getMovieNameSelect(), t.getTimeChoice(), t.getSeat(), t.getSeat1(), t.getSeat2());
						}
						System.out.println("예매가 취소되었습니다.");
						theTicket.remove(i);
						flag = false;
					}
					if(!flag) {
						break;
					}
				}
				if(flag) {
					System.out.println("일치하는 정보가 없습니다.");
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				break;
			}
		}
	}
}