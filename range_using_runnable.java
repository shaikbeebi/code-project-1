package xyz;
class Range implements Runnable{
	public void run() {
		for(int i=1;i<=3;i++) {
		System.out.println("car moving"+i);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}
}
class Jeep implements Runnable{
	public void run() {
		for(int i=1;i<=3;i++) {
		System.out.println("bike moving"+i);
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	}
}
public class Simple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread c=new Thread(new Range());
		Thread b=new Thread(new Jeep());
		c.start();
		b.start();
	}

}