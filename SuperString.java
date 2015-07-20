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
