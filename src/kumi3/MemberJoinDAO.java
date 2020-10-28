package kumi3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
 
 
class MemberDTO {
    private String ID;
    private String PW;
    private String Name;
    private int calro;
    private static MemberDTO cSession=null;
    private int cm;
    private double kg;
    private double bmi;

	public MemberDTO(String iD, String pW, String name,int calro,int cm,double kg) { //회원가입시 호출하는 생성자
        ID = iD;
        PW = pW;
        Name = name;
        this.calro = calro;
        this.kg = kg;
        this.cm = cm;
        this.bmi = Math.round(((Double)kg/Math.pow(cm, 2))*1000000.0)/100.0;
    }
	public MemberDTO(String[] member,int calro) { //파일에서 읽어들이는 생성자
		if (member.length>=5) {
			ID = member[0];
			PW = member[1];//new MD5(member[1]).hexdigest();
			Name = member[2];
			this.calro = Integer.parseInt(member[3]);
			this.cm= Integer.parseInt(member[4]);
			this.kg= Double.parseDouble(member[5]);
			this.bmi=Math.round(((Double)kg/Math.pow(cm, 2))*1000000.0)/100.0;
		}
	}
	public int getCal() {
		return calro;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getID() {
        return ID;
    }
    public String getPW() {
        return PW;
    }
    public int getCm() {
		return cm;
	}
	public void setCm(int cm) {
		this.cm = cm;
	}
	public double getKg() {
		return kg;
	}
	/*public double getrKg() {
		return Math.round(20.75*(cm*cm/10000)*100)/100.0;
	}*/
	public void setKg(double t) {
		this.kg = t;
	}
	public String getName() {
        return Name;
    }
	
    public void setID(String iD) {
        ID = iD;
    }
    public void setPW(String pW) {
        PW = pW;
    }
    public void setName(String name) {
        Name = name;
    }
    public int setCal(int calro) {
		return this.calro = calro;
	}
    @Override
    public String toString() {
        return "ID: " + ID + "\tPW: " + PW + "\tName: " + Name + "\tcalro: "
    +calro+ "\tCM: "+cm+"\tKG: "+kg+"\tBMI: "+bmi ;
    }
	public static MemberDTO getSession() {
		return cSession;
	}
	public static void setSession(MemberDTO member) {
		MemberDTO.cSession = member;
	}

}

 

public class MemberJoinDAO extends Syokuji{
 
    Scanner sc = new Scanner(System.in);
    List<MemberDTO> members = new ArrayList<>();
    
