package org.xayo.sort;

import java.util.Arrays;

/**
 * Re-arrange the array to give it the property that taking every hth entry (starting anywhere) 
 * yields a sorted subsequence. Such an array is said to be h-sorted. Put another way, 
 * an h-sorted array is h independent sorted subsequences, interleaved together. 
 * By h-sorting for some large values of h, we can move items in the array long distances and thus 
 * make it easier to h-sort for smaller values of h. Using such a procedure for any sequence of 
 * values of h that ends in 1 will produce a sorted array: that is shellsort.
 */
public class Shell {
    private int N = 4;

    public Shell(int step){
        this.N = step;
    }

    public void sort(int data[]){
 //       System.out.println(">> unsorted: "+Arrays.toString(data));
        int len = data.length;
        while(N>0){
//            System.out.println("N= "+N);
            for(int step=0;step<N;step++){
                for(int ix=step; ix < len; ix=ix+N){
                //System.out.print(data[ix]+" "); 
                    for(int j=step; j<ix; j=j+N)
                        if(data[j]>data[ix]){
                            move(data,j,ix,N);
                            break;
                        }
                }//for ix
                //System.out.println();
            }//for step
            N--;
        }//while N
//        System.out.println("<< sorted: "+Arrays.toString(data));
    }//sort

    private void move(int data[], int start, int end, int order){
        //System.out.println("Replace: " + data[start] + " with " + data[end]);
        //System.out.println(Arrays.toString(data));
        int reg = data[end];
        for(int mv=end;mv>start;mv=mv-order)
            data[mv] = data[mv-order];
        data[start] = reg;
        //System.out.println(Arrays.toString(data));
    }

}//class


/** 
 * Brainstorming process: 
 * Assumption: - it is an int array, it is not empty or null, has more than 3 elements, is not sourted
 *  4, 83, 2, 38, 7, 65, 2, 34, 0, 9
 -> N=4, arr length = 10
    4 . . . 7 . . . 0 .
    . 83. . . 65 . . . 9
    . . 2 . . . 2 . . .
    . . . 38 . . . 34 . .
  Turn in to 4 h sorted array
  0 9 2 34 4 65 2 38 7 83
 -> N=3
  0 . . 34 . . 2 . . 83
  . 9 . . 4 . . 38 . .
  . . 2 . . 65 . . 7 .
  0 4 2 2 9 7 34 38 65 83
 -> N = 2
  0 . 2 . 9 . 34 . 65 .
  . 4 . 2 . 7 . 38 . 83

  0 2 2 4 (9 7) 34 38 65 83
 */