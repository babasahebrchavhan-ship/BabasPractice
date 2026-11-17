package ProgramPractice.String;

import java.util.*;

public class rmvDupChar {
    public static void main(String[] args){
        String str="Babasaheb";
        Set<Character> set=new HashSet<>();
        StringBuffer sf=new StringBuffer();
        for(int i=0;i<str.length();i++){
            Character c=str.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                sf.append(c);
            }
        }
        String dup=sf.toString();
        System.out.println("String after removing duplicate characters: "+dup);
    }
}
