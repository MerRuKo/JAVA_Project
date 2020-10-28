package kumi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {
	
    public static void run() throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    
    String yn,search,again,choice;
    int to=0,y=1,z=0,end=0;//r=1;
    int available[] = new int[10];
    int ticketI[][] = new int [100][5];
    String ticketS[][] = new String[100][5];
    double ticketD[][] = new double [100][5];
    double pay[] = new double[20];
    double change[] = new double[20];
   
    	//좌석 32
    	for(int o=1; o<=5; o++){
    		available[o]=32;
  		}
    	
    	
    		for(int x=1; x==1;){
    			//메인메뉴
    			System.out.println("*******************************************");
    			System.out.println("*******       (1) 터미널 조회                *******");
    			System.out.println("*******       (2) 예매하기                    *******");
    			//System.out.println("*****    3) 결제         *****");
    			System.out.println("*******       (3) 좌석 선택하기                    *******");
    			System.out.println("*******************************************");
    			System.out.println("*********3번은 2번 진행 후에 진행해 주십시오.*********");
    			System.out.println("*******************************************");
    	
    			for(x=1; x==1;){
					System.out.print("원하는 서비스를 선택하시오(번호): ");
					choice=in.readLine();
					
					//1번 선택시 목적지 조회창으로 이동
					if (choice.equals("1")){
						System.out.println();
    					System.out.println("***************************************");
    					System.out.println("**      목적지               |     요금       |  좌석  **");
    					System.out.println("***************************************");
    					System.out.println("** [1] 동서울버스터미널    | 20,000원      |  "+available[1]+"   **");
    					System.out.println("** [2] 강남버스터미널       | 15,000원      |  "+available[2]+"   **");    					
						System.out.println("***************************************\n");
    					x=0;
					}
					
					//2번 선택시 티켓 예매창으로 이동
					else if (choice.equals("2")){
						int print=1;
						
						System.out.println();
						System.out.println("***************************************");
    					System.out.println("**      목적지               |     요금       |  좌석  **");
    					System.out.println("***************************************");
    					System.out.println("** [1] 동수원버스터미널    | 20,000원      |  "+available[1]+"   **");
    					System.out.println("** [2] 강남버스터미널       | 15,000원      |  "+available[2]+"   **");    					
						System.out.println("***************************************\n");
						//System.out.println("***************************************\n");
    					x=0;
    					
    					if((available[1]==0)&&(available[2]==0)){
    						System.out.println("남은 좌석이 없습니다.");
    						x=0;
    						
    					}
    						
    					
    					//승객정보 입력창
    					else{
    					
    					for(x=1; x==1;){
    						System.out.print("예약자 성명을 다시 한번 입력해주세요 : ");
    						ticketS[z][0] = in.readLine();
							
							x=0;
							
    					}
    					
    					//목적지 선택창
    					for(x=1; x==1;){
    						System.out.print("목적지를 선택하시오 [1~2]: ");
    						to = Integer.parseInt(in.readLine());
    						
    						//1~2으로 제한. 
    						if(to<1 || to>2){
    							System.out.println("입력한 목적지가 없습니다.");
    							x=1;
    						}
    						//available seat = 0 일때 안내창 
    						for(int d=1; d<=5; d++){
    							if(to==d){
    								if(available[to]==0){
    									System.out.println("잔여좌석이 없습니다.");
    									x=1;
    								}
    								x=0;
    							}
    						}
    					}   				
    					
    					
    					//정수 문자열로 변환
    					String dest[] = {"", "동서울버스터미널", "강남버스터미널"};
    					double fare[] = {0, 20000, 15000};
    		
    					//정수형 문자열로 변환 후 저장할 배열 생성
    					ticketS[z][1] = dest[to];
    					ticketD[z][0] = fare[to];
    					
    					//승객수 입력하기
    					for(x=1; x==1;){
    					System.out.print("승객수를 입력하시오: ");
    					ticketI[z][0] = Integer.parseInt(in.readLine());
    		
    						//입력된 숫자만큼 좌석에서 빼서 저장
    						for(int p=1; p<=5; p++){
    							if(to==p){
    								print=1;
    								available[to] = available[to]-ticketI[z][0];
    						
    								//좌석이 0개일 때
    								if(available[to]<0){
    									
    									available[to] = available[to]+ticketI[z][0];
    									System.out.print("남은좌석은 " +available[to] +" 개 입니다.\n");
    									x=1;
    									print=0;
    								}
    								else{
    									x=0;
    									
    								}
    							}
    						}	
    					}
    						
    					//예매 승객 상세
    					if(print==1){
    						System.out.println("\n***************************************");
    						System.out.println("**        예매상세      **");
    						System.out.println("***************************************");
    						System.out.println("승객명 :" + ticketS[z][0]);
    						Payment.name = ticketS[z][0];
    						System.out.println("목적지 :" + ticketS[z][1]);
    						//System.out.println("버스요금(개인) :" + ticketD[z][0]);
    						System.out.println("승객수 :" + ticketI[z][0]);
    						System.out.println("총 버스요금 :" + ticketD[z][0]*ticketI[z][0]);
    						Payment.pay = (int) (ticketD[z][0]*ticketI[z][0]);
    						Payment.number++;
    						System.out.println("***************************************");
    						System.out.println("***************************************\n");
    						ticketS[z][2]="0";
    			
    						x=0;
    					}
    					z++;
    					}
					}
					/*
						else if (choice.equals("3")){
					          
				            
							for(x=1; x==1;){
									
									System.out.print("예약자 성명을 입력하시오: ");
									search = in.readLine();
									
									
									int s=1;
									for(int b=0;b<z;b++){
										if(search.equalsIgnoreCase(ticketS[b][0])){
											System.out.println("***************************************");
		    								System.out.println("**        예매상세        **");
		    								System.out.println("***************************************");
		    								System.out.println("승객수 : " + ticketS[b][0]);
		    								System.out.println("목적지 : " + ticketS[b][1]);
		    								System.out.println("버스요금(개인) :" + ticketD[b][0]);
		    								System.out.println("승객수 : " + ticketI[b][0]);
			 		   						System.out.println("***************************************");
		    								System.out.println("***************************************");
		    								s=0;
											x=0;
											
											if(ticketS[b][2].equals("x")){
		    									System.out.println("이미 결제가 되었습니다.");
		    									x=0;
		    								}
		    								else{
		    									ticketS[b][2]="x";
		    									
		    								
		    									for(x=1; x==1;){
		    										System.out.println("\n 최종결제금액: "+ticketD[b][2]);
		    										System.out.print("결제할 금액을 입력하시오: ");
		    										pay[b] = Double.parseDouble(in.readLine());
		    										change[b]=pay[b]-ticketD[b][2];
		    							
		    										if(change[b]<0){
		    											System.out.println("다시 입력하시오");
		    											x=1;
		    										}
		    										else{
		    											System.out.println("거스름돈 : "+change[b]);
		    											System.out.println("");
		    											x=0;
		    										}
		    									}
											}
										}
									}
									if (s==1){
										System.out.println("\n조회된 예매내역이 없습니다.\n");
										for(int q=1; q==1;){
										
										System.out.print("거래를 계속 하시겠습니까? [Y/N]: ");
										again=in.readLine();
										
										if(again.equalsIgnoreCase("y")){
											q=0;
										}
										else if (again.equalsIgnoreCase("n")){
											q=0;
											x=0;
											
										}
										else{
											System.out.println("\n다시 입력하시오\n");
										}															
									}
								}	
							}				        
						}
					*/
					else if(choice.equals("3")){
						end=1;
						x=0;
						//System.out.println("감사합니다.");
					}
					else{
						System.out.println("다시입력하시오.");
						x=1;
					}
    			}
    	
    			for(y=1; y==1;){
    				if(end==1){
    					break;
    				}
    				System.out.print("다른 서비스를 이용하시겠습니까? [Y/N]: ");
   				 	yn = in.readLine();
    	
    				if (yn.equalsIgnoreCase("y")){
    					x=1;
    					y=0;
    				}
    				else if (yn.equalsIgnoreCase("n")){
    					System.out.println("\n감사합니다!");
    					break;
    				}
    				else{
    					System.out.println("다시입력하시오.");
    					y=1;
    				}
    			}
    		}    
    	}  
    
}