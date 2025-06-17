public class BubbleSort{
	public static int bubbleSort(int[] arr){
		int n=arr.length;
		int swapcount=0;
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapcount++;
				}
			}
		}
		return swapcount;
	}
	public static void main(String[] args){
		int[] arr={5,1,4,3,6,2};
		System.out.println("Before sorting:");
		for(int num:arr)
			System.out.print(num+" ");
		System.out.println("\nAfter sorting:");
		int count=bubbleSort(arr);
		for(int num:arr)
			System.out.print(num+" ");
		System.out.println("\nSwap Count:"+count);
	}
}