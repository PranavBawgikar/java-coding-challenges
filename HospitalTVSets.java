/* M
Challenge: Television Sets
Dr. Vishnu is opening a new world-class hospital in a small town designed to be the first preference of the patients in the city. Hospital has N rooms of two types - with TV and without TV, with daily rates of R1 and R2, respectively. 
However, from his experience, Dr. Vishnu knows that the number of patients is not constant throughout the year, instead follows a pattern. 
The number of patients on any given day of the year is given by the following formula - (6-M)^2+ID-15/
where M is the number of months (1 for Jan, 2 for Feb... 12 for Dec) and D is the date (1,2...31).
All patients prefer without TV rooms as they are cheaper, but will opt for with TV rooms only if without TV rooms are not available. Hospital has a revenue target for the first year of operation. Given this target and the values of N, R1, and R2 you need to identify the number of TVs the hospital should buy so that it meets the revenue target. Assume the Hospital opens on 1st Jan and year is a non-leap year.

Example 1
Input:
20
1500 1000
7000000

Output:
14

Explanation:
Using the formula, the number of patients on 1st Jan will be 39, on 2nd Jan will be 38, and so on. 
Considering there are only twenty rooms and the rates of both types of rooms are 1500 and 1000 respectively, we will need 14 TV sets to get revenue of 7119500. 
With 13 TV sets, Total revenue will be less than 7000000

Example 2
Input:
10
1000 1500
10000000

Output:
10

Explanation:
In the above example, the target will not be achieved, even by equipping all the rooms with a TV. 
Hence, the answer is 10 i.e. total number of rooms in the hospital.

Input format:
First-line provides an integer N that denotes the number of rooms in the hospital
Second-line provides two space-delimited integers that denote the The third line provides the revenue target rates of rooms with TV (R1) and without TV (R2) respectively

Output format:
Minimum number of TVs the hospital needs to buy to meet its revenue target. If it cannot achieve its target, print the total number of rooms in the hospital.

Code constraints:
Hospital opens on 1st Jan in an ordinary year
5<= Number of rooms <= 100
500 <= Room Rates <= 5000
0 <= Target revenue < 90000000
*/

import java.util.Scanner;

public class HospitalTVSets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //number of rooms in hospital
        int R1 = scanner.nextInt(); //rates of rooms with TV
        int R2 = scanner.nextInt(); //without TV
        int targetRevenue = scanner.nextInt();

        int totalRooms = N;
        int totalTVs = 0;

        for(int M = 1; M <= 12; M++) {
            for(int D = 1; D <= 31; D++) {
                int patients = ((6 - M) * (6 - M) + D - 15); //calculating the num of partients on a particular day
                int availableRooms = Math.min(N, patients);
                int withoutTVRevenue = availableRooms * R2;
                int withTVRevenue = 0;

                if(patients > N) {
                    int extraPatients = patients - N; //alculates the number of patients that exceed the available rooms
                    int availableTVs = Math.min(extraPatients, N);
                    withTVRevenue = availableTVs * R1;
                }

                int totalRevenue = withoutTVRevenue + withTVRevenue;

                if (totalRevenue >= targetRevenue && totalTVs < availableRooms) { //it means the current configuration has a higher revenue and fewer TVs used
                    totalRooms = availableRooms;
                    totalTVs = Math.min(availableRooms, N);
                }
            }
        }

        if (totalTVs == 0) {
            System.out.println(totalRooms);
        } else {
            System.out.println(totalTVs);
        }
    }
}
