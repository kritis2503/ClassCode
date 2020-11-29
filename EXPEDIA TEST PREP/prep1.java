import java.util.*;
public class prep1{
    public static void runencoding(String str)
    {
        int count=1;
        int i=0;
       for( i=0;i<str.length();i++)
        {
            count=1;
            char ch=str.charAt(i);
            while(i+1<str.length() && str.charAt(i)==str.charAt(i+1)){
                i++;
                count++;}
            System.out.print(ch);
            System.out.print(count);
        }
    }
    public static String changeformat(String str)
    {
        String ans=str.substring(0, 2);
        ans=ans.concat("-");
        //str+="-";
        str=str.substring(5);
        System.out.println(str);
        String month=str.substring(0, 3);
        System.out.println(month);
        String [] monthsall = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
            if(month.equals(monthsall[0]))   ans+="1-";
        else if(month.equals(monthsall[1]))   ans+="2-";
        else if(month.equals(monthsall[2]))   ans+="3-";
        else if(month.equals(monthsall[3]))   ans+="4-";
        else if(month.equals(monthsall[4]))   ans+="5-";
        else if(month.equals(monthsall[5]))   ans+="6-";
        else if(month.equals(monthsall[6]))   ans+="7-"; 
        else if(month.equals(monthsall[7]))   ans+="8-";
        else if(month.equals(monthsall[8]))   ans+="9-";
        else if(month.equals(monthsall[9]))   ans+="10-";
        else if(month.equals(monthsall[10]))   ans+="11-";
        else   ans+="12-";
         str=str.substring(4);
        System.out.println(str);
        ans+=str;
        return ans;
    }
    public static List<Integer> prime(int n)
    {
        List<Integer>al=new ArrayList<>();
        for(int i=2;i<n;i++)
        {
            if(isprime(i))
                al.add(i);
        }
       return al;
    }
    public static boolean isprime(int n)
    {
        if(n<=3) return true;
        if(n%2==0 ||n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=2)
        {
            if(n%i==0)
                return false;
        }
        return true;       
    }
    public static String interleave(String str1, String str2)
    {
        String ans="";
        int i=0, j=0;
        while(i<str1.length() && j<str2.length())
        {
            char ch=str1.charAt(i);
            ans+=(ch+"");
            i++;
            ch=str2.charAt(j);
            ans+=(ch+"");
            //ans.concat(ch+"");
            j++;
        }
        if(i!=str1.length())
        {
            str1=str1.substring(i);
            // ans.concat(str1);
            ans+=str1;
        }
        if(j!=str2.length())
        {
            str2=str2.substring(j);
            // ans.concat(str2);
            ans+=str2;
        }
        return ans;
    }
    public static boolean isBalanced(String str)
    {
        Stack <Character>st=new Stack<>();
        for(int i=0;i<str.length();i++)             //{([])}
        {
            char ch=str.charAt(i);
            if(ch=='('||ch=='['||ch=='{')
                st.push(ch);
            else
            if(ch==')'||ch==']'||ch=='}')
            {
                char  ch1=st.peek();
                if(ch1=='(' && ch==')')
                    st.pop();
                else if(ch1=='[' && ch==']')
                    st.pop();
                else if(ch1=='{' && ch=='}')
                    st.pop();
                else return false;
            }
        }
        if(st.size()!=0)
            return false;
        return true;
    }
    
    public static boolean isReachable(int sr,int sc,int dr,int dc)
    {
        if(sr>dr||sc>dc)
            return false;
        if(sr==dr && sc==dc)
            return true;
        return (isReachable(sr+sc, sc, dr, dc) || isReachable(sr, sc+sr, dr, dc));
    } 
    public static String Findsubstring(String str)
    {
        String[]s=new String[str.length()];
        int []count=new int [26];
        for(int i=0;i<str.length();i++)
        {
            int dis_count=0;
            Arrays.fill(count,0);
            String a=new String();
            int j=0;
            for( j=i;j<str.length();j++)
            {
               
                if(count[str.charAt(i)-'a']==0)
                 {   dis_count++;
                   
                 }
                 count[str.charAt(j)-'a']++;
                
                 if(dis_count==2)
                  { 
                        break;
                  }
            }
            s[i]=str.substring(i, j);
        }
        int max=0;
        String ans=new String();
        //for(int i=0;i<str.length();i++)
        //System.out.println(s[i]);
        for(int i=0;i<str.length();i++)
        {
            if(s[i].length()>max)
            {
                max=s[i].length();
                ans=s[i];
            }
        }
        return ans;
    }
    public static String[] DeviceName(String []devices)
    {
        HashMap<String, Integer>map=new HashMap<>();
        String[] ans=new String[devices.length];
        int i=0;
        for(String str:devices)
        {
            if(!map.containsKey(str))
              {  map.put(str, 0);}
            else{
                int f=map.get(str);
                f++;
                map.put(str,f);
                str+=(f+"");
            }
            ans[i]=str;
            i++;
        }
        return ans;
        }

    
    public static void main(String[] args) {
        //runencoding("wwwwaaadexxxxxxywww");
        //System.out.println( changeformat("25th Mar 1999"));
        //System.out.println(prime(132));
        //System.out.println(interleave("ace", "bdf"));
        //System.out.println(isBalanced("{([])}"));
        //System.out.println(isReachable(2,10,26,12));
        //System.out.println(Findsubstring("qwertyytrewq"));
        String []i={"switch","tv","switch","tv","switch","switch","tc"};
        String []ans=DeviceName(i);
        for(String str:ans)
            System.out.println(str);
    }
}