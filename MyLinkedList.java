public class MyLinkedList
{
  private int size;
  private Node head, tail;
  public MyLinkedList()
  {
    size = 0;
  }
  public int size()
  {
    return size;
  }
  public boolean add(String value)
  {
    if (size == 0)
    {
      head.setData(value);
      tail.setData(value);
      size++;
      return true;
    }
    else
    {
      tail.setData(value);
      tail.setNext(null);
      tail.setPrev(tail);
      tail.getPrev().setNext(tail);
      size++;
      return true;
    }
  }
}