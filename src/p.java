public class p {
    public static void con(int arr[], int si, int mid, int ei) {
        int mar[] = new int[ei - si + 1];
        int indx1 = si;
        int indx2 = mid + 1;
        int x = 0;
        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2])
                mar[x++] = arr[indx1++];
            else
                mar[x++] = arr[indx2++];

        }
        while (indx1 <= mid) {
            mar[x++] = arr[indx1++];
        }
        while (indx2 <= mid) {
            mar[x++] = arr[indx2++];
        }
        for (int i = 0, j = si; i < mar.length; i++, j++) {
            arr[j] = mar[i];
        }
    }

    public static void dev(int arr[], int si, int ei) {
        if (si >= ei)
            return;
        int mid = si + (ei - si) / 2;
        dev(arr, si, mid);
        dev(arr, mid + 1, ei);
        con(arr, si, mid, ei);

    }

    public static void main(String[] args) {
        int arr[] = { 8, 7, 6, 5, 4, 3, 2, 1 };
        int n = arr.length;
        int si = 0;
        dev(arr, si, n-1);
        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println("");
    }
}
