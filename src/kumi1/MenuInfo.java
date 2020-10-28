package kumi1;

import java.util.Scanner;

public class MenuInfo {
	private Scanner sc = new Scanner(System.in);
	
	MovieList tehMovie = new MovieList();
	
	public void mainMenu() {
		System.out.println("1. 영화예매");
		System.out.println("2. 예매확인");
		System.out.println("3. 예매취소");
		System.out.println("4. 종      료");
		System.out.println("(메인메뉴로 돌아가시려면 언제든지 "+"-1"+"을 입력해 주세요)");
	}
	
	public void selectName() {
		System.out.println("1. " + tehMovie.movie1.get(0).getName());
		System.out.println("2. " + tehMovie.movie2.get(0).getName());
		System.out.println("3. " + tehMovie.movie3.get(0).getName());
		System.out.print("선택해 주세요 >>");
	}
		
//	public String SeatsCheck(String name, String value) {
//		int temp = 0;
//		scannerErrCheck scanErr = new scannerErrCheck();
//		while(true) {
//			System.out.println("입력하신 " + name + "은(는)" + value + "입니다.");
//			System.out.print("맞으면 1 다시 입력하시려면 아무 숫자나 입력하세요 >>");
//			temp = sc.nextInt();
//			if(temp == 1) {
//				break;
//			} else {
//				System.out.print(name + "을(를) 입력해 주세요 >>");
//				value = scanErr.selectSeatsCheck(sc);;
//			}
//		}
//		return value;
//	}
	
	public String nameCheck(String name, String value) {
		int temp = 0;
		ScannerErrCheck scanErr = new ScannerErrCheck();
		while(true) {
			System.out.println("입력하신 " + name + "은(는)" + value + "입니다.");
			System.out.print("맞으면 1 다시 입력하시려면 아무 숫자나 입력하세요 >>");
			temp = sc.nextInt();
			if(temp == 1) {
				break;
			} else {
				System.out.print(name + "을(를) 입력해 주세요 >>");
				value = scanErr.nameCheck(sc);;
			}
		}
		return value;
	}
	
	public String phoneCheck(String name, String value) {
		int temp = 0;
		ScannerErrCheck scanErr = new ScannerErrCheck();
		while(true) {
			System.out.println("입력하신 " + name + "은(는)" + value + "입니다.");
			System.out.print("맞으면 1 다시 입력하시려면 아무 숫자나 입력하세요 >>");
			temp = sc.nextInt();
			if(temp == 1) {
				break;
			} else {
				System.out.print(name + "을(를) 입력해 주세요 >>");
				value = scanErr.phoneCheck(sc);;
			}
		}
		return value;
	}
}