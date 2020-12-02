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
