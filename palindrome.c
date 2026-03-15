#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<math.h>
#include<ctype.h>
int main()
{
    char str[10000];
    char freq[256]= {0};
    printf("Enter the String: ");
    fgets(str,sizeof(str),stdin);
    for(int i=0;str[i] != '\0';i++)
    {
        if(isalpha(str[i]))
        {
            char ch = tolower(str[i]);
            freq[ch]++;
            
        }
    }
    char left[200];
    int index =0;
    char center = 0;
    int length = 0;
    for(int i=0;i<256;i++)
    {
        if(freq[i] >= 2)
        {
        int pairs = freq[i]/2;
        for(int j=0;j<pairs;j++)
        {
            left[index++] = i;
        }
        length += pairs*2;
        }
        
        
        if(freq[i]%2 == 1 && center == 0)
    {
        center = i;
    }
    }
    left[index] = '\0';
    if(center != 0)
    {
        length++;
    }
    printf("The longest palindrome: ");
    printf("%s",left);
    if(center != 0)
    {
        printf("%c",center);
    }
    for(int i=index-1;i>=0;i--)
    {
        printf("%c",left[i]);
    }
    printf("\n");
    printf("The maximum length: ");
    printf("%d",length);
    
    
    
    
}
