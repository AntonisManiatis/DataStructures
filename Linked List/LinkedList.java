package linkedlist;

/**
 * Data Structures: Linked List with generics. <br>
 * Very basic implementation of a Single Linked List.
 * @param T
 * @author AntonisManiatis
 */
public class LinkedList<T>
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
	
	private Node<T> head;
	private int size;
	
	/**
	 * Adds a new value
	 * @param value
	 */
	public boolean add(T value)
	{
		// Create a new node and set the value
		final Node<T> node = new Node<>(value);
		// if the list is empty then add a new node as the head.
		if (isEmpty())
		{
			head = node;
		}
		else
		{
			// Initially let the current node point to the head
			Node<T> currentNode = head;
			if (currentNode != null)
			{
				// Iterate through until we find the end of the list.
				while (currentNode.next != null)
				{
					// Make the current node point to the next node
					currentNode = currentNode.next;
				}
				
				// At this point we reached the last node.
				// Make the last node's next node to point to the node we created.
				currentNode.next = node;
			}
		}
		
		size++;
		return true;
	}
	
	/**
	 * Removes a value from the list.
	 * @param value
	 * @return true if the operation was successful
	 */
	public boolean remove(T value)
	{
		// Nothing to remove.
		if (isEmpty())
		{
			return false;
		}
		
		Node<T> currentNode = head;
		Node<T> previousNode = null;
		while (currentNode != null)
		{
			// Check if there's a value that is equal to the one given
			if (currentNode.value.equals(value))
			{
				// Clear the value.
				currentNode.value = null;
				
				// Connect the nodes
				// Head is a special case
				if (currentNode == head)
				{
					head = currentNode.next;
				}
				else
				{
					previousNode.next = currentNode.next;	
				}
				
				size--;
				return true;
			}
			
			// Iterate over each node
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index)
	{
		final T value = get(index);
		return remove(value);
	}
	
	/**
	 * Gets the value at the given index.
	 * @param index
	 * @throws IndexOutOfBoundsException - if the specified index is negative or 
	 * @return the value if it exists, null otherwise.
	 */
	public T get(int index)
	{
		checkIndexRange(index);
		
		if (isEmpty())
		{
			return null;
		}
		
		// Initially the current node points to the head
		Node<T> currentNode = head;
		for (int i = 0; i < index; i++)
		{
			// Iterate until the desired index is reached.
			currentNode = currentNode.next;
		}
		
		// return the node's value at the given index.
		return currentNode.value;		
	}
	
	/**
	 * Checks if the index is inside the bounds.
	 * @param index
	 * @throws IndexOutOfBoundsException if the index is negative or exceeds the list's size
	 */
	private void checkIndexRange(int index)
	{
		if (index < 0 || index > size)
		{
			throw new IndexOutOfBoundsException("Index cannot negative or greater than the list's size!");
		}
	}
	
	/**
	 * Gets the list's current size.
	 * @return the size
	 */
	public int getSize()
	{
		return size;
	}
	
	/**
	 * Checks if the list is empty.
	 * @return {@code true} if the list is empty
	 */
	public boolean isEmpty()
	{
		return head == null;
	}
	
	/**
	 * Clears the list
	 */
	public void clear()
	{
		if (isEmpty())
		{
			return;
		}
		
		// Initially the current node points to the head
		Node<T> currentNode = head;
		// Iterate through all the nodes until the last one.
		while (currentNode != null)
		{
			// Set the value to point to null.
			currentNode.value = null;
			// Make the current node point to it's next node.
			currentNode = currentNode.next;
		}
		
		// Reset the size back to 0.
		size = 0;
		// After clearing all the nodes make the head node point to null.
		head = null;
	}
	
	/**
	 * Prints out the list
	 */
	@Override
	public String toString()
	{
		if (isEmpty())
		{
			return "The list is empty!";
		}
		
		final StringBuilder sb = new StringBuilder();
		// Initially the current node points to the head
		Node<T> currentNode = head;
		// Iterate through all the nodes until the last one is found.
		while (currentNode != null)
		{	
			sb.append(currentNode.value + "\n");
			// Make the current node to point to it's next node.
			currentNode = currentNode.next;
		}
		
		return sb.toString();
	}
}
