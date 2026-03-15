class BinaryTree
{//creation of Root Reference variable
    Node root;
    // Binary tree implementation
    class Node
    {
        int data;
        Node left, right;
        Node(int data)
        {
            this.data = data;
            left = null;
            right = null;
        }

    }
    public BinaryTree(int d)
    {
         root = new Node(d);
    }
    public void insertleft(Node r,int d)
    {
        Node newNode = new Node(d);
        r.left = newNode;
    }
    public void insertright(Node r,int d)
    {
        Node newNode = new Node(d);
        r.right = newNode;
    }
    //PreOrder Traversal
    public static void preOrder(Node root)
    {
        if(root != null)
        {
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
        }
    }
    //InOrder traversal
    public static void inOrder(Node root)
    {
        if(root != null)
        {
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
        }
    }
    //PostOrder traversal
    public static void PostOrder(Node root)
    {
        if(root != null)
        {
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.print(root.data+" ");
        }
    }
    
}
public class Main
{
    public static void main(String args[])
    {
        BinaryTree t = new BinaryTree(10);
        t.insertleft(t.root,5);
        t.insertright(t.root,15);
        t.insertleft(t.root.left,3);
        t.insertright(t.root.left,8);
        t.insertleft(t.root.right,12);
        BinaryTree.inOrder(t.root);
        System.out.println();
        BinaryTree.preOrder(t.root);
        System.out.println();
        BinaryTree.PostOrder(t.root);

        

    }
}