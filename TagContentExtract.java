/*
Challenge: Tag Content Extractor (Source: HackerRank)
In a tag-based language like XML or HTML, contents are enclosed between a start tag and an end tag like <tag>contents</tag>. Note that the corresponding end tag starts with a /.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:
The name of the start and end tags must be same. The HTML code <h1>Hello World</h2> is not valid, because the text starts with an h1 tag and ends with a non-matching h2 tag.
Tags can be nested, but content between nested tags is considered not valid. For example, in <h1><a>contents</a>invalid</h1>, contents is valid but invalid is not valid.
Tags can consist of any printable characters.

Input Format:
The first line of input contains a single integer, N (the number of lines).
The N subsequent lines each contain a line of text.

Output Format:
For each line, print the content enclosed within valid tags.
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print None.

Sample Input:
4
<h1>Nayeem loves counseling</h1>
<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
<Amee>safat codes like a ninja</amee>
<SA premium>Imtiaz has a secret crush</SA premium>

Sample Output:
Nayeem loves counseling
Sanjay has no watch
So wait for a while
None
Imtiaz has a secret crush
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtract{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases-- >0){ //Shorthand way of writing a loop, after every iteration the value of `testCases` will be decremented by 1
			String line = in.nextLine(); //Accepting the tagged sentence to extract content from
            boolean matchFound = false; //To keep track whether any valid content is found within the provided line
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>"); //Compiling a regular expression pattern
            //This pattern matches the start tag, 
            //followed by any content that is not a start tag itself, 
            //and then the corresponding end tag with the same name as the start tag
            Matcher m = r.matcher(line);
            while (m.find()) { //To find all the occurrences of the pattern in the line
                System.out.println(m.group(2)); //It is used to retrieve the entire matched string of each match found by the Matcher object `m`
                matchFound = true;
            }
            if (!matchFound) {
                System.out.println("None");
            }
        }
        in.close();
		}
}