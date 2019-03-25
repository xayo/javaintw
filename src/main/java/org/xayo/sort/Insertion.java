package org.xayo.sort;

import java.util.Arrays;

/**
 * Insertion sort - computer implementation, we need to make space to insert the
 * current item by moving larger items one position to the right, before
 * inserting the current item into the vacated position
 */
public class Insertion{

    public void sort(int[] data){
        //System.out.println("Unsorted: "+Arrays.toString(data));
        int len = data.length;
        for(int ix=1; ix < len; ix++)
            for(int j=0; j<ix; j++) 
                if(data[j]>data[ix]){
                    move(data,j,ix);
                    break;
                }
        //System.out.println("Sorted: "+Arrays.toString(data));
    }//sort

    private void move(int data[], int start, int end){
        //System.out.println("Replace: " + data[start] + " with " + data[end]);
        //System.out.println(Arrays.toString(data));
        int reg = data[end];
        for(int mv=end;mv>start;mv--)
            data[mv] = data[mv-1];
        data[start] = reg;
        //System.out.println(Arrays.toString(data));
    }
}//class

/**
 * Brainstorming process: 
 * Assumption: - it is an int array, it is not empty or null, has more than 3 elements, is not sourted
 *  4, 83, 2, 38, 7, 65, 2, 34, 0, 9
 *  ix - where we are
 *  ix = 0, val = 4,
 *  ix = 1, val = 83, compare to arr[0]=4 not smaller than 83
 *  ix = 2, val = 2, compare to arr[0]=4 is smaller (2)
 *      -> move to right(1) and insert (in cmpIx).
 *      result -> 2,4,83,38,7,65,2,34,0,9
 *  ix = 3, val = 38, compare to arr[0]2, arr[1]4, arr[2]83 hit (38 is less than 83)
 *      -> move to right from cmpIx = 2 to ix = 3, insert in cmpIx
 *      result -> 2, 4, 38, 83, 7 ...
 * 
 * Implementation approach
 * Loop 1 to go over all elements in the array.
 *  -> Loop 2 to start sorting
 * helper methods
 *  mvRight() // moves section of an array with one slot to the right
 *  insert () // inserts a value in the empty slot
 * 
 * moveRight() helper method
 *   ex: 2,4,38,83,7,65,2,34,0,9 - move data[4] = 7 to data[2] = 38 and shift data[2-3] to right
 *  exp: 2,4,7,38,83,65,2,34,0,9
 */