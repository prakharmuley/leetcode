/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    private Node fun(Node root)
    {
        Node temp=root;
        while(temp!=null)
        {
            if(temp.left!=null) return temp.left;
            if(temp.right!=null) return temp.right;
            temp=temp.next;
        }
        return null;
    }
    public void dfs(Node root)
    {
        if(root==null) return;
      
        if(root.left!=null)
        {
           if(root.right!=null)
           {
             root.left.next=root.right;
           }
           else 
              root.left.next=fun(root.next);

        }
        if(root.right!=null)
        {
            root.right.next=fun(root.next);
        }
        
        
        dfs(root.right);
        dfs(root.left);
       
    }
    public Node connect(Node root) {
        dfs(root);
        return root;
    }
}