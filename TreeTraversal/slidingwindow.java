import java.util.*;
public class slidingwindow {
    public static int maxSum(int arr[],int n,int k)
    {
        int maxsum = Integer.MIN_VALUE;
        for(int i=0;i<n-k+1;i++)
        {
            int current_sum = 0;
            for(int j=0;j<k;j++)
            {
                current_sum = current_sum +arr[i+j];
                
            }
            maxsum = Math.max(maxsum,current_sum);
        }
        return maxsum;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int arr[] = new int[size];
        for(int i=0;i<arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int n = arr.length;
        System.out.println(maxSum(arr,n,k));
        sc.close();

    }
}
