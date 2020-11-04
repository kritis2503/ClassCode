import java.util.*;

public class codefile-1{

    public static void printleaders(int []arr)
    {
        int size=arr.length;
        int max_from_right =  arr[size-1]; 
   
        /* Rightmost element is always leader */
        System.out.print(max_from_right + " "); 
       
        for (int i = size-2; i >= 0; i--) 
        { 
            if (max_from_right <= arr[i]) 
            {            
            max_from_right = arr[i]; 
            System.out.print(max_from_right + " "); 
            } 
        }   
    }
   
   
   
   
   
   

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
    public static void main(String[] args) {
        // int arr[] = new int[]{16, 17, 4, 3, 5, 2}; 
        // printleaders(arr);
       
       
       
       
    }
} 