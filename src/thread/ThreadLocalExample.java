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

  private static final ThreadLocal<Deal> deal = new ThreadLocal<Deal>(){
    protected Deal initialValue(){
      return new Deal();
    }
  };
  
  @Override
  public void run() {
    
    System.out.println(Thread.currentThread().getName()+" ---- before ---- "+deal.get().getTitle());
    
    deal.set(new Deal("VANILLA"));
    try {
      Thread.sleep(1000);
    }catch (InterruptedException ex){}
    System.out.println(Thread.currentThread().getName()+" ---- after ---- "+deal.get().getTitle());
    
  }
  public static void main(String[] args) {

      ThreadLocalExample task1 = new ThreadLocalExample();
      
      Thread t1 =  new Thread(task1, "First");
      Thread t2 =  new Thread(task1, "Second");
      Thread t3 =  new Thread(task1, "Third");
      
      t1.start();
      try {
        Thread.sleep(2000);
      }catch (InterruptedException ex){}
      t2.start();
      try {
        Thread.sleep(2000);
      }catch (InterruptedException ex){}
      t3.start();

  }


}
