import java.io.*;
import java.util.*;
public class ScannerIO{
	public static void main(String[] args)throws IOException{
		Scanner in=new Scanner(new File("data.txt"));
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
		}
		in.close();
	}
}