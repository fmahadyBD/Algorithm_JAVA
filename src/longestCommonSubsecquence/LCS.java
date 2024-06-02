package longestCommonSubsecquence;

public class LCS {

    public static int lcs(char a[], char b[], int i, int j) {

        if (i == 0 || j == 0)
            return 0;

        // for same charecter add 1 and call the next
        if (a[i - 1] == b[j - 1])
            return 1 + lcs(a, b, i - 1, j - 1);

        // Retun the maximun value of left or top
        else
            return Math.max(lcs(a, b, i, j - 1), lcs(a, b, i - 1, j));
    }

    public static void main(String[] args) {
        String X = "BDCB";
        String Y = "BACDB";
        char[] a = X.toCharArray();
        char[] b = Y.toCharArray();
        int i = a.length;
        int j = b.length;
        System.err.println("The logest common subsequence: " + lcs(a, b, i, j));
    }
}
