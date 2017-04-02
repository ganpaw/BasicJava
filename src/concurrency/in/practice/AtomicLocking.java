package concurrency.in.practice;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Atomic Locking > Compound Actions 
 */
public class AtomicLocking {

  public static void main(String[] args) {
    
    // Avoids Race conditions and retains Atomicity
    AtomicInteger number = new AtomicInteger(0);
    
    System.out.println(number.incrementAndGet());
    
    
  }

}
