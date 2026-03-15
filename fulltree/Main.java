import java.util.*;
class Main
{
    Node root;
    public static Node insert(Node root, int data)
    {
        if(root == null)
        {
            return new Node(data);
        }
        else if(root.data>data)
        {
            root.left = insert(root.left,data);
        }
        else
        {
            root.right = insert(root.right,data);
        }
        return root;
    }
    public static void display(Node root)
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            Node temp = q.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null)
            {
                q.add(temp.left);
            }
            if(temp.right != null)
            {
                q.add(temp.right);
            }
        }
    }
    public static Node delete(Node root, int del)
    {
        if(root == null)
        {
            return null;
        }
        if(root.data>del)
        {
            root.left = delete(root.left,del);
        }
        else if(root.data<del)
        {
            root.right = delete(root.right,del);
        }
        else
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }
            
            Node temp = minValue(root.right);
            root.data = temp.data;
            root.right = delete(root.right,temp.data);
        }
        return root;
    }
    public static Node minValue(Node root)
    {
        while(root.left != null)
        {
            root = root.left;
        }
        return root;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Main tree = new Main();
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
            tree.root = insert(tree.root,arr[i]);
        }
        System.out.print("Initial BST: ");
        display(tree.root);
        System.out.println();
        int ins = sc.nextInt();
        insert(tree.root,ins);
        System.out.print("BST after inserting a new node "+ins+": ");
        display(tree.root);
        System.out.println();
        int del = sc.nextInt();
        System.out.print("BST after deleting node "+del+": ");
        delete(tree.root,del);
        display(tree.root);
        sc.close();
    }
}
class Node
{
    int data;
    Node left;
    Node right;
    Node(int iteam)
    {
        data = iteam;
        left = right= null;
    }
}