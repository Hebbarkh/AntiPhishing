import java.util.Scanner;
class QuickSort{
	void quickSort(int[] arr,int low,int high){
		if(low<high){
			int p = pivot(arr,low,high);
			quickSort(arr,low,p-1);
			quickSort(arr,p+1,high);
		}
	}
	int pivot(int[] arr,int l, int h){
		int i = l+1;
		int j = h,temp;
		int pivot = arr[l];
		while(true){
			while(i<=j && arr[i] <= pivot) i++;
			while(i<=j && arr[j] >= pivot) j--;
			if(j<i)break;
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			
		}
		arr[l] = arr[j];
		arr[j] = pivot;
		return j;
	}
	public static void main(String args[]){
		QuickSort qsort = new QuickSort();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter Array elements:");
		for(int i = 0;i<n;i++)
			arr[i] = in.nextInt();
		qsort.quickSort(arr,0,n-1);
		System.out.println("Sorted array:");
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
	}
}
