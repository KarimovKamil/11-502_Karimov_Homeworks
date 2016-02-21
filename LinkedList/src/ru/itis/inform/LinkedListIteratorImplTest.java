package ru.itis.inform;

import static org.junit.Assert.*;

public class LinkedListIteratorImplTest {
    private LinkedList<Integer> list;
    private Iterator<Integer> iterator;

    @org.junit.Before
    public void setUp() {
        this.list = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        this.iterator = list.iterator();
    }

    @org.junit.Test
    public void testHasNext() throws Exception {
        assertTrue(iterator.hasNext());
        for (int i = 0; i < 10; i++) {
            iterator.next();
        }
        assertFalse(iterator.hasNext());
    }

    @org.junit.Test
    public void testNext() throws Exception {
        assertEquals(iterator.next(), (Integer) 9);
        assertEquals(iterator.next(), (Integer) 8);
    }

    @org.junit.Test
    public void testPrevious() throws Exception {
        iterator.next();
        iterator.next();
        assertEquals(iterator.previous(), (Integer) 7);
        assertEquals(iterator.previous(), (Integer) 8);
    }

    @org.junit.Test
    public void testPeekNext() throws Exception {
        assertEquals(iterator.peekNext(), (Integer) 8);
        assertEquals(iterator.next(), (Integer) 9);
    }

    @org.junit.Test
    public void testPeekPrevious() throws Exception {
        iterator.next();
        assertEquals(iterator.peekPrevious(), (Integer) 9);
        assertEquals(iterator.previous(), (Integer) 8);
    }

    @org.junit.Test
    public void testInsert() throws Exception {
        iterator.next();
        iterator.insert(11);
        assertEquals(iterator.next(), (Integer) 8);
        assertEquals(iterator.previous(), (Integer) 7);
        assertEquals(iterator.peekPrevious(), (Integer) 11);
        iterator.previous();
        assertEquals(iterator.peekPrevious(), (Integer) 9);
    }
}