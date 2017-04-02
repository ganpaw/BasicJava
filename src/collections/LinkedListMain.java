package collections;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListMain {

  public static void main(String[] args) {
    
    LinkedList<String> list = new LinkedList<String>();
    
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    list.add("5");

   // Collections.shuffle(list);
    
    System.out.println(list);
    
    list.add(list.indexOf("3"), "Three");
    
    list.addFirst("One");;
    
    list.addLast("Last");
    
    System.out.println(list);

    System.out.println("First Element: "+list.element());
    System.out.println("First Element: "+list.getFirst());
    System.out.println("First Element: "+list.peek());
    System.out.println("First Element: "+list.peekFirst());
    
    System.out.println(list);
  }

}
