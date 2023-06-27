/*
Challenge: Jumping on the Clouds (Source: HackerRank)
Emma is playing a new mobile game that starts with consecutively numbered clouds.
Some of the clouds are thunderheads and cumulus.
She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
She must avoid the thunderheads.
Determine the minimum number of jumps it will take Emma to jump from her starting position to the last cloud.
It is always possible to win the game.
For each game Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
*/
import java.util.Scanner;

public class JumpClouds{

	private static final Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the total number of clouds: ");
		int n = s.nextInt();
		System.out.println("Enter the " + n + " space-separated binary integers describing the clouds:");
		int[] c = new int[n];
		for(int i = 0; i < n; i++){
			c[i] = s.nextInt();
		}
		int result = jumpingOnClouds(c);
		System.out.println(result);
	}

	static int jumpingOnClouds(int[] c){
		int num_jumps = 0; //to keep track of the number of jumps
		int i = 0; //the current cloud index
		while(i < c.length - 1){
			if(i + 2 == c.length || c[i + 2] == 1){ //
				i++;
				num_jumps++;
				// Inside the loop, two conditions are checked to determine the next cloud to jump to:
                //a. If the next cloud (i.e., c[i + 2]) is a thundercloud (denoted by 1) or if it goes beyond the last cloud (i.e., i + 2 == c.length), it means Emma cannot make a jump of length 2. 
                //In this case, she can only jump to the next cloud (i.e., i + 1). 
                //So, i is incremented by 1 and num_jumps is incremented by 1 to account for this jump.
			} else {
				i += 2;
				num_jumps++;
				//b. Otherwise, if the next cloud is safe (denoted by 0), Emma can make a jump of length 2. 
				//In this case, i is incremented by 2 and num_jumps is incremented by 1 to account for this jump.
			}
		}
		return num_jumps;
	}
}