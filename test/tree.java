import java.util.*;
class tree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data)
        {
            this.data=data;
        }
        Node(int data,Node left,Node right)
        {
            this.data=data;
            this.left=left;
            this.right=right;
        }

    }
    public static Node construct(int[]arr,int si,int ei)
    {
        if(si>ei)
            return null;
        int mid=(si+ei)/2;
        Node node =new Node(arr[mid]);
        node.left=construct(arr, si, mid-1);
        node.right=construct(arr,mid+1,ei);
        return node;
    }
    public static boolean find(Node root,int p)
    {
        Node curr=root;
        while(curr!=null)
        {
            if(curr.data==p)
                return true;
            else
                if(curr.data>p)
                    curr=curr.left;
            if(curr.data<p)
                curr=curr.right;
        }
        return false;
    }
    public static void range(Node node,int p,int q,ArrayList<Integer>al)
    {
        if(node==null)
            return;
        range(node.left,p,q,al);
        if(p<node.data && q>node.data)
            al.add(node.data);
        range(node.right, p, q, al);
    }
    static int idx=1;
    public static Node constructTreefromPreOrder(int []arr,int leftboundary,int rightboundary)
    {
        if(arr.length==idx || leftboundary>arr[idx]|| rightboundary<arr[idx])
            return null;
        Node node=new Node(arr[idx]);
        node.left=constructTreefromPreOrder(arr, leftboundary, node.data);
        node.right=constructTreefromPreOrder(arr, node.data, rightboundary)
        return node;

    }

}