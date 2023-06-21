/*
Challenge: Remove Outermost Parenthesis
Input: (()())(())
Output: ()()()

Hints: Make a note of the ASCII Values of Open and Close Paranthesis ( '(' --> 40, ')' --> 41), For loop to iterate through the string 
*/
public class OuterParenthesis{
	public static void main(String[] args) {
		String s = "(()())(())";
		String result = removeParanthesis(s);
		System.out.println(result);
	}
	static String removeParanthesis(String s){
		String result = "";
		int j = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 41) //Close Paranthesis
				j--;
			if(j!=0)
				result = result + s.charAt(i);
			if(s.charAt(i) == 40) //Open Paranthesis
				j++;
		}
		return result;
	}
}