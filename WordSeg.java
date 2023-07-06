/*H
Challenge: Word Segmentation with Dictionary Reuse
Category: Dynamic Programming, Backtracking
Given a string S and a dictionary of string wordDict of size n, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.
Note: The same word in the dictionary may be reused multiple times in the segmentation.
Examples
Input:
s = "catsanddog"
n = 5
wordDict = ["cat","cats","and","sand","dog"]

Output:
["cats and dog","cat sand dog"]

Input:
s = "pineapplepenapple"
n = 5
wordDict = ["apple","pen","applepen","pine","pineapple"]

Output:
["pine apple pen apple","pineapple pen apple","pine applepen apple"]

Input:
s = "catsandog"
n = 5
wordDict = ["cats","dog","sand","and","cat"]

Output:
[]

Input format :
A string s consisting of lowercase English letters (1 <= |s| <= 200).
An integer n represents the size of the dictionary (1 <= n <= 1000).
The next n lines consist of strings denoting the words in the dictionary.

Output format :
The output consists of a list of strings, where each string is a space-separated sequence of dictionary words that form the input string s. If no such sequence exists, an empty list is returned.
*/

import java.util.Scanner ;
import java.util.List ;
import java.util.LinkedList ;
import java.util.HashSet ;
import java.util.HashMap ;
import java.util.LinkedHashSet ;
import java.util.ArrayList ;
import java.util.Collections ;

class WordSeg{
    public static List<String> wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> str = new LinkedHashSet<String>(wordDict); //To store the words from the dictionary, for quick lookup if the given string is a valid word
        boolean [] dp = new boolean[s.length()  + 1]; //Boolean array
        HashMap<Integer, List<String>> dpMap = new HashMap<>(); //Used to store the intermediate results
        //Here, the key represents the end index of the substring, and the value is a list of strings representing the possible word segmentations for that substring
        HashSet<Integer> lengths = new LinkedHashSet<Integer>(); //To store the lengths of the words in the dict
        for(String s1 : wordDict){
            lengths.add(s1.length());
        }
        dpMap.put(0, new ArrayList<String>()); dpMap.get(0).add("");
        dp[0] = true;    
        str.add("");
        for(int i = 0; i < s.length(); ++i){
            for(Integer s1 : lengths){
                if(i+1 < s1) continue;
                int j = i+1 - (s1);
                String cur = s.substring(j, i+1);
                if(dp[j] && str.contains(cur)){
                    dp[i+1] = true; 
                }
            } 
        }
        if(!dp[s.length()]) return Collections.emptyList();
        for(int i = 0; i < s.length(); ++i){
            for(Integer s1 : lengths){
                if(i+1 < s1) continue;
                int j = i+1 - (s1);
                String cur = s.substring(j, i+1);
                if(dp[j] && str.contains(cur)){
                    if(!dpMap.containsKey(i+1)) {
                        dpMap.put(i+1, new ArrayList<String>());
                    }
                    for(String sb : dpMap.get(j)){  
                         dpMap.get(i+1).add(sb + (sb.isEmpty() ? "" : " ") + cur);
                    }
                    
                }
            } 
        }         
        if(!dpMap.containsKey(s.length())) return Collections.emptyList(); 
        return dpMap.get(s.length());
        
    }
    
    public static void main(String a[]) {
        Scanner sc = new Scanner(System.in) ;
        String s = sc.next() ;
        int n = sc.nextInt() ;
        List<String>wordDict = new LinkedList<>() ;
        for(int i = 0 ; i < n ; i++)
            wordDict.add(sc.next()) ;
        System.out.print( wordBreak(s, wordDict) ) ;
    }
}