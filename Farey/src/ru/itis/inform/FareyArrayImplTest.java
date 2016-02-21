package ru.itis.inform;

import static org.junit.Assert.*;

public class FareyArrayImplTest {

    private RationalNumber[] setUp() {
        RationalNumber[] array = new RationalNumber[6];
        array[0] = new RationalNumber(0, 1);
        array[1] = new RationalNumber(1, 3);
        array[2] = new RationalNumber(1, 2);
        array[3] = new RationalNumber(2, 3);
        array[4] = new RationalNumber(1, 1);
        return array;
    }

    @org.junit.Test
    public void testRunFarey() throws Exception {
        FareyArrayImpl sequence = new FareyArrayImpl(3, 6);
        sequence.generate();

        RationalNumber[] actual = sequence.getArray();
        RationalNumber[] expected = setUp();

        assertEquals("Error", expected, actual);
    }
}