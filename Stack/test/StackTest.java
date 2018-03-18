import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing of the {@link Stack} implementation
 * @author AntonisManiatis
 */
public class StackTest
{
	private Stack<String> stack;
	
	@Before
	public void setUp()
	{
		stack = new Stack<>();
	}
	
	@Test
	public void testPush()
	{
		stack.push("Hello");
		stack.push("World");
		stack.push("Java");
		
		assertEquals("Java", stack.pop());
		assertEquals("World", stack.pop());
		assertEquals("Hello", stack.pop());	
	}
	
	@Test
	public void testPeek()
	{
		stack.push("Hello");
		stack.push("World");
		assertEquals("World", stack.peek());
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeekWithEmptyStack()
	{
		assertNull(stack.peek());
	}
	
	@Test
	public void testPop()
	{
		stack.push("Hello");		
		assertEquals("Hello", stack.pop());
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPopWithEmptyStack()
	{
		assertNull(stack.pop());
	}
	
	@Test
	public void testIsEmpty()
	{
		assertTrue(stack.isEmpty());
		stack.push("Java");
		assertFalse(stack.isEmpty());
	}
	
	@Test 
	public void testStackSize()
	{
		stack.push("Hello");
		stack.push("World");	
		assertEquals(2, stack.getSize());
		
		stack.pop();
		assertEquals(1, stack.getSize());
	}
}
