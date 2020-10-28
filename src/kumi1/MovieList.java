package kumi1;

import java.util.ArrayList;

public class MovieList extends MovieManager{
	//MovieManager상속받음
/*
 *기능정리
 * getMovieName(int movieNameSelect)
 * 1.1영화종류를 선택한 변수를 받아서 영화 제목을 반환하는 메소드
 * 
 * getMovieTime(int timeChoice)
 * 1.2시간을 선택한 변수를 받아서 상영시간을 반환하는 메소드
 * 
 * seleceTime(int movieNameSelect)
 * 1.1에서 영화제목을 선택한변수를받아서 해당 영화의 시간표와 빈좌석개수를 알려줌
 * 
 * selectSeats(int movieNameSelect, int timeChoice, int seats, int seats1)
 * 좌석을 선택하는 메서드 1.1영화제목, 1.2영화시간 그리고 좌석번호(1A)를 메인클래스에있는SeatsNumber메소드에 넣고 돌린 값(00)을 받아와서 예약해주는 메서드
 * 
 * selectSeats(int movieNameSelect, int timeChoice, int seats, int seats1, int seats2)
 * 좌석을 선택하는 메서드 1.1영화제목, 1.2영화시간 그리고 좌석번호(1AC)를 메인클래스에있는SeatsNumber메소드에 넣고 돌린 값(002)을 받아와서 예약해주는 메서드
 * 
 * deleteSeat(int movieNameSelect, int timeChoice, int seats, int seats1)
 * 예약을 취소하는 메서드
 * 
 * deleteSeat(int movieNameSelect, int timeChoice, int seats, int seats1, int seats2)
 * 예약을 취소하는 메서드
 * 
 * showSeats(int movieNameSelect, int timeChoice)
 * 영화제목과 상영시간을 받아서 좌석 배치도를 표시하는 메서드
 * 
 */	
	ArrayList<MovieManager> movie1 = new ArrayList<MovieManager>();
	ArrayList<MovieManager> movie2 = new ArrayList<MovieManager>();
	ArrayList<MovieManager> movie3 = new ArrayList<MovieManager>();
	
	public MovieList() {
		
		movie1.add(new MovieManager("엄복동", 1000, "10:00~12:00"));
		movie1.add(new MovieManager("엄복동", 1100, "12:30~14:30"));
		movie1.add(new MovieManager("엄복동", 1200, "15:00~17:00"));
		
		movie2.add(new MovieManager("반지의제왕", 2000, "10:01~12:00"));
		movie2.add(new MovieManager("반지의제왕", 2100, "12:31~14:30"));
		movie2.add(new MovieManager("반지의제왕", 2200, "15:01~17:00"));
		
		movie3.add(new MovieManager("겨울왕국", 3000, "10:02~12:00"));
		movie3.add(new MovieManager("겨울왕국", 3100, "12:32~14:30"));
		movie3.add(new MovieManager("겨울왕국", 3200, "15:02~17:00"));
		
	}

	
//1.1영화종류를 선택한 변수를 받아서 영화 제목을 반환하는 메소드
	public String getMovieName(int movieNameSelect) {
		String name = "";
		switch (movieNameSelect) {
		case 1:
			name = movie1.get(0).getName();
			break;
		case 2:
			name = movie2.get(0).getName();
			break;
		case 3:
			name = movie3.get(0).getName();
			break;

		default:
			break;
		}
		return name;
	}

