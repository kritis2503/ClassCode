import java.util.*;
public class treeone {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=0;
    public static Node constructTree(int []arr){
        if(idx==arr.length || arr[idx]==-1)
         {
            idx++; 
            return null;
         }
        Node node=new Node(arr[idx++]);
        node.left=constructTree(arr);
        node.right=constructTree(arr);
        return node;
    }
    public static void display(Node root) {
        if(root==null)
            return;
        String str="";
        str+=(root.left!=null?root.left.data :".");
        str+=("->"+root.data+"<-");
        str+=(root.right!=null?root.right.data:".");
        System.out.println(str);
        display(root.left);
        display(root.right);
        return;
    }
    public static void solve(){
        int []arr={10,20,30,40,-1,-1,50,-1,-1,60,70,-1,80,-1,-1,-1,90,100,-1,120,-1,-1,110,130,-1,-1,-1};
        Node root=constructTree(arr);
    }
    public static void main(String[] args) {
        solve();
    }
    
}
