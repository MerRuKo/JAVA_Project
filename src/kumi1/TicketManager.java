package kumi1;

import java.util.Calendar;

@SuppressWarnings("static-access")
public class TicketManager {
	
	private Calendar cal = Calendar.getInstance();
	 
	//현재  월, 일
	private int year = cal.get ( cal.YEAR );
	private int month = cal.get ( cal.MONTH ) + 1 ;
	private int date = cal.get ( cal.DATE ) ;
	//현재 (시,분,초)
	private int hour = cal.get ( cal.HOUR_OF_DAY ) ;
	private int min = cal.get ( cal.MINUTE );
//	private int sec = cal.get ( cal.SECOND );

	private String gustName;	//예약자 이름
	private String gustPhone;	//예약자 폰번호
	private String movieNme;	//영화이름
	private String movieTime;	//상영시간
	private String payment;		//결제수단,가격
	private String seatNumber;	//좌석번호
	
	private String ticketNumber = "";
	//예매번호 = 시간+가격+상영시간+팔린순번 +전화번호 등등ex(85145013401)   (8)(5)(14)(50)(1340)  (1)
	//							     		                                          월    일   시간   분   번호뒷자리  상영시간
	
//	영화제목 시간등 위에있는 데이터는 String으로된 실제 값이고 
//	아래 값은 사용자가 목록에서 고른 목록번호 숫자이다
//	예약 취소를 하기위해서 필요함
	private int movieNameSelect;
	private int timeChoice;
	private int seat;
	private int seat1;
	private int seat2 = -1;
	
//	String[] info = new String[8];
	
	//이름,영화,시간,좌석,예매번호,결제시각
	public TicketManager(String gustName, String gustPhone, String movieNme, String movieTime, int Price, String seatNumber) {
		this.gustName = gustName;
		this.gustPhone = gustPhone;
		this.movieNme = movieNme;
		this.movieTime = movieTime;
		this.payment = String.valueOf(Price);
		this.seatNumber =seatNumber;
		
		ticketNumber = 	String.valueOf(month)+String.valueOf(date)+String.valueOf(hour)+
				String.valueOf(min)+ this.gustPhone.substring(7, 11);
	}

	public void setData(int movieNameSelect, int timeChoice, int seat, int seat1) {
		this.movieNameSelect = movieNameSelect;
		this.timeChoice = timeChoice;
		this.seat = seat;
		this.seat1 = seat1;
	}
	public void setData(int movieNameSelect, int timeChoice, int seat, int seat1, int seat2) {
		this.movieNameSelect = movieNameSelect;
		this.timeChoice = timeChoice;
		this.seat = seat;
		this.seat1 = seat1;
		this.seat2 = seat2;
	}
	
	public String[] getAllInfo() {
		String[] info = {"이름 : "+gustName, "핸드폰번호 : "+gustPhone, "영화제목 : "+movieNme, "상영시간 : "+movieTime,
				"좌석번호 : "+seatNumber, "예매날짜 : "+year+"."+month+"."+date+"  "+hour+"시 "+min+"분", "결제가격 : "+ payment + "원", "예매번호 : "+ticketNumber};
		return info;
	}
	
	public String getGustPhone() {
		return gustPhone;
	}

	public String getGustName() {
		return gustName;
	}

	public int getMovieNameSelect() {
		return movieNameSelect;
	}

	public int getTimeChoice() {
		return timeChoice;
	}

	public int getSeat() {
		return seat;
	}

	public int getSeat1() {
		return seat1;
	}

	public int getSeat2() {
		return seat2;
	}
	

}