	//	1.2 영화종류를 선택한 변수, 시간을 선택한 변수를 받아서 상영시간을 반환하는 메소드
	public String getMovieTime(int movieNameSelectint, int timeChoice) {
		String time = "";
		switch (movieNameSelectint) {
		case 1:
			time = movie1.get(timeChoice-1).getTiem();
			break;
		case 2:
			time = movie2.get(timeChoice-1).getTiem();
			break;
		case 3:
			time = movie3.get(timeChoice-1).getTiem();
			break;

		default:
			break;
		}
		return time;
	}
//	1.1에서 영화제목을 선택한변수를받아서 해당 영화의 시간표와 빈좌석개수를 알려줌
	public void seleceTime(int movieNameSelect) {
		switch (movieNameSelect) {
		case 1:
			System.out.println("[" + movie1.get(0).getName() + " 시간표]");
			for(int i = 0; i < movie1.size(); i++) {
				System.out.print(i+1+". " + movie1.get(i).getTiem());
				System.out.print("   빈자리 : " + movie1.get(i).emptySeate());
				System.out.println("  가격 : " + movie1.get(i).getPrice() + "원");
			}
			break;
		case 2:
			System.out.println("[" + movie2.get(0).getName() + " 시간표]");
			for(int i = 0; i < movie2.size(); i++) {
				System.out.print(i+1+". " + movie2.get(i).getTiem());
				System.out.print("   빈자리 : " + movie2.get(i).emptySeate());
				System.out.println("  가격 : " + movie2.get(i).getPrice() + "원");
			}
			break;
		case 3:
			System.out.println("[" + movie3.get(0).getName() + " 시간표]");
			for(int i = 0; i < movie3.size(); i++) {
				System.out.print(i+1+". " + movie3.get(i).getTiem());
				System.out.print("   빈자리 : " + movie3.get(i).emptySeate());
				System.out.println("  가격 : " + movie3.get(i).getPrice() + "원");
			}
			break;

		default:
			break;
		}
		System.out.print("선택해 주세요 >>");
	}
	
//	좌석을 선택하는 메서드 1.1영화제목, 1.2영화시간 그리고 좌석번호(1A)를 메인클래스에있는SeatsNumber메소드에 넣고 돌린 값(00)을 받아와서 예약해주는 메서드
	public void selectSeats(int movieNameSelect, int timeChoice, int seats, int seats1) {
		timeChoice -= 1;
		switch (movieNameSelect) {
		case 1:
			if(movie1.get(timeChoice).getRoom()[seats][seats1] == 0) {
				movie1.get(timeChoice).sel_seats(seats, seats1);
			}else {
				System.out.println("이미 예약되어 있는 좌석입니다.");
			}
			break;
		case 2:
			if(movie2.get(timeChoice).getRoom()[seats][seats1] == 0) {
				movie2.get(timeChoice).sel_seats(seats, seats1);
			}else {
				System.out.println("이미 예약되어 있는 좌석입니다.");
			}
			break;
		case 3:
			if(movie3.get(timeChoice).getRoom()[seats][seats1] == 0) {
				movie3.get(timeChoice).sel_seats(seats, seats1);
			}else {
				System.out.println("이미 예약되어 있는 좌석입니다.");
			}
			break;

		default:
			break;
		}
	}
//	메서드 오버로딩
//	좌석을 선택하는 메서드 1.1영화제목, 1.2영화시간 그리고 좌석번호(1AC)를 메인클래스에있는SeatsNumber메소드에 넣고 돌린 값(002)을 받아와서 예약해주는 메서드
	public void selectSeats(int movieNameSelect, int timeChoice, int seats, int seats1, int seats2) {
		timeChoice -= 1;
		boolean flag = true;
		switch (movieNameSelect) {
		case 1:
			for(int i = seats1; i <= seats2; i++) {
				if(movie1.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				movie1.get(timeChoice).sel_seats(seats, seats1, seats2);
			}
			break;
		case 2:
			for(int i = seats1; i <= seats2; i++) {
				if(movie2.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				movie2.get(timeChoice).sel_seats(seats, seats1, seats2);
			}
			break;
		case 3:
			for(int i = seats1; i <= seats2; i++) {
				if(movie3.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				movie3.get(timeChoice).sel_seats(seats, seats1, seats2);
			}
			break;

		default:
			break;
		}
	}
	
	public boolean testSeats(int movieNameSelect, int timeChoice, int seats, int seats1) {
		timeChoice -= 1;
		boolean flag = false;
		switch (movieNameSelect) {
		case 1:
			if(movie1.get(timeChoice).getRoom()[seats][seats1] == 0) {
				flag = true;
			}else {
				flag = false;
				System.out.println("이미 예약되어 있는 좌석입니다.");
				System.out.print("다시 선택해 주세요 >>");
			}
			break;
		case 2:
			if(movie2.get(timeChoice).getRoom()[seats][seats1] == 0) {
				flag = true;
			}else {
				flag = false;
				System.out.println("이미 예약되어 있는 좌석입니다.");
				System.out.print("다시 선택해 주세요 >>");
			}
			break;
		case 3:
			if(movie3.get(timeChoice).getRoom()[seats][seats1] == 0) {
				flag = true;
			}else {
				flag = false;
				System.out.println("이미 예약되어 있는 좌석입니다.");
				System.out.print("다시 선택해 주세요 >>");
			}
			break;

		default:
			break;
		}
		return flag;
	}
	
	public boolean testSeats(int movieNameSelect, int timeChoice, int seats, int seats1, int seats2) {
		timeChoice -= 1;
		boolean flag = true;
		boolean flag2 = true;
		switch (movieNameSelect) {
		case 1:
			for(int i = seats1; i <= seats2; i++) {
				if(movie1.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					flag2 = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				flag2 = true;
			}
			break;
		case 2:
			for(int i = seats1; i <= seats2; i++) {
				if(movie2.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					flag2 = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				flag2 = true;
			}
			break;
		case 3:
			for(int i = seats1; i <= seats2; i++) {
				if(movie3.get(timeChoice).getRoom()[seats][i] == 1) {
					flag = false;
					flag2 = false;
					System.out.println("이미 예약되어 있는 좌석이 포함되있습니다.");
					System.out.print("다시 선택해 주세요 >>");
					break;
				}
			}
			if(flag) {
				flag2 = true;
			}
			break;

		default:
			break;
		}
		return flag2;
	}
	
	public void deleteSeats(int movieNameSelect, int timeChoice, int seats, int seats1) {
		timeChoice -= 1;
		switch (movieNameSelect) {
		case 1:
			movie1.get(timeChoice).del_seats(seats, seats1);
			break;
		case 2:
			movie2.get(timeChoice).del_seats(seats, seats1);
			break;
		case 3:
			movie3.get(timeChoice).del_seats(seats, seats1);
			break;
		default:
			break;
		}
	}
	public void deleteSeats(int movieNameSelect, int timeChoice, int seats, int seats1, int seat2) {
		timeChoice -= 1;
		switch (movieNameSelect) {
		case 1:
			movie1.get(timeChoice).del_seats(seats, seats1, seat2);
			break;
		case 2:
			movie2.get(timeChoice).del_seats(seats, seats1, seat2);
			break;
		case 3:
			movie3.get(timeChoice).del_seats(seats, seats1, seat2);
			break;
		default:
			break;
		}
	}
	
//	영화제목과 상영시간을 받아서 좌석 배치도를 표시하는 메서드
	public void showSeats(int movieNameSelect, int timeChoice) {
		timeChoice -= 1;
		System.out.println();
		switch (movieNameSelect) {
		case 1:
			movie1.get(timeChoice).showRoom();
			break;
		case 2:
			movie2.get(timeChoice).showRoom();
			break;
		case 3:
			movie3.get(timeChoice).showRoom();
			break;

		default:
			break;
		}
	}
	public int getPrice(int movieNameSelect, int timeChoice) {
		int p = 0;
		switch (movieNameSelect) {
		case 1:
			p = movie1.get(timeChoice-1).getPrice();
			break;
		case 2:
			p = movie2.get(timeChoice-1).getPrice();
			break;
		case 3:
			p = movie3.get(timeChoice-1).getPrice();
			break;

		default:
			break;
		}
		return p;
	}
}