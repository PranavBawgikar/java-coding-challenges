/*E
Challenge: Java List (Source: HackerRank)
For this problem, we have 2 types of queries you can perform on a List:

Insert y at index x:
Insert
x y

Delete the element at index x:
Delete
x

Given a list, L of N integers, perform Q queries on the list. Once all queries are completed, print the modified list as a single line of space-separated integers.

Input Format
The first line contains an integer, N (the initial number of elements in L).
The second line contains N space-separated integers describing L.
The third line contains an integer, Q (the number of queries).
The 2Q subsequent lines describe the queries, and each query is described over two lines:

If the first line of a query contains the String Insert , then the second line contains two space separated integers x y and the value y must be inserted into L at index X.
If the first line of a query contains the String Delete , then the second line contains index x, whose element must be deleted from L.

Output Format
Print the updated list L as a single line of space-separated integers.

Sample Input
5
12 0 1 78 12
2
Insert
5 23
Delete
0

Sample Output
0 1 78 12 23
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ListOperations{
    public static void main(String args[]){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); //Initial number of elements in the List
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int a = s.nextInt();
            list.add(a); //Adding each element one by one to the LinkedList
        }
        int q = s.nextInt(); //Number of queries
        for(int i = 0; i < q; i++){
            String str = s.next();
            if(str.equals("Insert")){
                int index = s.nextInt();
                int v = s.nextInt(); //Node to be added at the particular index
                list.add(index, v);
            } else {
                int index = s.nextInt();
                list.remove(index);
            }
        }
        s.close();
        
        for(Integer a : list){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}