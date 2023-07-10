/*
Challenge: Minimum Number of Platforms Required for a Railway/Bus Station
Given the arrival and departure times of all trains that reach a railway station, find the minimum number of platforms required for the station so that no train is kept waiting. Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure times can never be the same for a train, but we can have the arrival time of one train equal to the departure time of the other. At any given time, the same platform cannot be used for both the departure of a train and the arrival of another train. In such cases, we need different platforms.

Example:
Input:
6
arr[]= (0900, 0940, 0950, 1100, 1500, 1800} 
dep[] = {0910, 1200, 1120, 1130, 1900, 2000)

Output:
3

Explanation:
By observing the time intervals, we can determine the number of platforms required.
At 0900, there is one train arriving (platform count = = 1). 
At 0910, one train departs, but another train arrives (platform count = 1).
At 0940, one train arrives (platform count = = 2). 
At 0950, one train arrives (platform count = 3).
At 1100, one train arrives (platform count = 4).
At 1120, one train departs, but another train arrives (platform count = 4).
At 1130, one train departs, but another train arrives (platform count = 4).
At 1200, one train departs (platform count = 3).
At 1500, one train arrives (platform count = 4).
At 1800, one train arrives (platform count = 5). 
At 1900, one train departs (platform count = 4).
At 2000, one train departs (platform count = 3).

Hence, the minimum number of platforms required to accommodate all the trains without any waiting is 3, and that's why the output is 3.

Note: Time intervals are in the 24-hour format (HHMM), where the first two characters represent an hour (between 00 and 23), and the last two characters represent minutes (between 00 and 59).

Input format:
The first line of input contains an integer n, representing the number of trains.
The second line of input contains n space-separated integers denoting the arrival times of the trains.
The third line of input contains n space-separated integers denoting the departure times of the trains.

Output format:
The output contains a single integer denoting the minimum number of platforms required at the railway station such that no train waits.

Code constraints:
1≤ n ≤50000
0000 s A[i] < D[i] < 2359
*/

import java.util.*;

class MinPlatforms {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    public static int minimumPlatform(int n, int[] arr, int[] dep) {
        List<int[]> temp = new ArrayList<>(); //The arrival and departure times of the trains are stored in this List
        for (int i = 0; i < n; i++) { //Iterating over each train
            temp.add(new int[]{arr[i], dep[i]}); //For each iteration a new Integer array is created
            //Creating a new array and storing arrival and departure times for each train separately
        }
        Collections.sort(temp, Comparator.comparingInt(a -> a[0])); //The temp list is sorted based on arrival times and a custom Comparator
        int count = 1; //Represents the minimum number of platforms required
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //To keep track of the departure of the trains	
        heap.add(temp.get(0)[1]); //The first departure time is added to the priority queue
        for (int i = 1; i < temp.size(); i++) { //Starting from the second train in the sorted list, iterating over each train
            while (!heap.isEmpty() && heap.peek() < temp.get(i)[0]) {
                heap.poll();
            }
            heap.add(temp.get(i)[1]);
            count = Math.max(count, heap.size());
        }
        return count;
    }

    // Driver code
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //Represents the number of trains
        int[] arrival = new int[n]; //Contains the arrival times of the trains
        int[] departure = new int[n]; //Contains the departure times of the trains
        for (int i = 0; i < n; i++) {
            arrival[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            departure[i] = scanner.nextInt();
        }
        System.out.println(minimumPlatform(n, arrival, departure));
    }
}
