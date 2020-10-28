package kumi2;

public class Info {
	private String name;
	private String phoneNumber;
	private String time;
	private String date;
	//private int usingNum; //사용횟수
	
	public Info (){}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String showNumber() {
		return phoneNumber;
	}
	public String showName() {
		return name;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public String getDate() {
		return date;
	}
	/*
	public void setNum() {
		usingNum++;
	}
	public int getPoint() {
		return usingNum*1000;
	}*/
}