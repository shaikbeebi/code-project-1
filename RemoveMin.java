import java.util.*;
public class RemoveMin{
	private ArrayList<Integer> heap;
	public RemoveMin(){
		heap=new ArrayList<>();
	}
	private void swap(int i,int j){
		int temp=heap.get(i);
		heap.set(i,heap.get(j));
		heap.set(j,temp);
	}
	public void insert(int val){
		heap.add(val);
		int i=heap.size()-1;
		while(i>0 && heap.get(i) <heap.get((i-1)/2)){
			swap(i,(i-1)/2);
			i=(i-1)/2;
		}
	}
	public void removeMinAll(){
		while(heap.size()!=0){
			 int min = heap.get(0);
			System.out.println(min);
			if (heap.size() == 1) {
				heap.remove(0);
			} else {
				heap.set(0, heap.remove(heap.size() - 1));
				heapify(0);
			}
			System.out.println(heap);
		}	
	}
	private void heapify(int i){
		int smallest=i;
		int l=2*i+1;
		int r=2*i+2;
		if(l<heap.size() && heap.get(l)<heap.get(smallest)) smallest=l;
		if(r<heap.size() && heap.get(r)<heap.get(smallest)) smallest=r;
		if(smallest != i){
			swap(i,smallest);
			heapify(smallest);
		}
	}
	public void print(){
		System.out.println(heap);
	}
	public static void main(String[] args){
		RemoveMin mh=new RemoveMin();
		int[] values={10,4,15,20,0,5,2};
		for(int val:values){
			mh.insert(val);
		}
		System.out.println("MinHeap array after insertion:");
		mh.print();
		System.out.println("MinHeap removing all:");
		mh.removeMinAll();
	}
}