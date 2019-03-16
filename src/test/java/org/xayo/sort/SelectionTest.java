package org.xayo.sort;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class SelectionTest {
    // unsorted array
    private int[] sortedArr = {0, 2, 2, 4, 7, 9, 34, 38, 65, 83};
    private int[] notSortedArr = {4, 83, 2, 38, 7, 65, 2, 34, 0, 9};
    //
    private int[] dataEmpty = {};
    private int[] dataOneElement = {5};
    private final Selection select = new Selection();

    @Test
    void sortTest() {
        try {
            int[] result = select.sort(notSortedArr);
            assertTrue(this.isSorted(result));
        } catch (Exception e) {
            fail("Sorting test failed unexpectedly: " + e.getMessage());
        }
    }
    
    @Test
    void sortEmptyArrTest() {
        try {
            select.sort(this.dataEmpty);
            fail("Null array should trow Exceptionß");
        } catch (Exception e) {
            assertTrue(true);
        }
    }

    @Test
    void sortdataOneElementTest() {
        try {
            int[] result = select.sort(this.dataOneElement);
            assertTrue(this.isSorted(result));
        } catch (Exception e) {
            fail("Sorting test failed unexpectedly: " + e.getMessage());
        }
    }

    @Test
    void isSortedTest(){
        assertTrue(this.isSorted(this.sortedArr));
    }

    @Test
    void isSortedOneElementTest(){
        assertTrue(this.isSorted(this.dataOneElement));
    }

    @Test
    void isSortedEmptyTest(){
        assertTrue(this.isSorted(this.dataEmpty));
    }

    @Test
    void isSortedFailTest(){
        assertFalse(this.isSorted(this.notSortedArr));
    }

    private boolean isSorted(int[] data){
        int arrLength = data.length;
        if(arrLength>1)
            for(int i=1;i<arrLength;i++)
                if(data[i-1]>data[i])
                    return false;
        return true;
    }
}
