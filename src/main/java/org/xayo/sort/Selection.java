package org.xayo.sort;

import java.util.Arrays;

/**
 * Sample Selection Sort Description: First, find the smallest item in the array
 * and exchange it with the first entry (itself if the first entry is already
 * the smallest). Then, find the next smallest item and exchange it with the
 * second entry. Continue in this way until the entire array is sorted.
 */
public class Selection {

    public Selection(){
    }

    public int[] sort(int[] data) throws Exception {
        //make all validation checks that input data is OK to be sorted
        //System.out.format("Selection sort constructor %n");
        //System.out.format("Sorting "+ Arrays.toString(data));
        if(data.getClass().isArray() && data instanceof int[]){
            //actual sort
            this.sortIntArr(data);
        }else{
            throw new Exception("Input data is not array or array of type int[]");
        }
        //System.out.println("Sorted: "+ Arrays.toString(data));
        return data;
    }//sort

    private int[] sortIntArr(int[] data){
        int[] sorted = null;
        int arrLength = data.length;

        for(int ord=0;ord<arrLength;ord++){
            for(int iter=ord+1;iter<arrLength;iter++){
                if(data[ord] > data[iter]) swapIntArr(data, ord, iter);
            }
        }
        return sorted;
    }

    private void swapIntArr(int data[], int ordIx, int iterIx){
        int tmpVal= data[ordIx];
        data[ordIx]=data[iterIx];
        data[iterIx] = tmpVal;
    }

}//class