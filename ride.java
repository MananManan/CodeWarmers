/*
ID: man95011		
PROG: ride
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class ride {

       public static int result(String abc){
           
           int product = 1;
           for (int i = 0; i < abc.length(); i++){
               product *= (int)(abc.charAt(i) - 64);
           }
           
           return product%47;
           
       }
    
    public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("ride.in"));
		PrintWriter output = new PrintWriter("ride.out");
                
                if ( result(input.nextLine()) == result (input.nextLine())){
                    output.println("GO");
                }
                else output.println("STAY");
                
      // write your code here!
         
		output.close();
	}
}
