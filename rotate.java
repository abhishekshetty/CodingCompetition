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
