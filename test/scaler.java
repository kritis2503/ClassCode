package test;

public class scaler {
    public static int pencil(String str,int l,int r)
    {
        String s=str.substring(l-1, r);
        int si=-1,ei=-1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='1')
            {
                si=i;
                break;
            }
        }
        for(int i=s.length()-1;i>=0;i--)
        {
            char ch=s.charAt(i);
            if(ch=='1')
            {
                ei=i;
                break;
            }
        }
        int ctr=0;
        for(int i=si;i<=ei;i++)
        {
            char ch=s.charAt(i);
            if(ch=='0')
                ctr++;
        }
        return ctr;
    }
}