/*E
Challenge: Java Varargs - Simple Edition
You are given a class Solution and its main method in the editor.
Your task is to create the class Add and the required methods so that the code prints the sum of the numbers passed to the function add.

Note: Your add method in the Add class must print the sum as given in the Sample Output

Input Format
There are six lines of input, each containing an integer.

Output Format
There will be only four lines of output. Each line contains the sum of the integers passed as the parameters to add in the main method.

Sample Input
1
2
3
4
5
6
Sample Output

1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21
*/

import java.io.*;
import java.util.*;
import java.lang.reflect.*;

public class VarargsDemo {

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n1 = Integer.parseInt(br.readLine());
            int n2 = Integer.parseInt(br.readLine());
            int n3 = Integer.parseInt(br.readLine());
            int n4 = Integer.parseInt(br.readLine());
            int n5 = Integer.parseInt(br.readLine());
            int n6 = Integer.parseInt(br.readLine());

            Add a = new Add();

            a.add(n1, n2);
            a.add(n1, n2, n3);
            a.add(n1, n2, n3, n4, n5);
            a.add(n1, n2, n3, n4, n5, n6);

            //Using Java's Reflection API to determine if there is any method overloading in the Add class
            Method[] methods = Add.class.getDeclaredMethods(); //Retrieves an array of Method objects representing all the methods declared in the Add class
            Set<String> set = new HashSet<>(); //This set will be used to keep track of method names encountered so far
            boolean overload = false; //This variable will be used to indicate whether method overloading is detected
            for(int i = 0; i < methods.length; i++) {
                if(set.contains (methods[i].getName())) { //Check if the `set` already contains the name of the current method
                    overload = true; //A method with the same name has already been encountered, indicating potential overloading
                    break; //Since overloading is detected the flag was set to `true` and hence breaking the loop
                }
                set.add(methods[i].getName()); //It adds the method's name to the set
            }
            if(overload) {
                throw new Exception("Overloading not allowed");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class Add {
    void add(int... numbers) {
            StringBuffer sb = new StringBuffer(); //To build the output string
            int sum = 0;
            for(int num : numbers) {
                sb.append(num + "+");
                sum += num;
            }
            sb.setCharAt(sb.length() - 1, '='); //The last `+` is replaced with `=`
            sb.append(sum);
            System.out.println(sb);
    }
}