import java.util.Scanner;

class HeapSort{
	public static void heapifyBottom(int[] arr,int i){
		int max = arr[i];
		int j=i;
		while(i>0 && max > arr[(i-1)/2]){
			arr[i] = arr[(i-1)/2];
			i = (i-1)/2;
		}
		arr [i] = max;
	}
	public void HeapifyUp(int[] arr,int n){
		int max,i=0,temp;
		while(true){
			max = i;
			if(i+1 < n && arr[i+1]>arr[max])
				max = i+1;
			if(i+2 < n && arr[i+2] > arr[max])
				max = i+2;
			if(i == max)
				break;
			temp = arr[max];
			arr[max] = arr[i];
			arr[i] = temp;
			i = max;
		}
	}

	public void heapSort(int arr[]){
		int n = arr.length;
		int temp;
		for(int i=n-1;i>0;i--){
			temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			HeapifyUp(arr,i);
		}
	}
				 
	public static void main(String args[]){
		HeapSort sort = new HeapSort();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter Array elements:");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		for(int x=0;x<arr.length;x++){
			sort.heapifyBottom(arr,x);
		}		
		sort.heapSort(arr);
		System.out.println("Sorted Array:");
		for(int x:arr)
			System.out.print(x+" ");
	}
}
