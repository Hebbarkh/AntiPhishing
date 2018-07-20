import java.util.Scanner;

class CountingSort{
	public void countingSort(int arr[],int low,int high){
		int count[] = new int[high-low+1];
		for(int x:arr)
			count[x-low]++;
		int j=0;
		for(int i=0;i<=high-low;i++)
			while(count[i]-- != 0)
				arr[j++] = low+i;
	}
	public static void main(String args[]){
		CountingSort sort = new CountingSort();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter Array Elements:");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		System.out.print("Enter Least element:");
		int low = in.nextInt();
		System.out.print("Enter Max element:");
		int high = in.nextInt();
		sort.countingSort(arr,low,high);
		System.out.println("Sorted Array:");
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
	}
}
