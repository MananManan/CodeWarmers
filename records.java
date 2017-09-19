/*
ID: manman2a
PROG: records
LANG: JAVA
*/
import javafx.collections.transformation.SortedList;

import java.util.*;
import java.io.*;

class records {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("records.in"));
		PrintWriter output = new PrintWriter("records.out");

		int N = input.nextInt();

		PriorityQueue<String> records = new PriorityQueue<>();

		for(int i = 0; i < N; i++){
			String [] test = {input.next(),input.next(),input.next()};
			Arrays.sort(test);
			records.add(test[0]+test[1]+test[2]);
		}

		int max = 0, currentSize = 1;
		String current = null, last = null;
		while(!records.isEmpty()){
			last = current;
			current = records.poll();
			if(current.equals(last)) currentSize++;
			else currentSize = 1;
			if(currentSize > max) max = currentSize;
		}
		output.print(max);
		output.close();
	}
}
