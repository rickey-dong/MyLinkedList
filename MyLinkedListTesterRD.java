public class MyLinkedListTesterRD
{
  public static void main(String[] args)
  {
    Node a = new Node("left");
    System.out.println(a.getData() + " should be left");
    a.setData("west");
    System.out.println(a.getData() + " should be west");
    System.out.println(a.getNext() + " should be null");
    System.out.println(a.getPrev() + " should be null");
    Node b = new Node("east");
    System.out.println(b.getData() + " should be east");
    b.setData("right");
    System.out.println(b.getData() + " should be right");
    System.out.println(b.getNext() + " should be null");
    System.out.println(b.getPrev() + " should be null");
    a.setNext(b);
    b.setPrev(a);
    System.out.println(a.getNext() + " should be some hash code");
    System.out.println(a.getPrev() + " should be null");
    System.out.println(b.getPrev() + " should be some hash code");
    System.out.println(b.getNext() + " should be null");
    System.out.println();
    System.out.println("-----------------------------------");
    System.out.println();
    MyLinkedList chainOfNumbers = new MyLinkedList();
    System.out.println(chainOfNumbers.size() + " should be 0");
    System.out.println(chainOfNumbers.add("one") + " should be true");
    System.out.println(chainOfNumbers.size() + " should be 1");
    System.out.println(chainOfNumbers.toString() + " should be [one]");
    System.out.println(chainOfNumbers.get(0) + " should be one");
    try
    {
      chainOfNumbers.get(-2);
    }
    catch(IndexOutOfBoundsException e)
    {
      System.out.println(e);
    }
    try
    {
      chainOfNumbers.get(1);
    }
    catch(IndexOutOfBoundsException e)
    {
      System.out.println(e);
    }
    System.out.println("Those were errors");
    System.out.println(chainOfNumbers.set(0, "uno") + " should be one");
    System.out.println(chainOfNumbers.toString() + " should be [uno]");
    System.out.println(chainOfNumbers.add("dos") + " should be true");
    System.out.println(chainOfNumbers.toString() + " should be [uno, dos]");
    chainOfNumbers.add(1, "tres");
    System.out.println(chainOfNumbers.toString() + " should be [uno, tres, dos]");
    System.out.println(chainOfNumbers.get(1) + " should be tres");
    chainOfNumbers.add(0, "negativo uno");
    System.out.println(chainOfNumbers.toString() + " should be [negative uno, uno, tres, dos]");
    System.out.println(chainOfNumbers.get(0) + " should be negativo uno");
    System.out.println(chainOfNumbers.size() + " should be 4");
    System.out.println();
    System.out.println();
    //chainOfNumbers.verify();
    MyLinkedList aK = new MyLinkedList();
    MyLinkedList bK = new MyLinkedList();
    for(int i = 0; i < 10; i++){
      if(i < 5){
        aK.add(i+"");
      }else{
        bK.add(i+"");
      }
    }
    System.out.println();
    System.out.println("A:"+aK+aK.size());
    System.out.println("B:"+bK+bK.size());

    aK.extend(bK);
    System.out.println("A:"+aK+aK.size());
    System.out.println("B:"+bK+bK.size());
    System.out.println("A reversed:"+aK.toStringReversed()+aK.size());
    System.out.println("B reversed:"+bK.toStringReversed()+bK.size());
    System.out.println();
    System.out.println();
    System.out.println();
    MyLinkedList betterChain = new MyLinkedList();
    System.out.println(betterChain.size() + " should be 0");
    System.out.println(betterChain + " should be []");
    betterChain.add("yi");
    System.out.println(betterChain + " should be [yi]");
    betterChain.add("er");
    System.out.println(betterChain + " should be [yi, er]");
    betterChain.remove(1);
    System.out.println(betterChain + " should be [yi]");
    betterChain.remove(0);
    System.out.println(betterChain + " should be []");
    betterChain.add("yi");
    betterChain.add("er");
    betterChain.add("san");
    betterChain.add("si");
    System.out.println(betterChain.size() + " should be 4");
    System.out.println(betterChain + " should be [yi, er, san, si]");
    System.out.println();
    System.out.println(betterChain.remove(1) + " should be er");
    System.out.println(betterChain.size() + " should be 3");
    System.out.println(betterChain + " should be [yi, san, si]");
    System.out.println();
    System.out.println(betterChain.remove(2) + " should be si");
    System.out.println(betterChain.size() + " should be 2");
    System.out.println(betterChain + " should be [yi, san]"); 
    System.out.println();
    System.out.println(betterChain.remove(0) + " should be yi");
    System.out.println(betterChain.size() + " should be 1");
    System.out.println(betterChain + " should be [san]");
    System.out.println();
    System.out.println(betterChain.remove(0) + " should be san");
    System.out.println(betterChain.size() + " should be 0");
    System.out.println(betterChain + " should be []");
    MyLinkedList emptyChain = new MyLinkedList();
    betterChain.extend(emptyChain);
    System.out.println(betterChain + " should be []");
    emptyChain.add("one");
    System.out.println(emptyChain + " should be [one]");
    emptyChain.extend(betterChain);
    System.out.println(emptyChain + " should be [one]");
    emptyChain.add(0, "zero");
    emptyChain.add(2, "two");
    System.out.println(emptyChain + " should be [zero, one, two]");
    betterChain.extend(emptyChain);
    System.out.println(emptyChain + " should be []");
    System.out.println(betterChain + " should be [zero, one, two]");
    System.out.println(emptyChain.size() + " should be 0");
    System.out.println(betterChain.size() + " should be 3");
    betterChain.remove(1);
    betterChain.remove(1);
    System.out.println(betterChain.size() + " should be 1");
    emptyChain.add("one-half");
    betterChain.extend(emptyChain);
    System.out.println(emptyChain.size() + " should be 0");
    System.out.println(betterChain.size() + " should be 2");
    System.out.println(betterChain + " should be [zero, one-half]");
    emptyChain.add("two-third");
    betterChain.extend(emptyChain);
    System.out.println(betterChain + " should be [zero, one-half, two-third]");
    System.out.println(betterChain.size() + " should be 3");
    System.out.println(emptyChain.size() + " should be 0");
    emptyChain.add("two");
    emptyChain.extend(betterChain);
    System.out.println(betterChain.size() + " should be 0");
    System.out.println(emptyChain.size() + " should be 4");
    System.out.println(emptyChain + " should be [two, zero, one-half, two-third]");
    betterChain.add("five");
    betterChain.add("six");
    System.out.println(betterChain.size() + " should be 2");
    betterChain.extend(emptyChain);
    System.out.println(betterChain.size() + " should be 6");
    System.out.println(emptyChain.size() + " should be 0");
    System.out.println(betterChain + " should be [five, six, two, zero, one-half, two-third]");
    System.out.println(emptyChain + " should be []");
  }
}