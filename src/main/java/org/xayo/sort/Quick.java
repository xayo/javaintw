package org.xayo.sort;

import java.util.Arrays;

/**
 * Quick sort - partitioning an array into two subarrays, then sorting the subarrays independently.
 * Re-arrange the array such that, when the two subarrays are sorted, the whole array is ordered
 */
public class Quick{

    public void sort(int[] data){
        //System.out.println(">> unsorted: "+Arrays.toString(data));
        split(data);
        //System.out.println("<< sorted: "+Arrays.toString(data));
    }//

    public void split(int data[]){
        int len = data.length;
        if(len>2){
            int[] arr = new int[len];
            int midIx = (len/2)-1;
            int lo = 0, hi=len;
            
            for(int i=0;i<len;i++){
                if(i==midIx) continue;
                else if(data[i]>data[midIx]) arr[--hi]=data[i];
                else arr[lo++] = data[i];
            }//for
            arr[lo]=data[midIx];
            int[] arrLo = Arrays.copyOfRange(arr,0,lo+1);
            int[] arrHi = Arrays.copyOfRange(arr,hi,len);
            
            split(arrLo); split(arrHi);
            merge(data, arrLo, arrHi);
        }else if(len==2){ //Ugly Hack for code line 21! :/
            if(data[0]>data[1]){
                int tmp = data[0];
                data[0] = data[1];
                data[1] = tmp;
            }
        }  
    }//split

    private void merge(int[] arrRes, int[] arrLo, int[] arrHi){
        int lenRes = arrRes.length;
        int lenLo = arrLo.length;
        for(int i=0;i<lenRes;i++){
            if(i<lenLo) arrRes[i] = arrLo[i];
            else arrRes[i] = arrHi[i-lenLo];
        }
    }//merge
}//class

/**
 * Brainstorming process: 
 * Assumption: - it is an int array, it is not empty or null, has more than 3 elements, is not sourted
 * ex arr: 4, 83, 2, 38, 7, 65, 2, 34, 0, 9
 * Note!!! - try to implement this with in place array
 * 
 * Problem 1: Size of the slip arrays is unknown so one needs a dynamic structure.
 * To avoid this create an array with the one from the original and start filling from bot ends.
 * Solution example:
 *  4, 83, 2, 38, 7 | 65, 2, 34, 0, 9
 *  MID:7
 *  4 ........ 83
 *  4 2 ...... 38 83
 *  4 2 2 0 7  9 34 65 38 83 lo=0 - 5, hi= 6
 * 
 * Step-by-step process review.
 * ======
 * -> split the array divede by 2 and take mid element
 *      4, 83, 2, 38, 7 | 65, 2, 34, 0, 9
 *  -> take 7 as mid element
 *      -> ittereate over elements if elem > 7 go to A else to B
 *      MID: 7
 *      A: 4, 2, 2, 0
 *      B: 83, 38, 65, 34, 9
 *      add MID - 7 to A: 4, 2, 2, 0, 7
 * 
 * -> step 2
 *      split A/2 MID:2
 *      A1: 2,0,2
 *      A2: 4,7
 * 
 *      split B/2 MID: 38
 *      B1: 34, 9, 38
 *      B2: 83, 65
 * 
 * -> step 3:
 *      split A1/2 MID: 2
 *      A11:0,2,2
 *      A12: null
 * 
 *      split A2/2 MID: 4
 *      A21:4
 *      A22:7
 * 
 * End of split if arr.length is 1 or one of the slip arrays is length 0
 * 
 * merge steps
 *  Merge: A2 = A21 + A22 = 4,7
 *  Merge: A1 = A11 + A12 = 0,2,2 + null
 *  Merge: A = A1 + A2 = 0,2,2,4,7
 *  Order of merging is important!!!
 */