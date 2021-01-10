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
  //public void verify()
//  {
    //Node current = head;
    //for (int i = 0; i < size(); i++)
    //{
      //System.out.println(current.getPrev() + " should be a reference");
      //System.out.println(current.getData() + " should be a String");
    //  System.out.println(current.getNext() + " should be a reference");
      //current = current.getNext();
    //}
  //}
  public String toStringReversed()
  {
    String sLL = "[";
    Node current = tail;
    while (current != null)
    {
      sLL += current.getData();
      if (current.getPrev() != null)
      {
        sLL += ", ";
      }
      current = current.getPrev();
    }
    sLL += "]";
    return sLL;
  }
  public String remove(int index)
  {
    if (index < 0 || index >= size())
    {
      throw new IndexOutOfBoundsException("index " + index + " is out of bounds.");
    }
    String returnThisRemoved = getNthNode(index+1).getData();
    if (size() == 1)
    {
      head = new Node(null);
      tail = new Node(null);
      size--;
    }
    else if (index == 0)
    {
      head.getNext().setPrev(null);
      head = head.getNext();
      size--;
    }
    else if (index == size() - 1)
    {
      tail.getPrev().setNext(null);
      tail = tail.getPrev();
      size--;
    }
    else
    {
      getNthNode(index+1).getPrev().setNext(getNthNode(index+1).getNext());
      getNthNode(index+1).getNext().setPrev(getNthNode(index+1).getPrev());
      size--;
    }
    return returnThisRemoved;
  }
  public void extend(MyLinkedList other)
  {
    if (size() == 0 && other.size() == 0) //when both are empty
    {
      this.head = new Node(null);
      this.tail = new Node(null);
    }
    else if (size() != 0 && other.size() == 0) //when other is empty
    {
      this.head = this.head;
      this.tail = this.tail;
    }
    else if (size() == 0 && other.size() != 0) //when this is empty
    {
      this.head = other.head;
      this.tail = other.tail;
      this.size += other.size();
      other.size = 0;
      other.head = null;
      other.tail = null;
    }
    else if (size() == 1 && other.size() == 1) //when both are size 1
    {
      this.head.setNext(other.head);
      other.head.setPrev(this.head);
      this.tail = other.head;
      this.size += 1;
      other.size = 0;
      other.head = null;
      other.tail = null;
    }
    else if (size() != 1 && other.size() == 1) //when other is size 1
    {
      this.tail.setNext(other.head);
      other.head.setPrev(this.tail);
      this.tail = other.head;
      this.size += 1;
      other.size = 0;
      other.head = null;
      other.tail = null;
    }
    else if (size() == 1 && other.size() != 1) //when this is size 1
    {
      this.head.setNext(other.head);
      other.head.setPrev(this.head);
      this.tail = other.tail;
      this.size += other.size();
      other.size = 0;
      other.head = null;
      other.tail = null;
    }
    else //when both are size 2+
    {
      this.tail.setNext(other.head);
      other.head.setPrev(this.tail);
      this.tail = other.tail;
      this.size += other.size();
      other.size = 0;
      other.head = null;
      other.tail = null;
    }
  }
}