package kumi1;

import java.util.Scanner;

public class ScannerErrCheck {
	private int scNum;
	private String scString;
	MovieList theMovie = Main.theMovie;
	public int menuNumCheck(Scanner scNum) {

		while(true) {
			if(scNum.hasNextInt()) {
				this.scNum = scNum.nextInt();
				if(this.scNum <= 0 || this.scNum >= 5) {
					System.out.print("1~4 사이의 숫자를 입력하세요 >>");
					scNum.reset();
					continue;
				}
			} else if(!scNum.hasNextInt()) {
				System.out.print("숫자로 입력해 주세요 >>");
				scNum.next();
				continue;
			}
			return this.scNum;
		}
	}
	
	public int movieNumCheck(Scanner scNum) {

		while(true) {
			if(scNum.hasNextInt()) {
				this.scNum = scNum.nextInt();
				if(this.scNum == -1) {
					return this.scNum;
				}
				if(this.scNum <= 0 || this.scNum >= 4) {
					System.out.print("1~3 사이의 숫자를 입력하세요 >>");
					scNum.reset();
					continue;
				}
			} else if(!scNum.hasNextInt()) {
				System.out.print("숫자로 입력해 주세요 >>");
				scNum.next();
				continue;
			}
			return this.scNum;
		}
	}
	
	public String selectSeatsCheck(Scanner scString, int movieNameSelect, int timeChoice) {
		char temp;
		char temp2;
		while(true) {
			if(scString.hasNext()) {
				this.scString = scString.next();
				this.scString = this.scString.toUpperCase();
				temp = this.scString.charAt(0);
				
				if(this.scString.equals("-1")) {
					return this.scString;
				}
				if(this.scString.length() >= 4 || this.scString.length() <= 1) {
					System.out.println("문자열2자리나 3자리로 입력해야 합니다.");
					System.out.print("다시 입력해 주세요 >>");
					scString.reset();
					continue;
				}
				temp2 = this.scString.charAt(1);
				
				if(!Character.isDigit(temp)) {
					System.out.println("첫번째 문자는 숫자로 입력해야힙니다.");
					System.out.print("다시 입력해 주세요 >>");
					scString.reset();
					continue;
				} else if(Character.isDigit(temp2)) {
					System.out.println("두째 문자는 문자로 입력해야힙니다.");
					System.out.print("다시 입력해 주세요 >>");
					scString.reset();
					continue;
				}
				
				if(this.scString.length() == 3) {
					char s = this.scString.charAt(1);
					char s1 = this.scString.charAt(2);
					if(s < 64 || s1 < 65) {
						System.out.println("A~L까지의 문자만 사용 가능합니다.");
						System.out.print("다시 입력해 주세요 >>");
						scString.reset();
						continue;
					} else if(s > 76 || s1 > 76) {
						System.out.println("A~L까지의 문자만 사용 가능합니다.");
						System.out.print("다시 입력해 주세요 >>");
						scString.reset();
						continue;
					} else if(s >= s1) {
						System.out.println("잘못 입력하셨습니다.");
						System.out.print("다시 입력해 주세요 >>");
						scString.reset();
						continue;
					}
					
				} else {
					char s = this.scString.charAt(1);
					if(s > 76) {
						System.out.println("A~L까지의 문자만 사용 가능합니다.");
						System.out.print("다시 입력해 주세요 >>");
						scString.reset();
						continue;
					}
				}
				
			}
			int[] seatNumBer = Main.SeatsNumber(this.scString);
			if(seatNumBer[2] == -1) {
				//한자리 예약
				
				if(!(theMovie.testSeats(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1]))) {
					scString.reset();
					selectSeatsCheck(scString, movieNameSelect, timeChoice);
				}
			} else {
				//여러자리예약
				if(!(theMovie.testSeats(movieNameSelect, timeChoice, seatNumBer[0], seatNumBer[1], seatNumBer[2]))) {
					scString.reset();
					selectSeatsCheck(scString, movieNameSelect, timeChoice);
				}
				
			}
			
			return this.scString;
		}
	}
	
	public String nameCheck(Scanner scString) {
		char temp;
		while(true) {
			boolean flag = true;
			if(scString.hasNext()) {
				this.scString = scString.next();
				if(this.scString.equals("-1")) {
					return this.scString;
				}
				for(int i = 0; i < this.scString.length(); i++) {
					temp = this.scString.charAt(i);
					if(Character.isDigit(temp)) {
						flag = false;
					}
				}
				if(!flag) {
					System.out.println("문자로 입력해 주세요.");
					System.out.print("다시 입력해 주세요 >>");
					scString.reset();
					continue;
				}
				return this.scString;
			}
		}
	}
	
	public String phoneCheck(Scanner scString) {
		char temp;
		while(true) {
			boolean flag = true;
			if(scString.hasNext()) {
				this.scString = scString.next();
				if(this.scString.equals("-1")) {
					return this.scString;
				} else if(this.scString.length() != 11) {
					System.out.println("11자리로 입력하세요 >>");
					scString.reset();
					continue;
				}
				for(int i = 0; i < this.scString.length(); i++) {
					temp = this.scString.charAt(i);
					if(Character.isDigit(temp)) {
						flag = false;
					}
				}
				if(flag) {
					System.out.println("숫자로 입력해 주세요.");
					System.out.print("다시 입력해 주세요 >>");
					scString.reset();
					continue;
				}
				return this.scString;
			}
		}
	}
	
}