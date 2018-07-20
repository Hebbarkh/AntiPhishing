import java.util.*;
import java.io.*;
class SelectionSort{
	public static void selectionSort(int arr[],int n){
		int temp;
		for(int i=0;i<n-1;i++)
			for(int j=i+1;j<n;j++)
				if(arr[j]<arr[i]){
					temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
	}
	public static void main(String args[]) throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n:");
		int n = Integer.parseInt(in.readLine());
		int arr[] = new int[n];
		System.out.println("Enter "+n+" elements(each in new line)");
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(in.readLine());
		selectionSort(arr,n);
		System.out.println("Sorted Array:");		
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
	}
}
		
