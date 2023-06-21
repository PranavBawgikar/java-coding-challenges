/*Challenge: Bob has to send a secret code S to his boss. 
He designs a method to encrypt the code using two key values N and M. The formula that he uses to develop the encrypted code is shown below: 
(((S^N % 10)^ M) % 1000000007)
Write an algorithm to help Bob to encrypt the code.

Hints: First take inputs S, N and M from the user, use pow()
*/
import java.util.Scanner;
public class BobEncryption{
	public static void main(String[] args) {
		double S, N, M;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter your Message(S): ");
		S = s.nextInt();
		System.out.println("Enter value for Key1(N): ");
		N = s.nextInt();
		System.out.println("Enter value for Key2(M): ");
		M = s.nextInt();
		double encryptedCode;
		encryptedCode = Math.pow(S, N); //Math.pow() returns a double value
		encryptedCode = encryptedCode % 10;
		encryptedCode = Math.pow(encryptedCode, M);
		encryptedCode = encryptedCode % 1000000007;
		System.out.println("The encryptedCode is " + encryptedCode);
	}
}
