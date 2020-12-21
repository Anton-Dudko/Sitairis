import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {

    @org.junit.Test
    public void sum() {
        Numbers numbers = new Numbers();
        int actual = numbers.sum(5);
        int expected = 15;
        assertEquals(expected, actual);
    }

    @Test
    public void createNumbersClass(){
        Numbers numbers = new Numbers();
    }

    @org.junit.Test
    public void result() {
        Numbers numbers = new Numbers();
        int actual = numbers.sum(53, 25);
        int expected = 78;
        assertEquals(expected, actual);
    }


}