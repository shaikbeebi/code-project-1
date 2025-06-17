package xyz;
class Car implements Runnable{
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
class Bike1 implements Runnable{
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
public class SimpleRace1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread c=new Thread(new Car());
		Thread b=new Thread(new Bike1());
		c.start();
		b.start();
	}

}