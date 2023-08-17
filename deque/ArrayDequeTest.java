package deque;

import jh61b.junit.In;
import org.junit.Test;

import static org.junit.Assert.*;

/* Performs some basic array deque tests. */
public class ArrayDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * ArrayDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. */

    public static Deque<Integer> ad = new ArrayDeque<Integer>();
    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

		assertTrue("A newly initialized ADeque should be empty", ad.isEmpty());
		ad.addFirst(0);
        assertFalse("ad1 should now contain 1 item", ad.isEmpty());

        ad = new ArrayDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        ad.addFirst(1);
        ad.printDeque();
        ad.removeLast();
        assertTrue(ad.isEmpty());
        ad = new ArrayDeque<Integer>();
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        ad.removeLast();
        ad.removeFirst();
        assertTrue(ad.isEmpty());
        ad = new ArrayDeque<Integer>();
    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        Deque<Character> ad2 = new ArrayDeque<Character>();
        ad2.addFirst('r');
        ad2.addFirst('r');
        ad2.addFirst('r');
        ad2.addFirst('r');
        char a =  ad2.removeFirst();
        assertEquals('r',a);
    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        assertTrue(ad.isEmpty());
        assertNull(ad.removeFirst());
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */
    @Test
    public void add100remove99test(){
        for (int i = 0; i < 100; i++) {
            ad.addLast(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(i == ad.removeFirst());
        }
        ad = new ArrayDeque<Integer>();
    }
}
