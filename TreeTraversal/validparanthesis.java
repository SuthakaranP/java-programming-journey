import java.util.*;
public class validparanthesis {
    public static boolean isvalid(char arr[])
    {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            char ch = arr[i];
            if(ch == '(' || ch == '{' || ch == '[')
            {
                 s.push(ch);
            }
            else if(ch == ')' )
            {
                if(s.isEmpty() || s.pop() != '(')
                {
                    return false;
                }
            }
            else if(ch == '}' )
            {
                if(s.isEmpty() || s.pop() != '{')
                {
                    return false;
                }
            }
            else if(ch == ']' )
            {
                if(s.isEmpty() || s.pop() != '[')
                {
                    return false;
                }
            }
        
        }
        return s.isEmpty();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char arr[] = input.toCharArray();
        boolean result = isvalid(arr);
        System.out.println(result);
        sc.close();

    }
    
}
