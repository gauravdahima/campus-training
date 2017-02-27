import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MaximumPathSum {

	public static void main(String args[]) throws IOException{
	
			FileReader fr = new FileReader("/home/gd/Downloads/triangle.txt");
			BufferedReader br = new BufferedReader(fr);
			Scanner tokens = null;
			String str;
			int i = 0, rows = 100;
			int[][] triangle = new int[rows][];;
			while ((str = br.readLine()) != null) {
				triangle[i] = new int[i+1];
				int j = 0;
				tokens = new Scanner(str);
				while (tokens.hasNext()) {
					int value = tokens.nextInt();
					triangle[i][j++] = value;
				}
				i++;
			}
			
			tokens.close();
			br.close();
			
			for (i = triangle.length - 2; i >= 0; i--) {
				for (int j = 0; j < triangle[i].length; j++)
					triangle[i][j] += Math.max(triangle[i+1][j],triangle[i+1][j+1]);
			}
			System.out.println("Maximum total : " + triangle[0][0]);
			
		}
}