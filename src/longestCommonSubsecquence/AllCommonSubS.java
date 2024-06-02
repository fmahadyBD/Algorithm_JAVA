package longestCommonSubsecquence;

import java.util.HashMap;
import java.util.HashSet;

public class AllCommonSubS {

    static HashSet<String> subSequenceSet = new HashSet<>();
    static HashMap<String, Integer> subSequenceLenghtMap = new HashMap<>();

    public static void findAllCommonSubSequwnces(String a, String b, int i, int j, String subSeq, int length) {
        if (i == 0 || j == 0) {
            subSequenceSet.add(subSeq);
            subSequenceLenghtMap.put(subSeq,length);

        }
        if( a.charAt(i-1)== b.charAt(j-1)){
            findAllCommonSubSequwnces(a, b, i-1, j-1,a.charAt(i-1)+ subSeq,1+ length);

        
        }
        else{
            findAllCommonSubSequwnces(a, b, i-1, j, subSeq, length);
            findAllCommonSubSequwnces(a, b, i, j-1, subSeq, length);

        }
    }

    public static void main(String[] args) {
        String x = "ahajhdjashjah";
        String y = "jdaskjdjwhijhsjkfn";
        findAllCommonSubSequwnces(x, y, x.length(), y.length(), "", 0);
    }
}
