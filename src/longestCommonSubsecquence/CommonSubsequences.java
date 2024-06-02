package longestCommonSubsecquence;
import java.util.*;


public class CommonSubsequences {

    static HashSet<String> subSeqSet = new HashSet<>(); // To store unique subsequences
    static HashMap<String, Integer> subSeqLengthMap = new HashMap<>(); // To store the length of each subsequence

    // Recursive function to find all common subsequences
    public static void findCommonSubsequences(String s1, String s2, int m, int n, String subSeq, int length) {
        if (m == 0 || n == 0) {
            // Add the subsequence to the set along with its length
            subSeqSet.add(subSeq);
            subSeqLengthMap.put(subSeq, length);
            return;
        }

        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            // If characters match, include them in the subsequence and recurse for the remaining strings
            findCommonSubsequences(s1, s2, m - 1, n - 1, s1.charAt(m - 1) + subSeq, length + 1);
        } else {
            // If characters don't match, recurse by excluding one character at a time
            findCommonSubsequences(s1, s2, m - 1, n, subSeq, length);
            findCommonSubsequences(s1, s2, m, n - 1, subSeq, length);
        }
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        findCommonSubsequences(s1, s2, s1.length(), s2.length(), "", 0);

        // Convert the set of subsequences to a list for sorting
        List<String> subSeqList = new ArrayList<>(subSeqSet);

        // Sort the list based on the lengths of the subsequences in descending order
        Collections.sort(subSeqList, (a, b) -> subSeqLengthMap.get(b) - subSeqLengthMap.get(a));

        // Print the sorted subsequences along with their lengthsz
        for (String subSeq : subSeqList) {
            System.out.println("Subsequence: " + subSeq + ", Length: " + subSeqLengthMap.get(subSeq));
        }
    }
}
