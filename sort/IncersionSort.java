import java.util.Scanner;

class IncersionSort{
	void incersionSort(int[] arr){
		int t,j=0;
		for(int i=1;i<arr.length;i++){
			t = arr[i];
			j = i-1;
			while(j>=0 && arr[j] > t){
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = t;
		}
	}
	public static void main(String args[]){
		IncersionSort sort = new IncersionSort();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = in.nextInt();
		int[] arr = new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		sort.incersionSort(arr);
		System.out.println("Sorted array:");
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
	}
}
		
