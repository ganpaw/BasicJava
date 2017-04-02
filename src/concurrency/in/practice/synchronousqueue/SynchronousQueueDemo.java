package concurrency.in.practice.synchronousqueue;

import java.util.concurrent.SynchronousQueue;

/** * Java Program to solve Producer Consumer problem using SynchronousQueue. A * call to put() will block until there
 *  is a corresponding thread to take() that * element. * * @author Javin Paul
 *  
 *  
 *   http://javarevisited.blogspot.com/2014/06/synchronousqueue-example-in-java.html
 *  http://stackoverflow.com/questions/8591610/when-should-i-use-synchronousqueue
 *  http://stackoverflow.com/questions/18453503/trying-to-understand-the-mechanics-of-a-synchronous-queue 
 *   */

public class SynchronousQueueDemo{ 
  public static void main(String args[]) { 
    
    final SynchronousQueue<String> queue = new SynchronousQueue<String>(); 
    
    Thread producer = new Thread("PRODUCER") { 
    
      public void run() { 
        String event = "FOUR"; 
        try { 
          System.out.println("PRODUCER is going to put");
          queue.put(event); // thread will block here 
          System.out.printf("[%s] published event : %s %n", Thread .currentThread().getName(), event);
          System.out.println("PRODUCER is done!");
        } catch (InterruptedException e) {
          System.out.println("Interrupted and do some Cleanup"); 
          e.printStackTrace();
         //Thread.currentThread().interrupt();
        } 
        }
      };
      
      
      producer.start(); // starting publisher thread 
    //producer.interrupt();
      
      try{
        Thread.sleep(2000);
      }catch(Exception e){}
      
      Thread consumer = new Thread("CONSUMER") { 
        public void run() { 
          try { 
              System.out.println("CONSUMER is going to take");
              String event = queue.take(); // thread will block here 
              System.out.printf("[%s] consumed event : %s %n", Thread .currentThread().getName(), event);
              System.out.println("CONSUMER is done!");
            } catch (InterruptedException e) { e.printStackTrace(); } 
          } };
      consumer.start(); // starting consumer thread } }
      
      
      
      
   }
}