    /*public MemberJoinDAO() { //비어 있을경우 기본호출생성자
        members.add(new MemberDTO("rjsxo9885", new MD5("sonysega25").hexdigest(), "방건태",1));
        members.add(new MemberDTO("sonysega25",new MD5("1234").hexdigest(), "김대호",1));
        members.add(new MemberDTO("Pororo", new MD5("1234").hexdigest(), "이수경",1));
        save_db("member.txt"); //초기파일생성
    }*/
    public MemberJoinDAO(String filename) {
    	load_db(filename);
    }
    public void load_db(String filename) 
    {
		Scanner sf = null;
    	try {
    		File fd = new File(filename);
    		if(fd.exists()) {
    			sf = new Scanner(fd);
    			while(sf.hasNextLine()) {
    				members.add(new MemberDTO(sf.nextLine().split(","),1));
    			}
    		} else {
    			System.out.print("[-] debug : "+filename+" 파일이 비어있습니다. 샘플정보를 입력하시겠습니까? ");
	    		if (getNumInput("[1]예 [2]아니오")!=1) return;
	    		fd.createNewFile();
	    		members.add(new MemberDTO("rjsxo9885", new MD5("sonysega25").hexdigest(), "방건태",1,170,78));
	            members.add(new MemberDTO("sonysega25",new MD5("1234").hexdigest(), "김대호",1,180,61));
	            members.add(new MemberDTO("Pororo", new MD5("1234").hexdigest(), "이수경",1,168,51));
	            save_db("member.txt");
    		}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sf!= null) sf.close();
		}
    }
    public void save_db(String filename) {
    	try {
	    	File fd = new File(filename);
	    	if(!fd.exists()) {
	    		fd.createNewFile();
	    	}
    		PrintWriter pw = new PrintWriter(filename);
    		Iterator<MemberDTO> ite = members.iterator();
            while(ite.hasNext()) {
            	MemberDTO member = ite.next();
                pw.println(member.getID()+","+member.getPW()+","+member.getName()
                +","+member.getCal()+","+member.getCm()+","+member.getKg());
            } pw.close();
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
    public boolean isLogin() {
    	if (MemberDTO.getSession()!=null)
    		return true;
    	System.out.println("로그인해주세요.");
    	return false;
    }
    public void run() {
        int key = 0;
        while ((key = menu()) != 0) {
            switch (key) {
                case 1:
                    Login();
                    break;
                case 2:
                    MemberJoin();
                    break;
                case 3:
                    SelectMember(); break;
                case 4:
                	if(isLogin())MemberDTO.getSession().setCal(kaisu()); break;
                case 5:
                	if(isLogin())MemberDTO.getSession().setCal(kaisu2()); break;
                case 6:
                	if(isLogin())getSum(); break;
            }
        } save_db("member.txt");
    }
    private void SelectMember() {
        Iterator<MemberDTO> ite = members.iterator();
        while(ite.hasNext()) {
            System.out.println(ite.next()); //toString이 Override된 메소드에서 출력한다.
        }
        
    }
 
    private void MemberJoin() {
        sc.nextLine();
        String id,pw,pw2 = null, name;
        int cm; double kg;
        while (idCheck(id=getStrInput("               ID : ")));
        do {
        	if (pw2 != null)
        		System.out.println("비밀번호를 확인해주세요.");
        	pw = getPwdInput("         PassWord : ");
        	pw2 = getPwdInput("Password Confirm : ");
        } while (!pw.equals(pw2) || pw.length()<1);
        cm = getNumInput("키를 입력하시오 :");
    	kg = getNumInput("몸무게를 입력하시오 :");
        while((name = getStrInput("           Name : ")).isEmpty())
        	System.out.println("올바른 이름을 입력해주세요.");
        System.out.println(id + "님 가입을 축하드립니다.");
        members.add(new MemberDTO(id, new MD5(pw).hexdigest(), name,1,cm,kg)); 
    }
 
    public boolean idCheck(String id) {
    	boolean result=false;
        if (id.isEmpty()) {
        	System.out.println("올바른 ID를 입력해주세요.");
        	result = true;
        } else {
        	MemberDTO member = FindById(id);
	        if(member != null) {
	        	result = true;
	        	System.out.println("중복된 ID입니다.");
	        }
        }
        return result;
    }
 
    private void Login() {
        sc.nextLine();
        String id = getStrInput("      ID : ");
        String pw = new MD5(getPwdInput("PassWord : ")).hexdigest();
        
        MemberDTO member = FindById(id);
        //System.out.println(pw);
        if(member == null){
            System.out.println("등록되지 않은 ID입니다.");
        } else if(member.getPW().equals(pw) ){
            System.out.println("[" + member.getID() + "]님께서 로그인 하셨습니다.");
            MemberDTO.setSession(member);
        } else {
    	   System.out.println("비밀번호가 틀렸습니다");
        }
    }
    private MemberDTO FindById(String id) {
        for(MemberDTO memberDTO : members) {
            if(memberDTO.getID().equals(id)) {
                return memberDTO;
            }
        }
        return null;
    }
    private String getStrInput(String msg) {
        System.out.print(msg);
        return sc.next().trim();
    }
	private String getPwdInput(String msg) {
		String pwd;
		if( System.console() != null )
			pwd=new String(System.console().readPassword(msg));
		else
			pwd=getStrInput(msg);
        return pwd;
    }
 
    private int menu() {
        System.out.println("\nWelcome 운동관리 프로그램에");
        return getNumInput("[1]로그인 [2]회원가입 [3]전체 회원 보기 [4]식단입력 [5]운동 입력 [6]값연동  [0]종료");
    }
 
    private int getNumInput(String msg) {
        System.out.println(msg);
        return sc.nextInt();
    }
    
    public void getSum() {
    	
    	/*System.out.print("id를 입력하시오");
    	String id = sc.nextLine();
    	
    	for(int i=0;i<members.size();i++){
		     if(members.get(i).getID().equals(id)){	    	 
			       members.get(i).setCal(sum);
			       System.out.println(sum);
		     } else {
		    	 System.out.println("잘못 입력하였습니다.");
		    	 getSum();
		     }
    	}*/
    	double henkan=sum/1000.0;
  	    double kg = MemberDTO.getSession().getKg();
   	    int cm = MemberDTO.getSession().getCm();
      	
    	MemberDTO.getSession().setCal(0);
    	System.out.println(sum);
    	//Math.round(weight/(height*height/10000)*100)/100.0;
    	//henkan = MemberDTO.getSession().getCal()/1000.0;  
    	double t= MemberDTO.getSession().getKg()+henkan;
    	double bmi = Math.round((t/Math.pow(cm, 2))*1000000.0)/100.0;
    	MemberDTO.getSession().setKg(t);
    	 
    	 
    	/** bmi median = 20.75
 		* 18.5 >= 정상체중
 		* 23.0 >= 과체중
 		* 25.0 >= 비만
 		* 30.0 >= 고도비만 **/
    	System.out.println(cm);
    	System.out.println(kg+"->"+t);
    	System.out.println(MemberDTO.getSession().getBmi()+"->"+bmi);
    	MemberDTO.getSession().setBmi(bmi);
    	System.out.println("당신은 "+(bmi<18.5?"저체중":bmi<23?"정상체중":bmi<25?"과체중":bmi<30?"비만":"고도비만")+"입니다.");
    	if(bmi<18.5 || bmi>=23)
    		System.out.println("당신의 권장 체중은 "+Math.round(18.5*(cm*cm/10000)*100)/100.0+"~"+Math.round(22.99*(cm*cm/10000)*100)/100.0+"kg 입니다.");
    	sum=0;
    }
    	
    /*public void getBmi() {
    		
   		System.out.println("아이디를 입력하시오");
   		String id = sc.next();
   		for(int i=0;i<members.size();i++){
   		if(members.get(i).getID().equals(id)){	   
   			System.out.println(members.get(i).getID());
	    	int henkan = members.get(i).getCal()/1000;  
	    	double t= members.get(i).getKg()+henkan;
	    	members.get(i).setKg(t);
			System.out.println(henkan);
	    }
	    }
   	
   }*/
}