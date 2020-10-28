package myPro2;

import java.util.ArrayList;

import java.util.Scanner;

class Member {

	private String name;
	private double cm;
	private double kg;
	private double bmi;

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public double getCm() {

		return cm;

	}

	public void setCm(double cm) {

		this.cm = cm;

	}

	public double getKg() {

		return kg;

	}

	public void setKg(double kg) {

		this.kg = kg;

	}

	public double getBmi() {

		return bmi;

	}

	public void setBmi(double bmi) {

		this.bmi = bmi;

	}

}


public class ArrayListProject {

 public static void main(String[] args) {
 
	 ArrayList<Member> mlist = new ArrayList<Member>();

	 Scanner in = new Scanner(System.in);

	 while(true){

		 System.out.print("1. 신규회원 등록  2. 회원정보 열람  3. 종료\n입력 : ");

		 int menuNum = in.nextInt();

		 if(menuNum ==1) {

			 Member mb = new Member();
			 
			 System.out.println("이름 : ");
			 mb.setName(in.next());

			 System.out.println("신장 : ");
			 mb.setCm(in.nextDouble());

			 System.out.println("몸무게 : ");
			 mb.setKg(in.nextDouble());

			 mlist.add(mb);

		  }

		 else if (menuNum ==2) {

			 System.out.println("회원 리스트 : 총 회원수("+mlist.size()+")");
			 System.out.println("========================================");
			 System.out.println("이름/ 신장/ 몸무게/ BMI");
			 System.out.println("========================================");

			 for (Member m : mlist) {

				 System.out.print(m.getName()+" ");

				 System.out.print(m.getCm()+" ");

				 System.out.print(m.getKg()+" ");

				 System.out.printf("   %.1f\n",m.getKg() / Math.pow(m.getCm()/100,m.getCm()/100));

			 }

		 }
		 
		 
		 else if (menuNum == 3) {

			 
			 System.out.println("종료");

			 break;

			 
		 } else {

			 System.out.println("다시 입력해주세요.");

		 }

	  }

 	}
 
} 