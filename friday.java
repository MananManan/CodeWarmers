/*
ID: man95011
PROG: friday
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class friday {

	public static boolean leapYear(int year){
		if(year%400 == 0) return true;
		else if (year%100 == 0) return false;
		else if(year%4 == 0) return true;
		else return false;
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("friday.in"));
		PrintWriter output = new PrintWriter("friday.out");

		int N = input.nextInt();

		int startDay = 2;//monday, 0 is saturday
		int[] num = new int[7]; //for the days of the week
		int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};

		for(int year = 1900; year < 1900 + N; year++){
			months[1] = leapYear(year)? 29:28;

			for(int month = 0; month < months.length; month++){
				num[(startDay + 13 - 1)%7]++;//adding the thirteenth day to the counter
				startDay = (startDay + months[month])%7;
			}
		}

		output.print(num[0] + " " + num[1] + " " + num[2] + " " + num[3] + " " + num[4] + " " + num[5] + " " + num[6] + "\n");

		output.close();
	}
}
