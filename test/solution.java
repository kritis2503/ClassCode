import java.util.Scanner;
import java.util.ArrayList;

public class solution{
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String s=scn.next();
        
       if(s[0].isupper() )
       {
           
       }
        String ans1=s.substring(0, 1);
        String ans2=s.substring(1);
        ans1=ans1.toUpperCase();
        ans2=ans2.toLowerCase();
        String ans=ans1+ans2;
        System.out.println(ans);
       
       
       
           
        
    }
}