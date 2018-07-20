import java.util.Scanner;

class MergeSort{
	public void mergeSort(int arr[],int first,int last){
		if(first >= last)return;
		int m = (first+last)/2;
		mergeSort(arr,first,m);
		mergeSort(arr,m+1,last);
		merge(arr,first,m,last);
	}
	public void merge(int arr[],int f,int m,int l){
		int n1 = m-f+1;
		int n2 = l-m;
		int a[] = new int[n1];
		int b[] = new int[n2];
		int j=0,k=0,i=f;
		for(i=f;i<=m;i++)
			a[j++] = arr[i];
		j=0;
		for(i=m+1;i<=l;i++)
			b[j++] = arr[i];
		j=0;
		i=f;
		while(j<n1 && k < n2){
			if(a[j]>b[k]){
				arr[i] = b[k++];
			}
			else
				arr[i] = a[j++];
			i++;	
		}
		
		while(j<n1)
			arr[i++] = a[j++];
		while(k<n2)
			arr[i++] = b[k++];
		
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		MergeSort sort = new MergeSort();
		System.out.print("Enter n:");
		int n = in.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements:");
		for(int i=0;i<n;i++)
			arr[i] = in.nextInt();
		sort.mergeSort(arr,0,n-1);
		System.out.println("Sorted array:");
		for(int x:arr)
			System.out.print(x+" ");
		System.out.println();
	}
}
		
		
