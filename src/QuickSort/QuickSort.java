package QuickSort;
public class QuickSort {
    public static int partision(int arr[],int low,int high){

        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
       

        }
        //previous loop will sort all low value 0-i (by pivot). now sawp by pivot(in high)
        //
        i++;
        int temp=arr[i];
        arr[i]=arr[high];
        arr[high]=temp;
        return i;
    }
    public static void Qsort(int arr[],int low,int high){

        if(low>high) return;
        int pivotIndx=partision(arr,low,high);
        Qsort(arr, low, pivotIndx-1);
        Qsort(arr, pivotIndx+1, high);
    }
    public static void main(String[] args) {
        int arr[]={9,8,3,4,5,1,0};
        int n=arr.length;
        Qsort(arr, 0, n-1);
        //print
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
