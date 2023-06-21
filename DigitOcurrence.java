/* Challenge: Ocurrence of a digit in a Range

Hints: while loop that itertates in a range, calculate remainder
*/
public class DigitOcurrence{
	public static void main(String[] args) {
		int rangeStart = 1, rangeEnd = 20, digit = 1;
		System.out.println("The Ocurrence of "+ digit + " in (" + rangeStart + " to " + rangeEnd + ") is " + checkOcurrence(rangeStart, rangeEnd, digit));
	}
	static int checkOcurrence(int rangeStart, int rangeEnd, int digit){
		int count = 0;
		for(int i = rangeStart; i < rangeEnd; i++){
			int temp = i;
			while(temp > 0){
				if(temp % 10 == digit)
					count = count + 1;
				temp = temp/10;
			}
		}
		return count;
	}
}