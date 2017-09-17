/*
ID: manman2a
PROG: relay
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class relay {

	public static int isNonLoopy(int cows[][], int start){//returns 1 is nonLoopy, 0 is loopy
		if(cows[start][1] == 1){//if this cow has already been visited
			return cows[start][2]; //return whatever loop condition this cow is in
		}
		cows[start][1] = 1;//this cow has been visited
		if(cows[start][0] == -1){//if this is the last cow
			return cows[start][2] = 1;//this cow is nonloopy (this will make every cow in this chain non loopy
		}
		else return cows[start][2] = isNonLoopy(cows,cows[start][0]);//this cow is whatever the next cow is
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("relay.in"));
		PrintWriter output = new PrintWriter("relay.out");

		int[][] cows = new int[input.nextInt()][3];
		input.nextLine();

		//option 0 : next index
		//option 1: visited(1) or not(0)
		//option 2: non-loopy(1) or not(0)

		for(int i = 0; i < cows.length; i++){//filling in the array
			cows[i][0] = input.nextInt()-1;
		}

		int count = 0;
		for(int i = 0; i < cows.length; i++){//number of rows
			if(isNonLoopy(cows,i) == 1) count++;
		}

		output.println(count);
		output.close();
	}

}
