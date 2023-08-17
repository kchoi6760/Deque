package deque;

import org.junit.Test;

import static org.junit.Assert.*;


/** Performs some basic linked list deque tests. */
public class LinkedListDequeTest {

    /** You MUST use the variable below for all of your tests. If you test
     * using a local variable, and not this static variable below, the
     * autograder will not grade that test. If you would like to test
     * LinkedListDeques with types other than Integer (and you should),
     * you can define a new local variable. However, the autograder will
     * not grade that test. Please do not import java.util.Deque here!*/

    public static Deque<Integer> lld = new LinkedListDeque<Integer>();


    @Test
    /** Adds a few things to the list, checks that isEmpty() is correct.
     * This is one simple test to remind you how junit tests work. You
     * should write more tests of your own.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {
		assertTrue("A newly initialized LLDeque should be empty", lld.isEmpty());
		lld.addFirst(0);
        assertFalse("lld1 should now contain 1 item", lld.isEmpty());
        lld = new LinkedListDeque<Integer>(); //Assigns lld equal to a new, clean LinkedListDeque!
    }

    /** Adds an item, removes an item, and ensures that dll is empty afterwards. */
    @Test
    public void addRemoveTest() {
        assertTrue("make sure lld is empty", lld.isEmpty());
        lld.addFirst(1);
        lld.removeLast();
        assertTrue(lld.isEmpty());
        lld = new LinkedListDeque<Integer>();
    }
    /** Make sure that removing from an empty LinkedListDeque does nothing */
    @Test
    public void removeEmptyTest() {
        lld = new LinkedListDeque<Integer>();
        assertTrue("see if lld is empty", lld.isEmpty());
        assertNull(lld.removeFirst());
        assertNull(lld.removeLast());
        assertTrue("see if lld is empty", lld.isEmpty());
        assertTrue(lld instanceof LinkedListDeque<Integer>);
    }
    /** Make sure your LinkedListDeque also works on non-Integer types */
    @Test
    public void multipleParamsTest() {
        Deque<Boolean> asf = new LinkedListDeque<Boolean>();
        Deque<Double> tft = new LinkedListDeque<Double>();
        asf = new LinkedListDeque<Boolean>();
        asf.addFirst(true);
        asf.addFirst(true);
        asf.addFirst(false);
        assertFalse(asf.get(0));
        assertTrue(asf.get(1));
        assertTrue(asf.get(2));
        asf.removeLast();
        tft = new LinkedListDeque<Double>();
        tft.addFirst(2.1);
    }
    /** Make sure that removing from an empty LinkedListDeque returns null */
    @Test
    public void emptyNullReturn() {
        assertTrue("see if lld is empty", lld.isEmpty());
        assertNull(lld.removeFirst());
        assertNull(lld.removeLast());
        lld = new LinkedListDeque<Integer>();
    }
    /** TODO: Write tests to ensure that your implementation works for really large
     * numbers of elements, and test any other methods you haven't yet tested!
     */

    @Test
    public void add100remove99test(){
        for (int i = 0; i < 100; i++) {
            lld.addLast(i);
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(i == lld.removeFirst());
        }
        lld = new LinkedListDeque<Integer>();
    }

}
