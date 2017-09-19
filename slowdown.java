/*
ID: manman2a
PROG: slowdown
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class slowdown {

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("slowdown.in"));
		PrintWriter output = new PrintWriter("slowdown.out");

		int N = input.nextInt();

		PriorityQueue<Integer> t = new PriorityQueue<>();
		PriorityQueue<Integer> d = new PriorityQueue<>();

		for(int i = 0; i < N; i++){
			if(input.next().equals("T")) t.add(input.nextInt());
			else d.add(input.nextInt());
		}

		double time = 0;
		double distance = 0;
		double speed = 1;
		int slow = 2;
		while(distance < 1000){

			int slowTime = (t.peek() == null)? Integer.MAX_VALUE:t.peek();
			int slowDis = (d.peek() == null)? 1000:d.peek();
			double timeDiff = slowTime - time;
			double distanceDiff = slowDis - distance;

			if(timeDiff < distanceDiff/speed){//if the time event happens first
				if(t.peek()!=null)t.poll();
				distance += speed*timeDiff;
				time = slowTime;
			} else{//the distance event happens
				if(d.peek()!=null)d.poll();
				time += distanceDiff/speed;
				distance = slowDis;
			}
			speed = 1.0f/slow++;
		}

		output.print(Math.round(time));
		output.close();
	}
}
