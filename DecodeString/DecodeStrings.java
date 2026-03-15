package DecodeString;
import java.util.*;
public class DecodeStrings {
    static String operation(String s)
    {
        Stack<Integer> stacknum = new Stack<>();
        Stack<Character> stackchar = new Stack<>();
        String temp = "";
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<s.length();i++)
        {
            int count = 0;
            if(Character.isDigit(s.charAt(i)))
            {
                while(Character.isDigit(s.charAt(i)))
                {
                    count = count*10 +(s.charAt(i)-'0');
                    i++;
                }
                i--;
                stacknum.push(count);

            }
            else if(s.charAt(i) == ']')
            {
                temp = "";
                count = stacknum.pop();
                while(stackchar.peek() != '[')
                {
                    temp = stackchar.pop()+temp;
                }
                stackchar.pop();
                StringBuilder repeated = new StringBuilder();
                for(int j=0;j<count;j++)
                {
                    repeated.append(temp);
                }
                for(int j=0;j<repeated.length();j++)
                {
                    stackchar.push(repeated.charAt(j));
                }

            }
            else
            {
                stackchar.push(s.charAt(i));
            }
        }
        while(!stackchar.isEmpty())
        {
            res.insert(0,stackchar.pop());
        }
        return res.toString();
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.print(operation(s));
        sc.close();
    }
    
}
