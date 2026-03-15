
import java.util.*;
class BinarySearchs
{
    Node root;
    public BinarySearchs()
    {
        root = null;
    }
    public  static Node insert(Node root,int data)
    {
        if(root == null)
        {
            return new Node(data);
        }
        else if(data<root.data)
        {
            root.left = insert(root.left,data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }
    public  int findpos(int key)
    {
        return findRec(root,key,0);
    }
    public static int findRec(Node root,int data, int depth)
    {
        if(root == null )
        {
            return -1;
        }
        if(root.data == data)
        {
            return depth;
        }
        if(data<root.data)
        {
            return findRec(root.left,data,depth+1);
        }
        return findRec(root.right,data,depth+1);
    }
    
    public static void main(String args[])
    {
        BinarySearchs tree = new BinarySearchs();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
            tree.root = insert(tree.root,arr[i]);
        }
        System.out.print(tree.findpos(6));
        sc.close();
        
        
    }
}
class Node
{
    int data;
    Node left;
    Node right;
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}