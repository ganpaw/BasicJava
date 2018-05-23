package thread;

class MyTask implements Runnable{
  public void run(){
    try {
      //while(true){
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(5000);
      
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("Leaving daemon thread:"+Thread.currentThread().getName());
  }
}

public class JoinDaemonMain  {
  public static void main(String[] args) {
      MyTask task = new MyTask();
      Thread daemon = new Thread(task);
      daemon.setDaemon(true);
      daemon.start();
      
      try {
        daemon.join(); // try to comment out.
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      System.out.println(daemon.isAlive());
      System.out.println("Leaving main thread");
  }
}
