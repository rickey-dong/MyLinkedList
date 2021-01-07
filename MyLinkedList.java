public class MyLinkedList
{
  private int size;
  private Node head, tail;
  public MyLinkedList()
  {
    size = 0;
    head = new Node(null);
    tail = new Node(null);
  }
  public int size()
  {
    return size;
  }
  public boolean add(String value)
  {
    if (size() == 0)
    {
      Node appendThisNode = new Node(value);
      head = appendThisNode;
      tail = appendThisNode;
      size++;
      return true;
    }
    else
    {
      Node appendThisNode = new Node(value);
      appendThisNode.setPrev(tail);
      tail = appendThisNode;
      tail.getPrev().setNext(appendThisNode);
      size++;
      return true;
    }
  }
  public void add(int index, String value)
  {
    if (index < 0 || index > size())
    {
      throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
    }
    if (index == size())
    {
      add(value);
    }
    else if (index == 0)
    {
      Node insertThisNode = new Node(value);
      insertThisNode.setNext(head);
      head = insertThisNode;
      head.getNext().setPrev(insertThisNode);
      size++;
    }
    else
    {
      Node insertThisNode = new Node(value);
      insertThisNode.setPrev(getNthNode(index));
      insertThisNode.setNext(getNthNode(index+1));
      insertThisNode.getPrev().setNext(insertThisNode);
      insertThisNode.getNext().setPrev(insertThisNode);
      size++;
    }
  }
  public String get(int index)
  {
    if (index < 0 || index >= size())
    {
      throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
    }
    return getNthNode(index+1).getData();
  }
  public String set(int index, String value)
  {
    if (index < 0 || index >= size())
    {
      throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
    }
    String replacedValue = getNthNode(index+1).getData();
    getNthNode(index+1).setData(value);
    return replacedValue;
  }
  public String toString()
  {
    String stringLinkedList = "[";
    Node current = head;
    while (current != null)
    {
      stringLinkedList += current.getData();
      if (current.getNext() != null)
      {
        stringLinkedList += ", ";
      }
      current = current.getNext();
    }
    stringLinkedList += "]";
    return stringLinkedList;
  }
  private Node getNthNode(int n)
  {
    Node current = head;
    for (int i = 0; i < n - 1; i++)
    {
      current = current.getNext();
    }
    return current;
  }
}