package org.xayo;

import java.util.ArrayList;
import java.util.Arrays;

import org.xayo.sort.Selection;

public class App {
    public static void main(String[] args) {
        if (args[0] != null) {
            App app = new App();
            Selection sort = new Selection();
            //
            int[] intArr = app.strToIntArr(args[0]);
            int[] result;
            try {
                result = sort.sort(intArr);
                System.out.println(Arrays.toString(result));
            } catch (Exception e) {
                System.err.println("Sorting failed: "+e.getMessage());
            }
        }else{
            System.out.println("Please add as argument coma separated integer values.");
            System.out.println("Example argument: 3,2,6,23,4,234,-2,0");
        }   
    }

    public int[] strToIntArr(String input){
        int[] result = new int[0];
        String[] strArr = new String[0];
        if(input!=null)
            strArr = input.split(",");
        if(strArr.length!=0){
            ArrayList<Integer> arrList = new ArrayList<Integer>();
            for(String str: strArr){
                try {
                    int i = Integer.parseInt(str);
                    arrList.add(i);
                } catch (NumberFormatException e) {
                    System.err.println(str + " is not an int - removing from output array");
                }
            }
            if(!arrList.isEmpty()){
                result = new int[arrList.size()];
                int count = 0;
                for (Integer v : arrList){
                    result[count]= v.intValue();   
                    count++;
                }
            }
        }   
        return result;
    }
}
