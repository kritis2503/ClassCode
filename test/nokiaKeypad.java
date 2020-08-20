import java.util.Scanner;
import java.util.ArrayList;
public class nokiaKeypad
{
    Scanner scn=new Scanner(System.in);

    public static String[] words={":;/", "abc", "def", "ghi", "jkl", "mno",
    "pqrs", "tuv", "wxyz", "&*%", "#@$"};

    public static ArrayList<String> nokiaKeypad_01(String str)
    {
        if(str.length()==0)
        {
            ArrayList <String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        char ch=str.charAt(0);
        String nstr=str.substring(1);
        ArrayList<String> rr= nokiaKeypad_01(nstr);
        ArrayList<String> mr=new ArrayList<>();
        System.out.println(ch);
        System.out.println(rr);
        String word=words[ch-'0'];

        for(String s:rr)
        {
            for(int i=0;i<word.length();i++)
                mr.add(s+word.charAt(i));
        }
        return mr;
    }
    public static int nokiaKeyPad_02(String str,String ans){
        if(str.length()==0) {
            System.out.print(ans+"  ");
            return 1;
        }

        char ch=str.charAt(0);
        String nstr=str.substring(1);
        String word=words[ch-'0'];
        int count=0;
        System.out.println(ans+"-----");

        for(int i=0;i<word.length();i++){
            count+=nokiaKeyPad_02(nstr,ans+word.charAt(i));
        }

        if(str.length() > 1){
            char ch2=str.charAt(1);
            int num = (ch-'0')*10 + (ch2-'0');
            if(num >= 10 && num <= 11){
                word=words[num];
                for(int i=0;i<word.length();i++){
                    count+=nokiaKeyPad_02(str.substring(2),ans + word.charAt(i));
                }
            }
        }
        System.out.println();
        return count;
    }
    public static int Encoding(String str,String ans){
        if(str.length()==0) {
            System.out.print(ans+"  ");
            return 1;
        }

        char ch=str.charAt(0);
        String nstr=str.substring(1);
        
        int count=0;
        //System.out.println(ans+"-----");

      
          count+=Encoding(nstr,ans+((char)('a'+(ch-'0'))));
        

        if(str.length() > 1){
            char ch2=str.charAt(1);
            int num = (ch-'0')*10 + (ch2-'0');
            if(num >= 10 && num <= 26){
               
                
                    count+=Encoding(str.substring(2),ans +((char)('a'+(num-'0'))));
                
            }
        }
        System.out.println();
        return count;
    }
    
    

     public static void main(String[] args) {
        //System.out.println(nokiaKeyPad_02("102",""));
        System.out.println(Encoding("102",""));
    }
}
