package ProgramPractice.String;
import java.util.*;
public class occurrenceOfCharacter{

    public static void main(String[] args){
        String str="Babasaheb";
        TreeMap<Character,Integer> map=new TreeMap<Character,Integer>();
        for(int i=0;i<str.length();i++){
            Integer c=map.get(str.charAt(i));
            if(map.get(str.charAt(i))==null){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i),++c);
            }
        }
        for(Map.Entry entry:map.entrySet()){
            System.out.println("character: "+entry.getKey()+" Occurrence: "+entry.getValue());
        }
    }
}