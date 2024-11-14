package ar.edu.unlp.info.oo1.ejercicio16;

import junit.framework.TestCase;

public class EvenNumberSetTest extends TestCase
{
    EvenNumberSet set;

    public void setUp() throws Exception
    {
        set = new EvenNumberSet();
    }

    public void testAdd()
    {
        assertTrue(set.add(2));
        assertTrue(set.add(4));
        assertFalse(set.add(3));
        assertFalse(set.add(5));
    }
}