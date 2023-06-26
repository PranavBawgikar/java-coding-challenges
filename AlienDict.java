/*
Challenge: Verify the Alien Dictionary (Source: HackerEarth)
You are given a string key that contains the 26 english alphabets, jumbled in some order.
You are also given n words stored in an array str.
Check if the words in str are sorted lexicographically according to string key.

Input:
key - A string that denotes the correct order
n - The number of words in str
str - An array of words that must follow the key string lexicographically

Output:
1 if all the words in str are lexicographically sorted according to key, 0 if they are not.

Sample Input 1
HECABDFGIJKLMNOPQRSTUVWXYZ
3
HACKER
EARTHS
CODEXPLAINED
*/
import java.util.Scanner;
public class AlienDict{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the key:");
		String key = s.nextLine();
		System.out.println("Enter the number of words in str:");
		int n = s.nextInt();
		s.nextLine(); // Consume the newline character
		System.out.println("Enter the words in str:");
		String str[] = new String[n];
		for(int i = 0; i < n; i++){
			str[i] = s.nextLine();
		}
		int result = isLexicographic(key, n, str);
		System.out.println(result);
	}

	static int charToIndex(char c){
		return (int) c - 65;
		//charToIndex method is used to convert each character to its corresponding index in the decoder array.
	}

	static int isLexicographic(String key, int n, String[] str){
		int[] decoder = new int[26]; //to map each character of the key to its corresponding index.
		for(int i = 0; i < key.length(); i++){
			decoder[charToIndex(key.charAt(i))] = i;
		}
		for(int i = 0; i < n - 1; i++){ //to compare adjacent words in the str array
			int j = 0; //represents the current position being compared in the two words
			while(j != str[i].length() && j != str[i + 1].length() && str[i].charAt(j) == str[i + 1].charAt(j)){ //to compare the characters at index j in str[i] and str[i + 1]
				j += 1;
			}
			if(j == str[i].length()){
				continue;
			}
			if(j == str[i + 1].length()){
				return 0;
			}
			if(decoder[charToIndex(str[i].charAt(j))] > decoder[charToIndex(str[i + 1].charAt(j))]){
				return 0;
			}
		}
		return 1;
	}
}