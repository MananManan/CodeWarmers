/*
ID: man95011		
PROG: ride
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class cowfind {
    
    public static void main(String[] args) throws Exception {
        
		Scanner input = new Scanner(new File("cowfind.in"));
		PrintWriter output = new PrintWriter("cowfind.out");
                
                
                String cow = input.nextLine();
                int num = 0, front = 0;
                
                for (int i = 0; i < cow.length()-1; i++){
                    //(())
                    if (cow.substring(i,i+2).equals("((")) front++;
                    else if (cow.substring(i, i+2).equals("))")) num+= front;
                    
                }
                output.println(num);
         
		output.close();
	}
}
