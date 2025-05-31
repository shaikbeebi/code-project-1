// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.io.*;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
       int operator,n1,n2;
       int result=0;
       Scanner sc=new Scanner(System.in);
       System.out.println(" 1.+\n 2.-\n 3.*\n 4./");
       System.out.println("Enter a choice");
       operator=sc.nextInt();
       System.out.println("Enter the first input:");
       n1=sc.nextInt();
       System.out.println("Enter the second input:");
       n2=sc.nextInt();
       switch(operator){
           case 1:
               result=n1+n2;
               break;
           case 2:
               result=n1-n2;
               break;
           case 3:
                result=n1*n2;
                break;
           case 4:
               result=n1/n2;
               break;
               default:
               System.out.println("Invalid choice:");
       }
       System.out.println("the result is:"+result);
    }
}
Output:-
1.+
 2.-
 3.*
 4./
Enter a choice
1
Enter the first input:
45
Enter the second input:
65
the result is:110

=== Code Execution Successful ===