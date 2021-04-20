package ee.ut.cs.swt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MinimumBinaryHeapTest {
	
	private MinimumBinaryHeap heap;
	private List<Integer> result;
	
	@Before
	public void setUp() {
		heap = new MinimumBinaryHeap();
		result = new ArrayList<>();
		result.add(10);
		result.add(5);
		result.add(4);
		result.add(8);
		result.add(12);
	}
	@Test
	public void extractMinTest() {
		heap.add(7);
		heap.add(1);
		heap.add(6);
		int min = heap.exractMin();
		assertEquals(1, min);
	}
	@Test
	public void removeTest() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(3);
		assertEquals(true, b1);
	}
	
	@Test
	public void minHeapifyTest() {
		heap.minHeapify(result);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);

	}
	@Test
	public void minHeapifyTestWithSameNumbers() {
		heap.add(5);
		heap.add(5);
		heap.add(3);
		heap.add(3);
		assertEquals(3, heap.getArray().get(0), 0);
		assertEquals(3, heap.getArray().get(1), 0);

	}

	@Test(expected = IllegalArgumentException.class)
	public void extractMinTestEmptyHeap()  {
		heap.exractMin();
	}

	@Test
	public void extractLastElementStanding() {
		heap.add(1);
		int min = heap.exractMin();
		assertEquals(1, min);
	}
	@Test
	public void swapTest() {
		heap.add(5);
		heap.add(8);
		heap.add(13);
		heap.swap(1, 2);
		assertEquals(5, heap.getArray().get(0), 0);
		assertEquals(13, heap.getArray().get(1), 0);

	}
	@Test
	public void swapSameTest(){
		heap.add(5);
		heap.add(13);
		heap.add(13);
		heap.swap(1, 2);
		assertEquals(13, heap.getArray().get(1), 0);
		assertEquals(13, heap.getArray().get(2), 0);

	}
	@Test
	public void addTest() {
		heap.add(10);
		heap.add(5);
		heap.add(4);
		heap.add(8);
		heap.add(12);
		assertEquals(4, heap.getArray().get(0), 0);
		assertEquals(8, heap.getArray().get(1), 0);
	}
	@Test
	public void addTestWithCertainNumbers(){
		heap.add(5);
		heap.add(4);
		heap.add(3);
		heap.add(2);
		assertEquals(3, heap.getArray().get(1), 0);
		assertEquals(5, heap.getArray().get(3), 0);
	}

	@Test
	public void removeTestSmallHeap() {
		heap.add(2);
		heap.add(3);
		boolean b1 = heap.remove(2);
		assertEquals(true, b1);
		int arv = heap.getArray().get(0);
		assertEquals(arv, heap.getArray().get(0),0);
	}
	@Test
	public void removeTest2Times() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		heap.add(8);
		boolean b1 = heap.remove(3);
		assertEquals(true, b1);
		boolean b2 = heap.remove(8);
		assertEquals(true, b2);
	}
	@Test
	public void removeTestWrongElement() {
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(4);
		assertEquals(false, b1);
	}
	@Test
	public void removeTestFromEmptyHeap() {
		boolean b1 = heap.remove(3);
		assertEquals(false, b1);
	}
	@Test
	public void removeSameTwice(){
		heap.add(5);
		heap.add(3);
		heap.add(2);
		boolean b1 = heap.remove(3);
		assertEquals(true, b1);
		boolean b2 = heap.remove(3);
		assertEquals(false, b2);
	}
	@Test
	public void removeRoot(){
		heap.add(2);
		heap.add(3);
		heap.add(5);
		boolean b1 = heap.remove(2);

		assertEquals(true,b1);
		assertEquals(2,heap.getArray().size(),0);

	}
	@Test
	public void isEmptyTest() {
		heap = new MinimumBinaryHeap();
		assertEquals(true, heap.isEmpty());
	}
	@Test
	public void isNotEmpty() {
		heap = new MinimumBinaryHeap();
		heap.add(3);
		assertEquals(false, heap.isEmpty());
	}
	@Test
	public void bubbleDownTest() {
		heap.add(2);
		heap.add(3);
		heap.add(8);
		heap.add(8);
		heap.add(8);
		heap.bubbleDown(0);
		assertEquals(2,heap.getArray().get(0),0);
	}
	@Test
	public void removeRootAndCheckIfItIsChanged () {
		heap.add(12);
		heap.add(13);
		heap.add(88);
		heap.add(99);
		heap.add(16);
		heap.add(17);
		heap.add(18);
		heap.remove(12);
		assertEquals(16,heap.getArray().get(1),0);
		assertEquals(88,heap.getArray().get(5),0);
	}
	@Test
	public void extractminRootAndCheckIfItIsChanged() {
		heap.add(12);
		heap.add(13);
		heap.add(88);
		heap.add(99);
		heap.add(16);
		heap.add(17);
		heap.add(18);
		int b1 = heap.exractMin();
		assertEquals(12, b1,0);
		assertNotEquals(18, (int) heap.getArray().get(0));
	}

}

