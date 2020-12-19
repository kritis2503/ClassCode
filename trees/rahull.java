import java.util.*;
public class rahull {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
       
    int c=0,count=0;
            int start=0;
            boolean flag=false;
            HashMap<String,Integer>map=new HashMap<>();
        for(int i=1;i<str.length()-1;i++)
        {char ch=str.charAt(i);
            char ch1=str.charAt(i-1);
            char ch2=str.charAt(i+1);
            if(Character.isDigit(ch)&& c==0 && ch1=='-')
           { flag=true;
            start=i;
           }
            if(Character.isDigit(ch))
               c++;
            else c=0;
            if(Character.isDigit(ch2))
               flag=false;
                
            if(c==4 && flag )
            {
                String st=str.substring(start,i+1);
               map.putIfAbsent(st,1);
            flag=false;
            }
        }
        System.out.println(map.size());
    }
}
