/*
Problem : Matrix Rotations
You are given a square matrix of dimension N. Let this matrix be called A. Your task is to rotate A in clockwise direction by S degrees, where S is angle of rotation. On the matrix, there will be 3 types of operations viz. 
Rotation
Rotate the matrix A by angle S, presented as input in form of A S 
Querying
Query the element at row K and column L, presented as input in form of Q K L
Updation
Update the element at row X and column Y with value Z,  presented as input in form of U X Y Z
Print the output of individual operations as depicted in Output Specification
Input Format: 
Input will consist of three parts, viz.
1. Size of the matrix (N)
2. The matrix itself (A = N * N)
3. Various operations on the matrix, one operation on each line. (Beginning either with A, Q or U)
-1 will represent end of input.
Note:
Angle of rotation will always be multiples of 90 degrees only.
All Update operations happen only on the initial matrix. After update all the previous rotations have to be applied on the updated matrix
Output Format: 
For each Query operation print the element present at K-L location of the matrix in its current state.
Constraints:
1<=N<=1000
1<=Aij<=1000
0<=S<=160000
1<=K, L<=N
1<=Q<=100000

Sample Input and Output
SNo.	Input	Output
1	
2
1 2
3 4
A 90
Q 1 1
Q 1 2
A 90
Q 1 1 
U 1 1 6
Q 2 2
-1


3
1
4
6

Explanation: 
Initial Matrix

1 2
3 4
After 90 degree rotation, the matrix will become
3 1
4 2
Now the element at A11 is 3 and A12 is 1.
Again the angle of rotation is 90 degree, now after the rotation the matrix will become
4 3
2 1
Now the element at A11 is 4.
As the next operation is Update, update initial matrix i.e.
6 2
3 4
After updating, apply all the previous rotations (i.e. 180 = two 90 degree rotations).
The matrix will now become
4 3
2 6
Now A22 is 6.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


class rotate {
	
	public static int init_rot=0;

	public static void main(String[] args) throws NumberFormatException, IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int dim=Integer.parseInt(br.readLine());
    int data[][]=new int[dim][dim];
    for (int i=0;i<dim;i++){
		String s[] =br.readLine().split(" ");
    	for (int j=0;j<dim;j++){
			data[i][j]=Integer.parseInt(s[j]);
		}
		}
	
    String per=null;
    int[][] old_matrix = data;
    per=br.readLine();
    while(!(per.equals("-1"))){
    	
    	char op=per.charAt(0);
    	String temp[]=per.split(" ");
    	switch(op){
    		case 'A': int num=Integer.parseInt(temp[1]);
    				  num=(num%360)/90;
    				  
    				  init_rot+=num%4;
    				  
    				  
    				  for(int i=0;i<num;i++)selectRotate(data,num%4);
    				  //show(data);
    				  break;
    		case 'Q': System.out.println(data[Integer.parseInt(temp[1])-1][Integer.parseInt(temp[2])-1]);
    					//show(data);
    					break;
    		case 'U': 	data=old_matrix;
    					data[Integer.parseInt(temp[1])-1][Integer.parseInt(temp[2])-1]=Integer.parseInt(temp[3]);		
    					rotate_old(data);
    					//old_matrix=data;
    					//show(data);
    					break;
    	}	
    	per=br.readLine();
    }
	} 
	public static void rotate_old(int a[][])
	{
		 
		selectRotate(a,init_rot%4);//System.out.println(init_rot%4);
				
	}
	
	/*public static void show(int a[][] ){
		for (int i=0;i<a.length;i++){
			for (int j=0;j<a[0].length;j++){
				System.out.print(a[i][j]+" ");
				
			}
			System.out.println();
		}
	} */

	public static void rotateMatrix(int a[][]) {
	    int n = a.length;
	    if (n <= 1) {
	        return; // nothing to do
	    }

	    /* layers */
	    for (int i = 0; i < n / 2; i++) {
	        /* elements */
	        for (int j = i; j < n - i - 1; j++) {
	            int saved = a[i][j];
	            a[i][j] = a[n - j - 1][i];
	            a[n - j - 1][i] = a[n - 1 - i][n - 1 - j];
	            a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
	            a[j][n - 1 - i] = saved;
	        }
	    }
	}
	public static void rotate180(int a[][]){
		int row=a.length;
		int col=a[0].length;
		for(int i=0;i<row/2;i++){
			for(int j=0;j<col;j++){
				int temp=a[i][j];
				a[i][j]=a[row-1-i][col-1-j];
				a[row-1-i][col-1-j]=temp;
			}
		}
		
	}
	public static void rotate270(int a[][]){
		int n = a.length;
	    if (n <= 1) {
	        return; // nothing to do
	    }

	    /* layers */
	    for (int i = 0; i < n / 2; i++) {
	        /* elements */
	        for (int j = i; j < n; j++) {
	            int saved = a[i][j] ;
	            a[i][j]=a[j][i];
	            a[j][i]=saved;
	        }
	        
	    }
		
	}
	public static void selectRotate(int a[][],int n){
		if (n==1)rotateMatrix(a);
		else
			if (n==2)rotate180(a);
			else
				if(n==3)rotate270(a);
	}
	


}
