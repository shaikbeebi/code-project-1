import java.io.*;
public class BufferDemo{
	public static void main(String[] args)throws IOException{
		BufferedWriter bw=new BufferedWriter(new FileWriter("data.txt"));
		bw.write("First Line");
		bw.newLine();
		bw.write("Second Line");
		bw.close();
		BufferedReader br=new BufferedReader(new FileReader("data.txt"));
		String line;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}