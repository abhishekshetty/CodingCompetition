/*
Problem : Stone Game - One Four
Alice and Bob are playing a game called "Stone Game". Stone game is a two-player game. Let N be the total number of stones. In each turn, a player can remove either one stone or four stones. The player who picks the last stone, wins. They follow the "Ladies First" norm. Hence Alice is always the one to make the first move. Your task is to find out whether Alice can win, if both play the game optimally.
Input Format: 
First line starts with T, which is the number of test cases. Each test case will contain N number of stones.
Output Format: 
Print "Yes" in the case Alice wins, else print "No".
Constraints:
1<=T<=1000
1<=N<=10000
Sample Input and Output
SNo.	Input	Output
1	
3
1
6
7

Yes
Yes
No
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class alicebob2 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n_testcases = Integer.parseInt(br.readLine());
		// System.out.println(alice(25));

		for (int i = 0; i < n_testcases; i++) {
			int input = Integer.parseInt((br.readLine()).trim());
			if (alice2(input))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		// TODO Auto-generated method stub

	}

	

	public static boolean alice2(int a) {
		if (a >= 0) {
			// chance=false;
			boolean take1=false;
			boolean take4=false;
			if (a == 1 || a == 4)
				return true;
			else
				take1 = (bob2(a - 1) == false);
			if (a > 4)
				take4 = (bob2(a - 4) == false);
			if (take1 || take4)
				return true;
			else
				return false;
		}
		return false;
	}
	public static boolean bob2(int a) {
		if (a >= 0) {
			// chance=false;
			boolean take1=false;
			boolean take4=false;
			if (a == 1 || a == 4)
				return true;
			else
				take1 = (alice2(a - 1) == false);
			if (a > 4)
				take4 = (alice2(a - 4) == false);
			if (take1 || take4)
				return true;
			else
				return false;
		}
		return false;
	}
}
