package kumi1;


//movieList에 상속
public class MovieManager {
	private int[][] Room = new int[6][12];//상영관 좌석 배치도
	private int[][] tempRoom = new int[6][12];//상영관 좌석 배치도
	private String name;	//영화제목
	private int price;		//영화 가격
	private String time;	//상영시간
	
	//생성자
	public MovieManager() {
		reset_Room();
	}
	
	//매개변수가있는 생성자
	public MovieManager(String name, int price, String time) {
		this.name = name;
		this.price = price;
		this.time = time;
		reset_Room();
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getTiem() {
		return time;
	}
	
	//좌석배치를 예약좌석이 없는상태로 초기화
	public void reset_Room() {
		for(int i = 0; i < Room.length; i++) {
			for(int j = 0; j < Room[i].length; j++) {
				Room[i][j] = 0;
			}
		}
	}
	
	//좌석 배치도 출력
/*  
  A B C D E F   G H I J K L
1 □ □ □ □ □ □   □ □ □ □ □ □   
2 □ □ □ □ □ □   □ □ □ □ □ □   
3 □ □ □ □ □ □ 통  □ □ □ □ □ □   
4 □ □ □ □ □ □ 로  □ □ □ □ □ □   
5 □ □ □ □ □ □   □ □ □ □ □ □   
6 □ □ □ □ □ □   □ □ □ □ □ □   
*/
	public void showRoom() {
		int count = 0;
		System.out.println("\t         스크린");
		System.out.println("  A B C D E F   G H I J K L");
		int temp = 1;
		for(int i = 0; i < Room.length; i++) {
			System.out.print(temp++ + " ");
			for(int j = 0; j < Room[i].length; j++) {
				count++;
				System.out.print(Room[i][j] == 0 ? "□": "■");
				
				//통로 라고 써진 부분을 지우고 싶으면 여기서부터
				if(!(i == 2 && j == 5 || i == 3 && j == 5)) {
					System.out.print(" ");
				} 
				if(count % 6 == 0) {
					if(i == 2 && j != Room[i].length-1) {
						System.out.print(" 통 ");
					} else if(i == 3 && j != Room[i].length-1) {
						System.out.print(" 로 ");
					} else {
						System.out.print("  ");
					}
				}
				//여기까지 지우면됨
				
			}
			System.out.println();
		}
	}
	
	public String[] tempShowRoom(int x, int y) {
		int count = 0;
		String[] s = {"", "" , "", "", "", "", "", "", ""};
		for(int i = 0; i < tempRoom.length; i++) {
 			for(int j = 0; j < tempRoom[i].length; j++) {
				tempRoom[i][j] = 0;
			}
		}
		tempRoom[x][y] = 1;
//		System.out.print("\t         스크린");
//		System.out.print("  A B C D E F   G H I J K L");
		s[0] = "\t         내좌석";
		s[1] = "  A B C D E F   G H I J K L";

		int temp = 1;
		for(int i = 0; i < tempRoom.length; i++) {
//			System.out.print(temp++ + " ");
			s[i+2] += temp++ + " ";

			for(int j = 0; j < tempRoom[i].length; j++) {
				count++;
//				System.out.print(tempRoom[i][j] == 0 ? "□": "■");
				s[i+2] += tempRoom[i][j] == 0 ? "□": "■";
				//통로 라고 써진 부분을 지우고 싶으면 여기서부터
				if(!(i == 2 && j == 5 || i == 3 && j == 5)) {
//					System.out.print(" ");
					s[i+2] += " ";
				} 
				if(count % 6 == 0) {
					if(i == 2 && j != tempRoom[i].length-1) {
//						System.out.print(" 통 ");
						s[i+2] += " 통 ";
					} else if(i == 3 && j != tempRoom[i].length-1) {
//						System.out.print(" 로 ");
						s[i+2] += " 로 ";
					} else {
//						System.out.print("  ");
						s[i+2] += "  ";
					}
				}
				//여기까지 지우면됨
				
			}
//			System.out.println();
			s[i+2] +="\n";
		}
		return s;
	}
	
	public String[] tempShowRoom(int x, int y, int z) {
		int count = 0;
		String[] s = {"", "", "", "", "", "", "", "", ""};
		for(int i = 0; i < tempRoom.length; i++) {
			for(int j = 0; j < tempRoom[i].length; j++) {
				tempRoom[i][j] = 0;
			}
		}

		int count2 = z-y+1;
		
		for(int i = 0; i < count2; i++) {
			tempRoom[x][y] = 1;
			y++;
		}

//		System.out.println("\t         스크린");
//		System.out.println("  A B C D E F   G H I J K L");
		s[0] = "\t         내좌석";
		s[1] = "  A B C D E F   G H I J K L";
		int temp = 1;
		for(int i = 0; i < tempRoom.length; i++) {
//			System.out.print(temp++ + " ");
			s[i+2] += temp++ + " ";
			for(int j = 0; j < tempRoom[i].length; j++) {
				count++;
//				System.out.print(tempRoom[i][j] == 0 ? "□": "■");
				s[i+2] += tempRoom[i][j] == 0 ? "□": "■";
				//통로 라고 써진 부분을 지우고 싶으면 여기서부터
				if(!(i == 2 && j == 5 || i == 3 && j == 5)) {
//					System.out.print(" ");
					s[i+2] += " ";
				} 
				if(count % 6 == 0) {
					if(i == 2 && j != tempRoom[i].length-1) {
//						System.out.print(" 통 ");
						s[i+2] += " 통 ";
					} else if(i == 3 && j != tempRoom[i].length-1) {
//						System.out.print(" 로 ");
						s[i+2] += " 로 ";
					} else {
//						System.out.print("  ");
						s[i+2] += "  ";
					}
				}
				//여기까지 지우면됨
				
			}
//			System.out.println();
			s[i+2] += "\n";
		}
		return s;
	}
	
	//한자리 예약시 사용하는 좌석예약 메소드
	public void sel_seats(int x, int y) {
		Room[x][y] = 1;
	}
	//메서드 오버로딩
	//한자리이상 예약시 사용하는 좌석예약 메소드
	public void sel_seats(int x, int y, int y1) {
		int count = y1-y+1;
		
		for(int i = 0; i < count; i++) {
			Room[x][y] = 1;
			y++;
		}
	}
	
	//한자리 예약취소시 사용하는 좌석예약 메소드
		public void del_seats(int x, int y) {
			Room[x][y] = 0;
		}
		//메서드 오버로딩
		//한자리이상 예약취소시 사용하는 좌석예약 메소드
		public void del_seats(int x, int y, int y1) {
			int count = y1-y+1;
			
			for(int i = 0; i < count; i++) {
				Room[x][y] = 0;
				y++;
			}
		}
	
	//비어있는 좌석을 구하는 메소드
	public int emptySeate() {
		int count = 0;
		for(int i = 0; i < Room.length;i++) {
			for(int j = 0; j < Room[i].length; j++) {
				if(Room[i][j] == 0) {
					count++;
				}
			}
		}
		return count;
	}
	
	public int[][] getRoom() {
		return Room;
	}
}