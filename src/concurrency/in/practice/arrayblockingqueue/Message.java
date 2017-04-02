package concurrency.in.practice.arrayblockingqueue;

public class Message {
  private String msg;
  
  public Message(String str){
      this.msg=str;
  }

  public String getMsg() {
      return msg;
  }

}
