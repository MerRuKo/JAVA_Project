package kumi2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static ArrayList<Info> array = new ArrayList<Info>();
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		
		//FileWrite fw = new FileWrite();                //수정
		//FileDelete dl = new FileDelete();			//수정
		//FileRead fr = new FileRead();			//수정
		
		String name;
		String phoneNumber;
		
		boolean flag = true;
		while(true) {
		System.out.println("********************************************");
		System.out.println("**       버스예매시스템에 오신 것을 환영합니다.       **");
		System.out.println("********************************************");
		System.out.println("********(본 버스는 서울, 부산 행 전용 버스입니다)*******");
		System.out.println("********************************************");
		System.out.println("*******           1. 예약하기                     *******");
		System.out.println("*******           2. 예약취소                     *******");
		System.out.println("*******           3. 예약조회                     *******");
		System.out.println("*******           4. 종료                           *******");
		System.out.println("********************************************");
		System.out.println("********************************************");
			
		int listNum = in.nextInt();
			
		switch (listNum) {
			case 1: // 예약하기
				Info info= new Info();
				System.out.println("이름을 입력해주세요");
				info.setName(in.next());
				System.out.println("번호를 입력해주세요");
				info.setPhoneNumber(in.next());
				DayTime date=new DayTime();
				date.selDate();
				date.showre();
				info.setTime(date.btime);
				info.setDate(date.bday);
				array.add(info);
				Terminal.run(); 
				SeatReserv t1=new SeatReserv("서울","부산");
				while (true) {
					System.out.println();
					System.out.println("좌석 예약 시스템에 오신 걸 환영합니다.");
					System.out.println("*******************************************");
	    			System.out.println("*******       [1] 좌석 예약               *******");
	    			System.out.println("*******       [2] 예약 취소                   *******");
	    			//System.out.println("*****    3) 결제         *****");
	    			System.out.println("*******       [3] 좌석 현황                   *******");
	    			System.out.println("*******       [4] 결제 창                  *******");
	    			System.out.println("*******************************************");
					Scanner sc = new Scanner(System.in);
					String num1 = sc.next();
					int num;
					switch (num1) {
					case "1": case "2": case "3": case "4":
						num=Integer.parseInt((String) num1.subSequence(0,1));
						break;

					default:
						System.out.println("숫자를 다시 입력해주세요");
						continue;
					}

					int set;
					String set2,set3;
					switch (num) {
					case 1:
						t1.show();
						System.out.print("예약할 좌석을 입력해주세요 >>EX) 1A");
						set2 = sc.next();	
						if(set2.length()!=2) {System.out.println("다시입력하시오");continue;}	//1A라는 양식에 맞는지 1차적으로 확인
						char x=set2.charAt(0);												
						if(Character.isDigit(x)) {						//2차적으로 처음의 수가 정수형이 맞는지 참거짓을 구분하여 continue
							//System.out.println("계속해서 입력해 주세요");
						}
						else {
							System.out.println("좌석을 다시 양식에 맞게 입력해주세요");
							continue;
						}
						set=Integer.parseInt((String) set2.subSequence(0,1));	//확인된 문자열이 양식에 맞다면 정수와 문자열로 나누어
						set3=set2.substring(1,2);								
						t1.setSeat(set, set3);									//생성했던 메서드에 삽입하여 예약
						break;
						
					case 2:
						t1.show();
						System.out.print("예약취소할 좌석을 입력해주세요 >>EX) 1A");
						set2 = sc.next();
						if(set2.length()!=2) {System.out.println("다시입력하시오");continue;}
						 x=set2.charAt(0);
						if(Character.isDigit(x)) {
							System.out.println("계속해서 입력해 주세요");
						}
						else {
							System.out.println("좌석을 다시 양식에 맞게 입력해주세요");
							continue;
						}
						set=Integer.parseInt((String) set2.subSequence(0,1));
						set3=set2.substring(1,2);
						t1.returnSeat(set, set3);
						break;
						
					case 3:
						t1.show();
						
						break;
					case 4:
						Payment.run();
						FileWrite.run();  //수정
						System.out.println("서비스를 종료합니다. 감사합니다.");
						return;

					default:
						break;
					}
					
				}

																
			case 2: // 예약 취소
				System.out.println("이름을 입력해주세요");
				name = in.next();
				System.out.println("번호를 입력해주세요");
				phoneNumber = in.next();
				
				for(int i = 0; i < array.size(); i++) {
					if(array.get(i).getName().equals(name) && array.get(i).getPhoneNumber().equals(phoneNumber)) {
						array.remove(i);
						FileDelete.run();		//수정
						System.out.println("예약이 취소되었습니다.");
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("일치하는 정보가 없습니다.");
				}
				
				System.out.println("예약 취소가 종료됩니다. 감사합니다.");
				return;											
																	
			case 3:
				System.out.println("이름을 입력해주세요");
				name = in.next();
				System.out.println("번호를 입력해주세요");
				phoneNumber = in.next();
				for(int i = 0; i < array.size(); i++) {
					if(array.get(i).getName().equals(name) && array.get(i).getPhoneNumber().equals(phoneNumber)) {
						FileRead.run();  //수정
						
						//System.out.println("예약자 이름 : " + array.get(i).showName());
						//System.out.println("예약자 번호 : " + array.get(i).showNumber());
						//System.out.println("예약 날짜 : " + array.get(i).getDate() );
						//System.out.println("예약 시간 : " + array.get(i).getTime() );
						flag = false;
						break;
					}
				}
				if(flag) {
					System.out.println("일치하는 정보가 없습니다.");
				}														
				
				System.out.println("예약조회가 종료됩니다. 감사합니다.\n\n\n");
				return;
																			//삭제
				
			case 4:
				System.out.println("프로그램이 종료됩니다. 감사합니다.");
				return;
														//-종료
			default:
				break;
			}
		
			
		
		} // while 부분

	}
}