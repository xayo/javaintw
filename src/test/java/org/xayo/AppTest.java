package org.xayo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class AppTest{

    App app = new App();
    
    String intArrStr = "3,2,6,23,4,234,-2,0";
    String charArrStr = "1,a, ,3";
    String helloWorldStr = "Hello World";

    @Test
    void mainTest() {
        String[] args = {"3,2,6,23,4,234,-2,0"}; 
        App.main(args);
    }

    @Test
    void goodStrTest() {
        int[] result = app.strToIntArr(intArrStr);
        if(result.length == 8)
            assertTrue(true);
        else
            fail("String not parsed correctly");
    }
    @Test
    void intCharTest() {
        int[] result = app.strToIntArr(charArrStr);
        if(result.length == 2)
            assertTrue(true);
        else
            fail("Mixed string not parsed correctly");
    }

    @Test
    void nullstrTest() {
        int[] result = app.strToIntArr(null);
        if(result.length == 0)
            assertTrue(true);
        else
            fail("Null string not parsed correctly");
    }

    @Test
    void strTest() {
        int[] result = app.strToIntArr(helloWorldStr);
        if(result.length == 0)
            assertTrue(true);
        else
            fail("Null string not parsed correctly");
    }
}//