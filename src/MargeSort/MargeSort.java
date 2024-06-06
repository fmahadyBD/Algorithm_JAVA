package MargeSort;
public class MargeSort {

    public static void conc(int arr[], int si, int mid, int ei) {
        int marg[] = new int[ei - si + 1];
        int indx1 = si;
        int indx2 = mid + 1;
        int x = 0;// this is for marge arry
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] > arr[indx2]){

                marg[x++] = arr[indx2++];
            }else
            {

                marg[x++] = arr[indx1++];
            }

        }
        while (indx1 <= mid) {
            marg[x++] = arr[indx1++];
        }
        while (indx2<=ei) {
            marg[x++]=arr[indx2++];
            
        }
        //copy
        for(int i=0,j=si;i<marg.length;i++,j++){
            arr[j]=marg[i];
        }

    }

    public static void divide(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid );
        divide(arr, mid + 1, ei);
        conc(arr, si, mid, ei);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 6, 4, 3, 9, 8, 0 };
        int n = arr.length;
        int si = 0;
        divide(arr, 0, n - 1);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]+" ");            
        }
    }

}
