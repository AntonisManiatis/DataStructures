package linkedlist;

public class LinkedListDemo
{
	public static void main(String[] args)
	{
		LinkedList<String> linkedList = new LinkedList<>();
		linkedList.add("Hello");
		linkedList.add("World");
		linkedList.add("Java");
		
		for (int i = 0; i < linkedList.getSize(); i ++)
		{
			System.out.println("Value at " + i + " index: " + linkedList.get(i));
		}
		
		linkedList.remove("Java");
		linkedList.remove(null);
		System.out.println("After removal");
		for (int i = 0; i < linkedList.getSize(); i ++)
		{
			System.out.println("Value at " + i + " index: " + linkedList.get(i));
		}
		
		System.out.println("List's Size: " + linkedList.getSize());
		System.out.println(linkedList);
		linkedList.clear();
		System.out.println(linkedList);
		System.out.println("List's Size after clear call: " + linkedList.getSize());
		// Should throw an out of bounds exception.
		linkedList.get(10);
	}
}
