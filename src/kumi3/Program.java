package kumi3;

public class Program {
    public static void main(String[] args) {    	
    	MemberJoinDAO memberJoinDAO = new MemberJoinDAO("member.txt");
        memberJoinDAO.run();
    }
}