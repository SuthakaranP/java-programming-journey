import java.util.*;

class preOrderTraversal
{
    Node root;
    public Node insert(Node root,int key)
    {
        if(root == null)
        {
            return new Node(key);
        }
        if(key<root.data)
        {
            root.left = insert(root.left,key);
        }
        else
        {
            root.right = insert(root.right,key);
        }
        return root;
    }
    public void preOrder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        preOrderTraversal tree = new preOrderTraversal();
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
            tree.root = tree.insert(tree.root,arr[i]);
            
        }
        tree.preOrder(tree.root);
        sc.close();
        
        
        
    }
}
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int iteam)
    {
        data = iteam;
        left=right = null;
    }
    
    
}