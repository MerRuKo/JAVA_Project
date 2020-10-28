package kumi3;

import java.util.*;


public class Syokuji  {
	
	int a;
	static int goukei=0;
	int food =0;
	int cal=1;
	static int syurui =0; 
	static int sum=0;
	
	int henkan=cal/1000;
	int kg=0;
	
	public void menu1() {
		System.out.println("메뉴를 입력하시오");
       System.out.println("[1]닭가슴살 [2]삶은 계란 [3]바나나 [4]토마토 [5]직접입력 [0]돌아가기");
		
	}
	
	public void menu2() {
		System.out.println("메뉴를 입력하시오");
		System.out.println("[1]스쿼트(30회 1세트) [2]레그레이즈(30회 1세트) [3]사이클  [4]플랭크 [0]돌아가기");
	}
	
	public int kaisu2() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		 while(true) {
			 menu2();
			 a = sc.nextInt();
				
		switch(a) {
			    case 1: 
				System.out.println("[1]스쿼트를 몇세트 했습니까?"); 
					food = sc.nextInt(); 
					break;
			    case 2: 
				System.out.println("[2]레그레이즈를 몇세트 했습니까?"); 
				food = sc.nextInt();break;
			    case 3: 
					System.out.println("[3]사이클을 몇분했습니까?"); 
					food = sc.nextInt();break;
				case 4: 
				System.out.println("[4]플랭크를 몇세트 했습니까?");
				food = sc.nextInt();break;
				case 0:
					return sum;
				}
		kaisu2disp();
		System.out.println("총 합계는 "+sum+"입니다");
	}
		 
}
	
	public int kaisu() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		 while(true) {
			 menu1();
			 a = sc.nextInt();
				
		switch(a) {
			    case 1: 
				System.out.println("닭가슴살을 몇개 먹었습니까 (50g기준)"); 
					food = sc.nextInt(); 
					break;
			    case 2: 
				System.out.println("삶은 계란을 몇개 먹었습니까"); 
				food = sc.nextInt();break;
			    case 3: 
					System.out.println("바나나를 몇쪽먹었습니까"); 
					food = sc.nextInt();break;
				case 4: 
				System.out.println("토마토를 몇개먹었습니까");
				food = sc.nextInt();break;
				case 5: 
					System.out.println("종류가 무엇입니까?");
					String c = sc.next(); 
					System.out.println(c+"의 칼로리는 몇입니까?");
					cal = sc.nextInt();
					System.out.println(c+"를 몇개 먹었습니까");
					 syurui = sc.nextInt(); break;
					
				case 0:
					return sum;
				}
		kaisudisp();
		System.out.println("총 합계는 "+sum+"입니다");
	}
		 
}
	
	public void kaisudisp() {
		
		if(a==1) {
			goukei=food*100;
			sum+=goukei;
			
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==2) {
			goukei =food*50;
			sum+=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==3) {
			goukei = food*70;
			sum+=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==4) {
			goukei = food*10;
			sum+=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==5) {
			goukei=cal*syurui;
			sum+=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}	
	}
public void kaisu2disp() {
		
		if(a==1) {
			goukei=food*20;
			sum-=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==2) {
			goukei =food*30;
			sum-=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}else if(a==3) {
			goukei = food*40;
			sum-=goukei;
			System.out.println(" 칼로리는 "+goukei+"입니다");
		}else if(a==4) {
			goukei = food*5;
			sum-=goukei;
			System.out.println("칼로리는 "+goukei+"입니다");
		}
	}
	
}