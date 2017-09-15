/*
ID: man95011
PROG: template
LANG: JAVA
*/
import java.util.*;
import java.io.*;

public class greetings {

    public static int findNextEnd(Scanner input) throws IOException {
        return input.nextInt()*(input.next().equals("R")? 1:-1);
    }

    public static void main(String[] args) throws Exception {

        int moo = 0;

        Scanner input1 = new Scanner(new File("greetings.in"));
        PrintWriter output = new PrintWriter("greetings.out");

        int b = input1.nextInt(), e = input1.nextInt();//number of lines in elsie and bessie

        BufferedReader bf = new BufferedReader(new FileReader("greetings.in"));
        input1.nextLine();//go to the next line

        for(int i = 0; i <= b; i++,bf.readLine());//start from elsie
        Scanner input2 = new Scanner(bf);

        int distanceBetween = 0; //assuming bessie as the first cow
        boolean lastTogether = true;//they are together at the starting position
        int bessieEnd = 0, elsieEnd = 0;

        while(!(b==0 && e == 0 && bessieEnd == 0 && elsieEnd == 0)){//white atleast one of them have available lines

            if(b > 0 || bessieEnd != 0) {//if bessie had not exhausted her lines
                if (bessieEnd == 0) {
                    bessieEnd = findNextEnd(input1);
                    b--;
                }
                if (bessieEnd > 0) {
                    distanceBetween++;
                    bessieEnd--;
                } else if(bessieEnd < 0){
                    distanceBetween--;
                    bessieEnd++;
                }
            }

            if(e > 0 || elsieEnd != 0) {//if elsie has not exhausted her movements
                if (elsieEnd == 0) {
                    elsieEnd = findNextEnd(input2);
                    e--;
                }
                if (elsieEnd > 0) {
                    distanceBetween--;
                    elsieEnd--;
                } else if(elsieEnd < 0) {
                    distanceBetween++;
                    elsieEnd++;
                }
            }
            if(distanceBetween != 0) lastTogether = false;
            else if(!lastTogether) {
                moo++;
                lastTogether = true;
            }
        }

        output.print(moo);
        output.close();
    }
}
