#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

class Node{
    int data;
    Node *left;
    Node *right;
    
    public Node(int data,Node *left, Node *right){
        this.data=data;
        this.left=left;
        this.rigt=right;
    }
};
int idx=0;
Node* constructTree(vector<int>&arr)
{
    if(arr[idx++]==-1 || idx>=arr.size())
    {   
       return nullptr;
    }
    Node node=new Node(arr[idx++],nullptr,nullptr);
    node->left=constructTree(arr);
    node->right=constructTree(arr);
}
void inorderTraversal(Node *node)
{
    if(node==nullptr)
        return;
    inorderTraversal(node->left);
    cout<<node->data<<" ";
    inorderTraversal(node->right);
}

void preorderTraversal(Node *node)
{
    if(node==nullptr)
        return;
    cout<<node->data<<" ";
    preorderTraversal(node->left);
    preorderTraversal(node->right);
}

void postorderTraversal(Node *node)
{
    if(node==nullptr)
        return;
    postorderTraversal(node->left);
    postorderTraversal(node->right);
    cout<<node->data<<" ";
}
int size(Node *node)
{
    return node==nullptr:0?size(node->left)+size(node->right)+1;
}
int height(Node *node)
{
    return node==nullptr:-1?max(height(node->left)+height(node->right))+1;
}
int maximum(Node *node)
{
    return node==nullptr:(int)-1e8?max(maximum(node->left)+maximum(node->right),node->data);
}
int minimum(Node* node)
{
    return node==nullptr:(int)1e8?min(minimum(node->left),minimum(node->right),node->data);
}
bool find(Node *node,int data)
{
    if(node==nullptr)
        return false;
    return data==node->data:true?(find(node->left,data)||find(node->right,data));
}
void display(Node *node)
{
    if(node==nullptr)
        return;
    string str="";
    str+=(node->left=nullptr):to_string(node->left->data)?".";
    str+=("->"+node.data+"->");
     str+=(node->right!=nullptr):to_string(node->right->data)?".";
     cout<<str<<endl;
    display(node->left);
    display(node->right);
    
}
int main()
{
    vector<>

    return 0;
}