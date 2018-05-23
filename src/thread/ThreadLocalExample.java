package thread;


class Deal{
  private String title = "DEFAULT";
  
  public Deal(){
    
  }
  public Deal(String title){
    this.title = title;
  }
  public void setTitle(String title){
    this.title = title;
  }
  public String getTitle(){
    return this.title;
  }
}

/**
 * http://www.journaldev.com/1076/java-threadlocal-example
 * 
 * @author dealscandy
 *
 */
public class ThreadLocalExample implements Runnable{

  private static final ThreadLocal<Deal> threadLocal = new ThreadLocal<Deal>(){
    @Override
    protected Deal initialValue(){
      return new Deal();
    }
  };
  
  @Override
  public void run() {
    
    System.out.println(Thread.currentThread().getName()+" ---- before ---- "+threadLocal.get().getTitle());
    
    threadLocal.set(new Deal("VANILLA"));
    try {
      Thread.sleep(1000);
    }catch (InterruptedException ex){}
    System.out.println(Thread.currentThread().getName()+" ---- after ---- "+threadLocal.get().getTitle());
    
  }
  public static void main(String[] args) {

   // Nothing to do with Threadlocal, it is just Shutdown hook test.
    Runtime.getRuntime().addShutdownHook(new Thread(){
      @Override 
      public void run(){
        System.out.println("Shutdown hook invoked.");
      }
    });
    
      ThreadLocalExample task = new ThreadLocalExample();
      
      Thread t1 =  new Thread(task, "First");
      Thread t2 =  new Thread(task, "Second");
      Thread t3 =  new Thread(task, "Third");
      
      t1.start();
      try {
        Thread.sleep(2000);
      }catch (InterruptedException ex){}
      t2.start();
      try {
        Thread.sleep(2000);
      }catch (InterruptedException ex){}
      t3.start();
      
  
      System.out.println("Leaving main thread..");
  }


}
