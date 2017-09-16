/*
ID: manman2a
PROG: skidesign
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class skidesign {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("skidesign.in"));
		PrintWriter output = new PrintWriter("skidesign.out");

		int N = input.nextInt();
		int[] hills = new int[N];

		for(int i =0; i < N; i++){
			hills[i] = input.nextInt();
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i = 0; i < N; i++){
			if(hills[i] < min) min = hills[i];
			if(hills[i] > max) max = hills[i];
		}

		int minCost = Integer.MAX_VALUE;
		for(int i = min; i <= max; i++) {//i starts from the size of the smallest hill
			int cost = 0;
			for(int j = 0; j < N; j++){//j iterates over the array
				int x = 0;
				if(hills[j] < i) x = i - hills[j];
				else if (hills[j] > i + 17) x = hills[j] - (i + 17);
				cost += x*x;
			}
			if(cost < minCost) minCost = cost;
		}

		output.print(minCost);

		output.close();
	}
}
