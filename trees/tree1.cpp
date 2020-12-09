#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

class Node{
    public: int data;
            Node* left;
            Node* right;
        Node (int data){
            this->data=data;
            this->left=NULL;
            this->right=NULL;
        }
};
int idx=0;
Node* constructTree(vector<int>&arr){
    if(idx==arr.size() || arr[idx]==-1)
     {      
            idx++;
            return nullptr;
     }
    Node* node= new Node(arr[idx++]);
    node->left=constructTree(arr);
    node->right=constructTree(arr);
    return node;
}
void display(Node* node){
    if(node==nullptr)
        return ;
    string str = "";
    str += node->left != nullptr ? to_string(node->left->data) : ".";
    str += " <- " + to_string(node->data) + " -> ";
    str += node->right != nullptr ? to_string(node->right->data) : ".";
    cout << str << endl;
display(node->left);
display(node->right);
    
    
    
    
    
    
    

}
void solve(){
    vector<int>arr={10,20,30,40,-1,-1,50,-1,-1,60,70,-1,80,-1,-1,-1,90,100,-1,120,-1,-1,110,130,-1,-1,-1};
    Node* node=constructTree(arr);
    display(node);
}   
int main(){
    solve();
    return 0;
}