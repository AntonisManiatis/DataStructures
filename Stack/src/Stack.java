import java.util.EmptyStackException;

/**
 * An implementation of the Stack data structure.
 * @author AntonisManiatis
 * @param <T>
 */
public class Stack<T>
{
	private static class Node<T>
	{
		private T value;
		private Node<T> next;
		
		public Node(T value)
		{
			this.value = value;
		}		
	}
	
	/**
	 * The top of the stack
	 */
	private Node<T> top;
	private int size;
	
	/**
	 * Retrieves and removes the element at the top of the stack
	 * @return the value at the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public T pop()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		final T value = top.value;
		top = top.next;
		size--;
		return value;
	}
	
	/**
	 * Retrieves but does NOT remove the element at the top of the stack.
	 * @return the value at the top of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	public T peek()
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return top.value;
	}
	
	/**
	 * Pushes an element into the stack.
	 * @param value the value to push
	 */
	public boolean push(T value)
	{
		if (value == null)
		{
			return false;
		}
		
		final Node<T> node = new Node<T>(value);
		if (top == null)
		{
			top = node;
		}
		else
		{
			node.next = top;
			// Now the top of the stack is the newly created node
			top = node;
		}
		
		size++;
		return true;
	}
	
	/**
	 * @return the size of the stack.
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * @return {@code true} if the stack is empty.
	 */
	public boolean isEmpty()
	{
		return top == null;
	}
	
	/**
	 * Prints out the stack
	 */
	@Override
	public String toString()
	{
		if (isEmpty())
		{
			return "The stack is empty!";
		}
		
		final StringBuilder sb = new StringBuilder();		
		Node<T> current = top;
		while (current != null)
		{
			sb.append(current.value + "\n");
			current = current.next;
		}
		
		return sb.toString();
	}
}
