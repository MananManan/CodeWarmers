/*
ID: manman2a
PROG: gift1
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class gift1 {


	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("gift1.in"));
		PrintWriter output = new PrintWriter("gift1.out");

		int number = input.nextInt();
		input.nextLine();
		LinkedHashMap<String,Integer> map = new LinkedHashMap<>(number); //to store the values

		//fill the hashmap
		for(int i = 0; i < number; i++){
			map.put(input.nextLine(),0);
		}

		while(input.hasNext()){//while there is input
			String key = input.nextLine();
			int money = input.nextInt();
			int people = input.nextInt();
			if(input.hasNext()) input.nextLine();
			if(people != 0) map.put(key,map.get(key) + money%people - money);//update the value
			for(int i = 0; i < people; i++){
				String k = input.nextLine();
				map.put(k,map.get(k) + money/people);
			}
		}

		for(Map.Entry<String, Integer> e: map.entrySet()){
			output.println(e.getKey() + " " + e.getValue());
		}

		output.close();
	}
}
