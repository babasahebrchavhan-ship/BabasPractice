package ProgramPractice.String;


public class rmvDupCharWithoutSet {

    public static void main(String[] args) {
        String str="Babasaheb";
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(str.indexOf(ch)==str.lastIndexOf(ch))
            {System.out.println(ch);

            }

        }

    }

}
