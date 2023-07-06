/*M
Challenge: Number 2 Word Converter
Convert a non-negative integer number to its English word representation.

Example
Input
123

Output
One Hundred Twenty-Three

Input
12345

Output
Twelve Thousand Three Hundred Forty-Five

Input
1234567

Output
One Million Two Hundred Thirty-Four Thousand Five Hundred Sixty-Seven

Input format :
The input consists of a single integer n (0 ≤ n ≤ 10^12) representing the number to convert to words.

Output format :
The output consists of a single string representing the number in words.

Code constraints :
0 <= num <= 231 - 1
*/

import java.util.Scanner ;
class Num2Word {
    private static final String[] digits = new String[] {
        "", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ",
        "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ","Eighteen ", "Nineteen "
    };

    private static final String[] tenths = new String[] {
        "", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "
    };

    private static final String hundred = "Hundred ";

    private static final String[] llions = new String[] {
        "", "Thousand ", "Million ", "Billion ", "Trillion "
    };

    public static String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        String word = "";
        int pow = 0; //to keep track of the current number segment (thousands, millions, billions)
        
        while (num > 0) {
        	//Extracting the last 3 digitd of num
        	//Let's understand this with an example:
        	//Suppose the num = 123456789, so in the first iteration
            int n = num % 1000; //will give us 789
            
            int h = n / 100; //calculates h as 789 / 100, which results in 7 (hundreds place)
            int t = n / 10 % 10; //calculates t as (789 / 10) % 10, which results in 8 (tens place)
            int d = n % 10; // calculates d as 789 % 10, which results in 9 (one place)
            
            String w = ""; //Builds the word representation w based on h, t and d values
            
            if (h > 0) { //Checks if the hundreds place is greater than zero and adds the corresponding word and "Hundred" to w
                w = digits[h] + hundred;
            }
            if (t == 0) {
                w += digits[d]; //Since t is not zero (i.e., 8) the code adds the word representation for 8 as "Eighty" so w becomes Seven Hundred Eighty
            } else if (t == 1) {
                w += digits[t * 10 + d];     
            } else {
                w += tenths[t];
                w += digits[d];
            }
            
            if (!w.isEmpty()) {
                if (pow > 0) {
                    word = w + llions[pow] + word;
                } else {
                    word = w;    
                }
            }
            
            num /= 1000;
            pow++;
        }
        
        return word.trim();
    }
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in) ;
        int n = sc.nextInt() ;
        System.out.print( numberToWords(n) ) ;
    }
}