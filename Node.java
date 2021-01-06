public class Node
{
  private String data;
  private Node next, prev;
  public Node(String value)
  {
    data = value;
    next = null;
    prev = null;
  }
  public String getData()
  {
    return data;
  }
  public void setData(String newData)
  {
    data = newData;
  }
}