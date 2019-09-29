import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fivaa {

	public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String in = input.readLine();
        fivaa(Integer.parseInt(in));
	}
	
	public static void fivaa(int number) {
		String firstLetters = null;
		String lastLetters = null;
		int temp = number;
		for (int i=0; i<number; i++) {
			firstLetters = new String(new char[2]).replace("\0", Integer.toString(temp-1));
			lastLetters = new String(new char[temp]).replace("\0", Integer.toString(temp+1));
			System.out.println(firstLetters + lastLetters);
			temp -= 1;
		}
	}
}