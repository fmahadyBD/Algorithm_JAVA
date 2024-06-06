package KMP;

/*
 * The Knuth-Morris-Pratt (KMP) algorithm is a classic string-matching 
 * algorithm that searches for occurrences of a "pattern" within a "text" 
 * efficiently. The KMP algorithm preprocesses the pattern to create a partial
 *  match (also known as "longest prefix suffix" or LPS) array, which is then
 *  used to skip unnecessary comparisons in the text.
 */




public class KMPAlgorithm {

    // Function to search for a pattern in the given text using KMP algorithm
    public static void KMPSearch(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();

        // Create lps[] that will hold the longest prefix suffix values for the pattern
        int[] lps = new int[M];
        int j = 0; // index for pattern

        // Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pattern, M, lps);

        int i = 0; // index for text
        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }

    // Function to compute the LPS array
    private static void computeLPSArray(String pattern, int M, int[] lps) {
        int length = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // Loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPSearch(pattern, text);
    }
}

