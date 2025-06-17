import java.io.*;
import java.util.*;
public class StudentFileIO{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		try{
			BufferedWriter bw=new BufferedWriter(new FileWriter("Student2.txt"));
			System.out.println("Enter No of Sudents");
			int count=in.nextInt();
			in.nextLine();
			for(int i=1;i<=count;i++){
				System.out.println("Enter name of the student"+i+":");
				String name=in.nextLine();
				bw.write(name);
				bw.newLine();
			}
			bw.close();
			System.out.println("\nRading students names from the file");
			BufferedReader br=new BufferedReader(new FileReader("Student2.txt"));
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