package kumi2;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class DayTime {

	Scanner sc=new Scanner(System.in);

	String bday,btime;

	int days,times;
	String one,two,three,four;
	String a,b,c,d;
	public DayTime() {}

	public DayTime(String bday,String btime,int days,int times) {

		this.bday=bday;

		this.btime=btime;

		this.days=days;

		this.times=times;

	}

	public void selDate() throws UnsupportedEncodingException  {
		
		one="2020-09-01(화)";
		two="2020-09-02(수)";
		three="2020-09-03(목)";
		four="2020-09-04(금)";
		a="오전 8시 30분";
		b="오전 10시 30분";
		c="오후 2시 30분";
		d="오후 4시 40분";

		
		
			
		do{

			System.out.println();
			System.out.println("*******       탑승일 선택                *******");
	
			System.out.println("1. "+new String(one.getBytes("X-WINDOWS-949"),"KSC5601"));
		
		
		System.out.println("2. "+new String(two.getBytes("X-WINDOWS-949"),"KSC5601"));

		System.out.println("3. "+new String(three.getBytes("X-WINDOWS-949"),"KSC5601"));

		System.out.println("4, "+new String(four.getBytes("X-WINDOWS-949"),"KSC5601"));

		System.out.print("1번 부터 4번 중에서 선택해주십시오. : ");

		days=sc.nextInt();

		if(days<1||days>4) {

			System.out.println("잘못입력하였습니다.");

		}

		}while(!(days>0&&days<5));




		switch (days) {

		case 1: bday=one;break;

		case 2: bday=two;break;

		case 3: bday=three;break;

		case 4: bday=four;break;

		}

		System.out.println();
		System.out.println();


		do{

		System.out.println("*******       탑승시간 선택                *******");
		System.out.println("1. "+new String(a.getBytes("X-WINDOWS-949"),"KSC5601"));
		System.out.println("2. "+new String(b.getBytes("X-WINDOWS-949"),"KSC5601"));
		System.out.println("3. "+new String(c.getBytes("X-WINDOWS-949"),"KSC5601"));
		System.out.println("4. "+new String(d.getBytes("X-WINDOWS-949"),"KSC5601"));

		System.out.print("1번 부터 4번 중에서 선택해주십시오. : ");

		times=sc.nextInt();

		if(times<1||times>4) {

			System.out.println("잘못입력하였습니다.");

		}

		}while(!(times>0&&times<5));

		switch (times) {

		case 1: btime=a;break;

		case 2: btime=b;break;

		case 3: btime=c;break;

		case 4: btime=d;break;

		}

	}
	

	public void showre() {
		System.out.println();
		System.out.println(bday+" "+btime+" 출발 버스를 선택하였습니다.");
		System.out.println();
		}
}