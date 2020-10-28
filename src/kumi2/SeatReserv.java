package kumi2;

public class SeatReserv {
	private int[][] seat = new int[8][4];
	private String name1;//출발지
	private String name2;//도착지
	
	public String getName1() {
		return name1;
	}
	public String getName2() {
		return name2;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	//생성자
	public SeatReserv(String name1, String name2) {
		this.name1 = name1;
		this.name2 = name2;
		
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				seat[i][j] = 0;
			}
		}
	}
	// 현제 좌석 예약현황
	public void show() {
		int count = 1;
		System.out.println("출발지 : " + name1);
		System.out.println("도착지 : " + name2);
		System.out.println(" [예약현황]");
		System.out.println("  AB CD");
		for(int i = 0; i < seat.length; i++) {
			System.out.print(count++ +" ");
			for(int j = 0; j < seat[i].length; j++) {
				if(seat[i][j] == 0) {
					System.out.print("□");
					
				} else {
					System.out.print("■");
				}
				if(j == 1){
					System.out.print(" ");
				}
			}
			
			System.out.println();
		}
	}
	//좌석 예약
	public void setSeat(int a, String b) {
		int num1 = a-1;
		int num2 = 0;
		
		switch (b) {
		case "A":
			num2 = 0;
			break;
		case "B":
			num2 = 1;
			break;
		case "C":
			num2 = 2;
			break;
		case "D":
			num2 = 3;
			break;

		default:
			break;
		}
		if(seat[num1][num2] == 0) {
			seat[num1][num2] = 1;
			System.out.println("예약되었습니다.");
		} else {
			System.out.println("이미 예약되있습니다.");
		}
	}
	//예약 취소
	public void returnSeat(int a, String b) {
		int num1 = a-1;
		int num2 = 0;
		
		switch (b) {
		case "A":
			num2 = 0;
			break;
		case "B":
			num2 = 1;
			break;
		case "C":
			num2 = 2;
			break;
		case "D":
			num2 = 3;
			break;

		default:
			break;
		}
		System.out.println("예약 취소되었습니다.");
		seat[num1][num2] = 0;
	}
	
	//남은좌석 수를 보여주는 메서드
	public int seatNum() {
		int count = 0;
		int sum = 0;
		for(int i = 0; i < seat.length; i++) {
			for(int j = 0; j < seat[i].length; j++) {
				sum++;
				if(seat[i][j] == 1) {
					count++;
				}
			}
		}
		
		return sum-count;
	}
}