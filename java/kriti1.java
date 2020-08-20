import java.util.Scanner;
import java.util.ArrayList;

public class kriti1 {

public static void main(final String[] args) {

// write your code here.
Scanner scn=new Scanner(System.in);
  int n=scn.nextInt();
  scn.close();
  int i=1;
  int num=0;
  
  while(n>0)
  {
    int r=num%10;
    num+=i*Math.pow(10,r-1);
    i++;
    n=n/10;
  }
  System.out.println(num);

 }
}