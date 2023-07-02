/*E
Challenge: Luck Balance (Source: HackerRank)
Lena is preparing for a coding competition that is preceded by a number of sequential preliminary contests.
She believes in "Saving Luck" and wants to check her theory.
Each contest is described by two integers - L[i] and T[i]
L[i] is the amount of luck associated with each contest. If she wins the contest, her luck balance will decrease by L[i]; if she loses it, her luck balance will increase by L[i].

Complete the luckBalance function, returning an integer that represents the maximum luck achieveable.
luckBalance has following parameters:
k - the number of important contests Lena can lose
contests - a 2D array of integers representing the contests, where each row contains two integers - L[i] (the amount of luck associated with the contest) and T[i] (whether the contest is important or not).
*/
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LuckBalance{
	static int luckBalance(int k, int[][] contests){
		int luck_balance = 0; //to keep track of Lena's current luck balance
		//array is sorted in descending order based on the luck associated with each EnumConstantNotPresentException
		Arrays.sort(contests, new Comparator<int[]>(){
			public int compare(int[] a, int[] b){
				return -1 * Integer.compare(a[0], b[0]);
			}
		});

		for(int i = 0; i < contests.length; i++){
			int luck = contests[i][0];
			int importance = contests[i][1];

			if(importance == 1 && k > 0){
				k--; //variable to track the number of important contests she can still lose
				luck_balance += luck; //decreases her luck balance by the contest's luck
			} else if(importance == 1 && k == 0){ //If the contest is important but Lena cannot afford to lose any more important contests
				luck_balance -= luck; //increases her luck balance by the contest's luck
			}
			if(importance == 0){ //If the contest is not important, Lena wins the contest (increases her luck balance by the contest's luck)
				luck_balance += luck;
			}
		}
		return luck_balance; //maximum luck she can achieve
	}

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		String[] nk = s.nextLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		int[][] contests = new int[n][2];
		for(int i = 0; i < n; i++){
			contests[i][0] = s.nextInt();
            contests[i][1] = s.nextInt();
		}
		int result = luckBalance(k, contests);
        System.out.println(result);
	}
}