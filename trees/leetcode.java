//Leetcode 145
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>al=new ArrayList<>();
        pt(root,al);
        return al;
    }
    public void pt(TreeNode root,List<Integer>al){
        if(root==null)
            return;
        pt(root.left,al);
        pt(root.right,al);
        al.add(root.val);
    }
}

//LeetCode 700
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if( root==null||root.val==val)
            return root;
        if(root.val>val)
            return searchBST(root.left,val);
        if(root.val<val)
            return searchBST(root.right,val);
        return null;
    }
}

//Leetcode 589
class Solution {
    public List<Integer> preorder(Node root) {
        if(root==null)
            return new ArrayList<Integer>();
        List<Integer>ans=new ArrayList<Integer>();
        ans.add(root.val);
        List<Integer>rec=new ArrayList<>();
        
        for(Node child:root.children)
        {
            rec=preorder(child);
             for(int ele:rec)
            ans.add(ele);
        }
       
        return ans;
        
        
    }
}

//Leetcode 94
class Solution {
    public:
        vector<int> inorderTraversal(TreeNode* root) {
           vector<int>ans;
            inorderT(root,ans);
            return ans;
        }
        void inorderT(TreeNode *root,vector<int>&al)
        {
            if(root==nullptr)
                return;
            inorderT(root->left,al);
            al.push_back(root->val);
            inorderT(root->right,al);
        }
            
};

//Leetcode 144
class Solution {
    List<Integer>ans=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preorder(root);
        return ans;
        
    }
    public void preorder(TreeNode root)
    {
        if(root==null)
            return;
        ans.add(root.val);
        preorder(root.left);
        preorder(root.right);
        return;
    }
}
//Leetcode 100
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null && q==null)
            return true;
        if(q==null || p==null)
            return false;
        if(p.val!=q.val)
            return false;
        return isSameTree(p.left, q.left )&& isSameTree(p.right,q.right);
    }
}
//Leetcode 1305
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        
        getEle(root1,list1);
        getEle(root2,list2);
        // System.out.println(list1);
        // System.out.println(list2);
        
        int i=0,j=0;
        while(i<list1.size() && j<list2.size())
        {
            int a=list1.get(i);
            int b=list2.get(j);
            if(a<=b)
            {
                ans.add(a);
                i++;
            }
            else
            {
                ans.add(b);
                j++;
            }
        }
        while(i<=list1.size()-1)
        {
            //System.out.println("Kriti1");
            int a=list1.get(i);
            ans.add(a);
            i++;
        }
        while(j<=list2.size()-1)
        {
            //System.out.println("Kriti2");
            int a=list2.get(j);
            ans.add(a);
            j++;
        }
        return ans;
        
    }
    public void getEle(TreeNode root, List<Integer>ele)
    {
        if(root==null)
            return;
        getEle(root.left,ele);
        ele.add(root.val);
        getEle(root.right,ele);
        
    }
}
