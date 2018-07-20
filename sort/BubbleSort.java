import java.util.*;

public class BubbleSort{
	public static void bubbleSort(int arr[],int n){
		int temp;
		for(int i=0;i<n;i++)
			for(int j=0;j<n-i-1;j++)
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}
	}
	public static void main(String args[]){
		int n;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter n:");
		n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		bubbleSort(arr,n);
		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++)
			System.out.print(arr[i]+" ");
		System.out.println("\n");
	}
}
