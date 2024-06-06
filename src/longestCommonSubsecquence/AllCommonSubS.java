package longestCommonSubsecquence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AllCommonSubS {

    static HashMap<String,Integer> subSequenceLength=new HashMap<>();
    static HashSet<String> subSequenceSet=new HashSet<>();
    public static void findAllCommonSubSequwnces(String x,String y, int n,int m,String subSeq,int lenght){
        if(n==m) {
            subSequenceLength.put(subSeq, lenght);
            subSequenceSet.add(subSeq);
            return;
        }
        if(x.charAt(n-1)==y.charAt(m-1)) findAllCommonSubSequwnces(x,y,n-1,m-1,subSeq+x.charAt(n-1),1+lenght);
        else {
            findAllCommonSubSequwnces(x, y, n-1, m, subSeq, lenght);
            findAllCommonSubSequwnces(x, y, n, m-1, subSeq, lenght);
        }
            

        
    }

    public static void main(String[] args) {
        String x = "ahajhdjashjah";
        String y = "jdaskjdjwhijhsjkfn";
        findAllCommonSubSequwnces(x, y, x.length(), y.length(), "", 0);
        List<String> subSeqList=new ArrayList<>(subSequenceSet);
        

        Collections.sort(subSeqList,(a,b)->subSequenceLength.get(b)-subSequenceLength.get(a));
        Collections.sort(subSeqList,(a,b)->subSequenceLength.get(b)-subSequenceLength.get(a));
        
    }
}
