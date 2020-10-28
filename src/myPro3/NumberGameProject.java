package myPro3;

import java.util.Random;
import java.util.Scanner;

class Player{
	int pcard;
	int pmoney = 500;
	
	public int shuffle(){
		Random random = new Random();
		pcard = random.nextInt(9)+1;
		
		return pcard;
	}
}
	
class Enemy{
	int ecard;
	int emoney = 500;

	public int shuffle(){
		Random random = new Random();
		ecard = random.nextInt(9)+1;
		
		return ecard;
	}
}

class Start{
	
	public void start(){
		
		boolean b = true;
		int sum = 0;
		
		Player p = new Player();
		p.shuffle();
		
		Enemy e = new Enemy();
		e.shuffle();
		
		while(b) {
			
		if (p.pmoney != 0 && e.emoney != 0 && sum < 10) {
			
		sum++;
		
		System.out.println("===========================");
		System.out.println("私の数字は " + p.pcard + "\nかけますか？ Y/N");
		Scanner in = new Scanner(System.in);
		String choice = in.next();
		
			if (choice.equals("Y") || choice.equals("y")) {
			
				if (p.pcard > e.ecard) {
					p.pmoney += 100;
					e.emoney -= 100;
					System.out.println("=========== " + sum + "回戦 ===========");
					System.out.println("私の数字は " + p.pcard);
					System.out.println("敵の数字は " + e.ecard);
					System.out.println("私の残金 : " + p.pmoney);
					System.out.println("敵の残金 : " + e.emoney);
					System.out.println("勝利！");
					p.shuffle();
					e.shuffle();
				
				} else if (p.pcard < e.ecard) {
					p.pmoney -= 100;
					e.emoney += 100;
					System.out.println("=========== " + sum + "回戦 ===========");
					System.out.println("私の数字は " + p.pcard);
					System.out.println("敵の数字は " + e.ecard);
					System.out.println("私の残金 : " + p.pmoney);
					System.out.println("敵の残金 : " + e.emoney);
					System.out.println("敗北！");
					p.shuffle();
					e.shuffle();
				
				} else {
					System.out.println("=========== " + sum + "回戦 ===========");
					System.out.println("私の数字は " + p.pcard);
					System.out.println("敵の数字は " + e.ecard);
					System.out.println("私の残金 : " + p.pmoney);
					System.out.println("敵の残金 : " + e.emoney);
					System.out.println("引き分け！");
					p.shuffle();
					e.shuffle();
				}
			
				} else if (choice.equals("N") || choice.equals("n")) {
					System.out.println("=========== " + sum + "回戦 ===========");
					System.out.println("私の数字は " + p.pcard);
					System.out.println("敵の数字は " + e.ecard);
					System.out.println("私の残金 : " + p.pmoney);
					System.out.println("敵の残金 : " + e.emoney);
					System.out.println("勝負しなかった！");
					p.shuffle();
					e.shuffle();
					continue;
			
				} else {
					sum--;
					System.out.println("=========== " + sum + "回戦 ===========");
					System.out.println("改めて入力してください。");
					continue;	
				}
		
			} else if (e.emoney==0) {
				System.out.println("\n-------------------- 結果 --------------------");
				System.out.print(sum + "回戦で破産させて、\nゲーム勝利！");
				System.out.println("\n----------------------------------------------");
				b = false;
			
			} else if (p.pmoney==0) {
				System.out.println("\n-------------------- 結果 --------------------");
				System.out.print(sum + "回戦で破産して、\nゲーム敗北！");
				System.out.println("\n----------------------------------------------");
				b = false;
			} else {
				System.out.println("\n-------------------- 結果 --------------------");
				System.out.print("10回戦まで勝負がつかなかったため、\nゲーム敗北！");
				System.out.println("\n----------------------------------------------");
				b = false;	
			}
		}
	}
}

public class NumberGameProject {

	public static void main(String[] args) {
		
		System.out.println("--------------------------------- 数字ゲーム ---------------------------------");
		System.out.println("ゲーム説明 : 1~9まで与えられた数字で勝負して、大きい方が勝つ。\n"
				+ "それぞれ500円を持って始まって、勝敗によって100円ずつ増減する。");
		System.out.println("勝利条件 : 相手を0円まで追い込んで破産させる。");
		System.out.println("敗北条件 : 10回戦まで勝負がつかなかった場合 / 自分が破産した場合");
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("");
		
		Start s = new Start();
		s.start();

	}
}