package languagebasic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.junit.Assert.*;

public class ArrayPreviousLessTest {

    @Before
    public void runBeforeTest(){
        System.out.println("Start testing the ArrayPreviousLess.");
    }

    @Test
    public void arrayPreviousLessTest() throws CustomException {
        assertArrayEquals(new int[] {-1, 3, -1, 2, 4},ArrayPreviousLess.arrayPreviousLess(new int[] {3, 5, 2, 4, 5}) );
        assertArrayEquals(new int[] {-1, 10, -1, 6, 6},ArrayPreviousLess.arrayPreviousLess(new int[] {10, 53, 6, 56, 8}) );
    }

    @After
    public void runAfterTest(){
        System.out.println("Finish testing the ArrayPreviousLess.");
    }
}