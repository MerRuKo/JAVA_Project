package kumi3;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public String message;
	public MD5(String message) {
		this.message=message;
	}
	public String hexdigest() {
		String hd;
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(this.message.getBytes());
			BigInteger hash = new BigInteger(1,md5.digest());
			hd = hash.toString(16); //앞자리가 0으로 시작될경우 Biginteger는 이걸 날리기때문에
			while ( hd.length()<32 ) hd = "0"+hd; //반복문으로 32글자가 될때까지 padding시킨다.
			return hd;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return null; //에러 발생시 null값리턴
	}
}
/*class Person {
	String name;
	double weight, height;
	double bmi;
	double e_weight; //expected_weight
	Person (String name, double height, double weight){
		this.name=name; this.height=height; this.weight=weight;
		bmi=Math.round(weight/(height*height/10000)*100)/100.0;
		e_weight=Math.round(20.75*(height*height/10000)*100)/100.0;*/
		/** bmi median = 20.75
		 * 18.5 >= 정상체중
		 * 23.0 >= 과체중
		 * 25.0 >= 비만
		 * 30.0 >= 고도비만
		 */
/*	}
	
	public void getbmi() {
		System.out.println("당신은 "+(bmi<18.5?"저체중":bmi<23?"정상체중":bmi<25?"과체중":bmi<30?"비만":"고도비만")+"입니다.");
	}
	//weight/(height*height/10000)=20.75
	public static void main(String[] args) {
		Person p = new Person("성오현",170,60);
		
		p.getbmi();
		System.out.println("당신의 감량 목표는 "+Math.round((p.weight-p.e_weight)*100)/100.0+"kg 입니다.");
		
	}
}
class Checker {
    //number of chars : the Higher the Better("password must be greater than 8 chars"){done}
    //combination of uppercase and lowercase{done}
    //contains numbers{done}
    //non repeated characters (every char is different ascii char){done}
    //is not a consecutive password ie 123456789 or 987654321{done}
    //is not blank ("[space]"){done} 
    int pLength;
    final int MAX_STRENGTH = 10;
    int pStrength = 0;
    String pass;
    public Checker(String pwd){
        pass = pwd;
        pLength = pwd.length();
    }
    public void checkSecurity(){
        if(pass.isEmpty()){
            System.out.println("Password Field is Empty! Password is Very Insecure.");
        }
        if(pLength >= 8){
            pStrength++;
            if(pLength >= 12){
                pStrength++;
                if(pLength >= 16){
                    pStrength++;
                }
            }
        }
        if(hasUpperCase(pass) && hasLowerCase(pass)){
            pStrength+=2;
        }
        if(containsNumbers(pass)){
            pStrength+=2;
        }
        if(hasNoRepeats(pass)){
            pStrength+=2;
        }
        if(!containsConsecutiveNums(pass)){
            pStrength++;
        }
        System.out.println("Your password strength is rated at " + pStrength +"/" + MAX_STRENGTH);
    }
    //Component Methods
    public boolean hasUpperCase(String str){
        for(int i = 0; i<pLength; i++){
            if(Character.isUpperCase(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean hasLowerCase(String str){
        for(int i  = 0; i<pLength; i++){
            if(Character.isUpperCase(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean containsNumbers(String str){
        for(int i = 0; i<pLength; i++){
            if(Character.isDigit(str.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public boolean hasNoRepeats(String str){
        for(int i = 0; i<pLength; i++)
            if(containsChar(str, str.charAt(i))){
                return false;
            }
        return true;
    }
    public boolean containsChar(String s, char search) {
        if (s.length() == 0)
            return false;
        else
            return s.charAt(0) == search || containsChar(s.substring(1), search);
    }
    public boolean containsConsecutiveNums(String str){
        for(int i = 0; i<pLength; i++){
            if(Character.isDigit(str.charAt(i))){
                if(str.charAt(i)-1 == str.charAt(i-1) || str.charAt(i)+1 == str.charAt(i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}*/