/*
Problem : Super ASCII String Checker
In the Byteland country a string "S" is said to super ascii string if and only if count of each character in the string is equal to its ascii value. 
In the Byteland country ascii code of 'a' is 1, 'b' is 2 ...'z' is 26. 
Your task is to find out whether the given string is a super ascii string or not.
Input Format: 
First line contains number of test cases T, followed by T lines, each containing a string "S".
Output Format: 
For each test case print "Yes" if the String "S" is super ascii, else print "No" 
Constraints:
1<=T<=100
1<=|S|<=400, S will contains only lower case alphabets ('a'-'z').
Sample Input and Output
SNo.	Input	Output
1	
2
bba
scca


Yes
No

Explanation: 
In case 1, viz. String "bba" - 
The count of character 'b' is 2. Ascii value of 'b' is also 2. 
The count of character 'a' is 1. Ascii value of 'a' is also 1.
Hence string "bba" is super ascii. 
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class SuperString {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int data[];
		int n_testcases=Integer.parseInt(br.readLine());
		System.out.println();
		for(int i=0;i<n_testcases;i++){
			String input=(br.readLine()).trim();
			data=new int[26];
			for(int j=0;j<input.length();j++){
				data[pos(input.charAt(j))-1]+=1;
			}
			//show(data);
			if(check(data)){
				System.out.println("YES");
			}
			else{
				System.out.println("NO");
			}
		}		
		//System.out.println(((int)'z'-96));
	}
	public static int pos(char a){
		int data=(int)a-96;
		return data;
	}
	public static boolean check(int data[]){
		//boolean yes=false;
		for(int i=0;i<26;i++){
			if(data[i]!=0){
			if((i+1)!=data[i])
				return false;
		}
			}
		
		return true;
	}
	public static void show(int data[]){
		for(int i=0;i<data.length;i++)
			System.out.println(data[i]);
	}

}
