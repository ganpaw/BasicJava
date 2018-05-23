package thread;

/**
 * Message
 *
 */
class Message {
  private String msg;

  public Message(String str) {
    this.msg = str;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String str) {
    this.msg = str;
  }

}


/**
 * Waiter
 */
class Waiter implements Runnable {

  private Message msg;
  private long timeout; 

  public Waiter(Message m) {
    this.msg = m;
  }
  
  public Waiter(Message m, int timeout) {
    this.msg = m;
    this.timeout = timeout;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    synchronized (msg) {
      try {
        System.out.println(name + " waiting to get notified at time:" + System.currentTimeMillis());
        if (timeout > 0){
          msg.wait(timeout);
        }else{
          msg.wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out
          .println(name + " waiter thread got notified at time:" + System.currentTimeMillis());
      // process the message now
      System.out.println(name + " processed: " + msg.getMsg());
    }
  }
}


/**
 * Notifier
 */
class Notifier implements Runnable {

  private Message msg;

  public Notifier(Message msg) {
    this.msg = msg;
  }

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    System.out.println(name + " started");
    try {
      Thread.sleep(1000);
      synchronized (msg) {
        msg.setMsg(name + " Notifier work done");
        msg.notify();
        // msg.notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}

class MessageSetterTask implements Runnable{
  private Message msg;

  public MessageSetterTask(Message msg) {
    this.msg = msg;
  }
  
  @Override
  public void run() {
    
    synchronized(msg){
      msg.setMsg("MyTask has processed it.");
      try {
        System.out.println("MessageSetter will release lock in 10 seconds");
        Thread.sleep(10000);        
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println("MessageSetter is about to release lock on msg..");
    }
    
    
  }
  
}
public class WaitNotifyTest {
  public static void main(String[] args) {
    Message msg = new Message("process it");
    Waiter waiter1 = new Waiter(msg);
    new Thread(waiter1, "waiter1").start();

    Waiter waiter2 = new Waiter(msg, 5000);
    new Thread(waiter2, "waiter2").start();

    Notifier notifier = new Notifier(msg);
    new Thread(notifier, "notifier").start();
    
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    MessageSetterTask msgSetterTask = new MessageSetterTask(msg);
    Thread messageTaskWorker = new Thread(msgSetterTask);
    messageTaskWorker.start();
    
    System.out.println("All the threads are started");
  }
}
