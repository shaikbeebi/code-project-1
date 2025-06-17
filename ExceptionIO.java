import java.io.*;
import java.util.*;
public class ExceptionIO{
	public static void main(String[] args){
		try(BufferedReader br=new BufferedReader(new FileReader("data.txt"));){
			String line;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}