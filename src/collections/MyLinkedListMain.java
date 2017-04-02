package collections;

//class Node {
//  private Object data;
//  private Node nextNode;
//  
//  public Node(){
//    this.data = null;
//    this.nextNode = null;
//  }
//  public Node (Object data, Node nextNode){
//    this.data =data;
//    this.nextNode = nextNode;
//  }
//  
//  public Object getData() {
//    return data;
//  }
//  public void setData(Object data) {
//    this.data = data;
//  }
//  public Node getNextNode() {
//    return nextNode;
//  }
//  public void setNextNode(Node nextNode) {
//    this.nextNode = nextNode;
//  }
//}

class MyLinkedList{
  private Node start;
  private Node end;
  private int size;
  
  public MyLinkedList() {
    start = null;
    end = null;
    size = 0;
  }
  
  public boolean isEmpty(){
    return start == null;
  }
  
  public int getSize (){
    return size;
  }
  
  /**
   * add 
   * @param obj
   */
  public void add(Object obj){
    Node node  = new Node(obj, null);
    size++;
    
    if (start == null){
      start = node;
      end = start;
    }else{
      end.setNextNode(node); // set next node (currently null) of previous end node
      end = node; // set end as this node
    }
  }
  
  /**
   * Insert at first position
   * @param obj
   */
  public void addFirst(Object obj){
    Node node = new Node(obj, null);
    size ++;
    
    if (start == null){
      start = node;
      end = start;
    }else{
      node.setNextNode(start); // set next node of this insertion node as previous stored start
      start = node; // set start to this node
    }
  }
  
  public void insertAt(Object obj, int position){
    Node node = new Node (obj, null);
    Node prt = start;
    position = position - 1;
    
    if (position == 0){
      addFirst(obj);
      return;
    }
    
    for (int i=1; i<size; i++){
      
      //insert at ith position
      if (i==position){
        Node tmp = prt.getNextNode();
        prt.setNextNode(node);
        node.setNextNode(tmp);
        break;
      }else{
        prt = prt.getNextNode(); // get next node
      }  
    }
    size++;
  }
  
  public void display(){
    if (size == 0){
      System.out.println("List is empty");
      return;
    }
    
    // If only one node
    if (start.getNextNode() == null){
      System.out.println(start.getData());
    }
    
    Node prt = start;
    System.out.println(prt.getData());
    do {
        prt = prt.getNextNode();
        System.out.println(prt.getData());
    }while (prt.getNextNode() != null);
      
  }
  
  
  /**
   * Static class Node
   * @author dealscandy
   *
   */
  private static class Node{
    private Object data;
    private Node nextNode;
    
    public Node(){
      this.data = null;
      this.nextNode = null;
    }
    public Node (Object data, Node nextNode){
      this.data =data;
      this.nextNode = nextNode;
    }
    
    public Object getData() {
      return data;
    }
    public void setData(Object data) {
      this.data = data;
    }
    public Node getNextNode() {
      return nextNode;
    }
    public void setNextNode(Node nextNode) {
      this.nextNode = nextNode;
    }
  }
}

public class MyLinkedListMain {
  public static void main(String[] args) {
    MyLinkedList list = new MyLinkedList();
    list.add("First");
    list.add("Second");
    list.add("Third");
    list.add("Forth");
    list.add("Fifth");
    list.insertAt("Sixth", 4);
    
    list.display();
    
  }
}
