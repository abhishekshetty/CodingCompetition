/*
Marut loves to play with numbers. So, he keeps on asking questions to his big brother Pushkar. Today, he is playing with an array of numbers, A, of size N. Marut asks many queries to Pushkar.
In each query, Pushkar has to tell the minimum number of elements to be added in the array A such that Kth smallest number in A becomes the Xthsmallest number in A.
Only positive non-zero numbers can be added to A. Your task is to help Pushkar in answering Q queries of Marut.
Note: A number p in A is said to be the Kth smallest number of A if after sorting A in non decreasing order, p is present at Kth position of A. For example, if an array has 5 elements: 2, 4, 45, 20, 13 respectively - then the 3rd smallest element would be: 13.
Input:
The first line contains an integer N, denoting the size of the array A. 
The second line contains N integers separated by a single space. 
The third line contains an integer Q, denoting the number of queries. 
Next Q lines contain two integers K and X, separated by a single space.
Output:
Print the answers for the Q queries, each in a new line.
Constraints: 
1 ≤ Size of the array ≤ 4x106 
1 ≤ Elements of the Array, Ai ≤ 105 
1 ≤ Number of queries ≤ 105
1 ≤ Value of K ≤ Value of X ≤ N
Subtask 1: (25 points)
1 ≤ N ≤ 103 
1 ≤ Ai ≤ 103 
1 ≤ Number of queries ≤ 103
1 ≤ Value of K ≤ Value of X ≤ N
Subtask 2: (75 points)
Original constraints
________________________________________
Sample Input
(Plaintext Link)
8
6 5 8 8 3 1 2 6
1
2 4
Sample Output
(Plaintext Link)
2
Explanation
In first query, K=2. The second smallest array element = 2. 
So if we add elements 1 and 2 in A, our final array will look like {6,5,8,8,3,1,2,6,1,2}.
Now, 4th smallest element in the final array is 2. So query answer is 2 as we added two elements to original array.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Smallest {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		/*
		for(String s:input){
			list.add(Integer.parseInt(s));
		}
		*/
		for(int i=0;i<size;i++){
			list.add(Integer.parseInt(input[i]));
		}
		
		Collections.sort(list);
		
		int qCount = Integer.parseInt(br.readLine());
		for (int i=0;i<qCount;i++){
			String[] ip = br.readLine().split(" ");
			int temp = list.get(Integer.parseInt(ip[0])-1);
			//System.out.println(temp);
			int lastIndex = list.lastIndexOf(temp)+1;		
			int op =Integer.parseInt(ip[1])-lastIndex;
			System.out.println(op);
		}
		br.close();
	}

}
