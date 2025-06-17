package xyz;

public class PriorityThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Thread lowpriorityThread=new Thread(()->{
        for(int i=1;i<=5;i++) {
        	System.out.println("low priority thread"+i);
        }
        });
        Thread HighPriorityThread=new Thread(()->{
        	for(int i=0;i<=5;i++) {
        		System.out.println("High Priority Thread"+i);
        	}
        	});
        lowpriorityThread.setPriority(Thread.MIN_PRIORITY);
        HighPriorityThread.setPriority(Thread.MAX_PRIORITY);
        	lowpriorityThread.start();
        	HighPriorityThread.start();
        }
	}