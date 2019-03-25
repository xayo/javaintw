package org.xayo.sort;

import java.util.Arrays;

/**
 * Divide it into two halves, sort the two halves (recursively),
 * and then merge the results.
 */
public class Merge{

    public void sort(int data[]){
        //System.out.println(">> unsorted: "+Arrays.toString(data));
        split(data);
        //System.out.println("<< sorted: "+Arrays.toString(data));
    }  

    public void split(int data[]){
        int len = data.length;
        if(len>1){
            int mid = len/2;
            int[] arrLo = Arrays.copyOfRange(data,0,mid);
            int[] arrHi = Arrays.copyOfRange(data,mid,len);
            split(arrLo);
            split(arrHi);
            merge(data, arrLo, arrHi);
        }
    }

    public void merge(int[] arrRes, int[] arrLo, int[] arrHi){
        int lo=0;
        int hi=0;
        for(int i=0;i<arrRes.length;i++){
            if(lo >= arrLo.length) arrRes[i] = arrHi[hi++];
            else if (hi >= arrHi.length) arrRes[i] = arrLo[lo++];
            else if(arrLo[lo]<arrHi[hi]) arrRes[i] = arrLo[lo++];
            else arrRes[i] = arrHi[hi++];
        }
    }
}//class

/**
 * Brainstorming process: 
 * Assumption: - it is an int array, it is not empty or null, has more than 3 elements, is not sourted
 * 
 * ex arr: 4, 83, 2, 38, 7, 65, 2, 34, 0, 9
 * length = 10
 * split/2 = 5
 * -> 4, 83, 2, 38, 7
 * length = 5
 * split/2
 * -> 2, 38, 7 (and 4, 83)
 * length = 3
 * split/2
 * -> 38, 7 (and 2)
 * length = 2
 * length=<2 (no split)
 * -> sort
 *  7, 38 and 2
 * -> merge
 */