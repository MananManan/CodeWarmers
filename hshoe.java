/*
ID: manman2a
PROG: hshoe
LANG: JAVA
*/
import java.util.*;
import java.io.*;

class hshoe {

	public static int longestChain(char[][] hshoes, int row, int column,int left, int right, boolean closing){

		int a,b,c,d;
		a = b = c = d = 0;

		char temp = hshoes[row][column];//store the horse shoe
		hshoes[row][column] = 'x';//pick the horse shoe up

		//check if the horse shoe is valid
		if(temp == '('){
			if(!closing) left++;
			else return 0;
		}
		else if(temp == ')') {
			right++;
			if(!closing) closing = true;
		}
		else{
			return 0;
		}

		//fill and check these
		if(row < hshoes.length-1) {//move down
			temp = hshoes[row+1][column];
			a = longestChain(hshoes,row + 1, column,left,right,closing); //go down
			hshoes[row+1][column] = temp;//filling the shoe when moving out of recursion
		}

		if(column < hshoes.length-1) {//move right
			temp = hshoes[row][column + 1];
			b = longestChain(hshoes, row, column + 1,left,right,closing); //go right
			hshoes[row][column + 1] = temp;
		}

		if(column > 0) {//move left
			temp = hshoes[row][column - 1];
			c = longestChain(hshoes, row, column - 1,left,right,closing); //go left
			hshoes[row][column - 1] = temp;
		}

		if(row > 0) {//move up
			temp = hshoes[row - 1][column];
			d = longestChain(hshoes, row - 1, column,left,right,closing); //go up
			hshoes[row - 1][column] = temp;
		}

		if(left == right) return (left + right);
		else{
			return Math.max(Math.max(a,b),Math.max(c,d));
		}
	}

	public static void main(String[] args) throws Exception {
		Scanner input = new Scanner(new File("hshoe.in"));
		PrintWriter output = new PrintWriter("hshoe.out");

		int N = input.nextInt();
		char[][] hshoes = new char[N][N];

		input.nextLine();

		//filling the array
		for(int i = 0; i < N; i++){
			String s = input.nextLine();
			for(int j = 0; j < N; j++){
				hshoes[i][j] = s.charAt(j);
			}
		}

		output.print(longestChain(hshoes,0,0,0,0,false));
		output.close();
	}
}
