import java.util.*;
class rotate
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();
        ArrayList<Integer> bl = new ArrayList<>();
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<size;i++)
        {
            arr[i] = sc.nextInt();
            al.add(arr[i]);
           
        }
        System.out.println(al);
        Arrays.sort(arr);
        for(int i=0;i<size;i++)
        {
            bl.add(arr[i]);
        }
        int count = 0;
        while(true)
        {
            int value = al.remove(0);
            al.add(value);
            count++;
            System.out.println(al);
            if(al.equals(bl))
            {
                
                break;
            }
            
            
        }
        System.out.print(count);
        sc.close();
        
    }
}
