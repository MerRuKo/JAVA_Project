package kumi2;

import java.util.*;

public class Payment {
	public static int pay;	
	
	static String name;
	static int number;
	
	public static int getPoint() {
		return number*100;
	}
	
	static void run() throws InputMismatchException{
		System.out.println("결제하실 요금은 :"+pay+" 입니다.");
		System.out.println("저희는 1회 이용시 100포인트(100원) 씩 드리고 있습니다.");
		Scanner in = new Scanner(System.in);
		System.out.println("현재 보유하신 포인트는 "+getPoint()+"입니다.");
		System.out.println("보유하신 포인트를 사용하시겠습니까? 1. yes 2. no");
		boolean yes = false;
		String y = in.next();
		if(y.equals("1")) {
			yes = true;
		}
		while(!(y.equals("1") || y.equals("2"))) {
			System.out.println("알맞은 형태로 입력하십시오.");
			System.out.println("결제 하시겠습니까? 1. yes 2. no");
			y = in.next();
		}
		int point = getPoint();
		if(yes) {
			pay = pay - point;
			System.out.println("요금은 : "+pay+"입니다.");
		} else {
			System.out.println("요금은 : "+pay+"입니다.");
		}
		boolean no = false;
		try {
				System.out.println("결제 하시겠습니까? 1. yes 2. no");
				String yn = in.next();
				while(!(yn.equals("1") || yn.equals("2"))) {
					System.out.println("알맞은 형태로 입력하십시오.");
					System.out.println("결제 하시겠습니까? 1. yes 2. no");
					yn = in.next();
				}
				while(!no) {
					if(yn.equals("1")) {
						System.out.println("결제 되셨습니다.");
						System.out.println("지금까지 저희 버스 예매를 이용해주셔서 감사합니다.");
						return;
					}else {
						System.out.println("결제를 진행하시지 않으면 이제까지 한 게 취소됩니다.");
						System.out.println("결제 진행하시겠습니까? 1. yes 2. no");
						if(in.next() == "1") {
							yn = "1";
						} else {
							no = true;
						}
					}
				}
			}catch(Exception e) {
				System.out.println("알맞은 형태로 입력하십시오.");
			}
	}
}