import java.io.*;
public class FileDemo{
	public static void main(String[] args){
		try{
			BufferedWriter bw=new BufferedWriter(new FileWriter("Student.txt"));
			bw.write("Alice\nBOb\nCharlie");
			bw.close();
			BufferedReader br=new BufferedReader(new FileReader("Student.txt"));
			System.out.println("Student names:");
			String line;
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
}