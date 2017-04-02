package concurrency.in.practice;

public class NoVisibility {
  private static boolean ready;
  private static int number;

  private static class ReaderThread extends Thread {
      public void run() {
          while (!ready){
            System.out.println(number);
          }
         System.out.println("Done!");
      }
  }

  public static void main(String[] args) throws Exception {
      new ReaderThread().start();
      number = 42;
      Thread.sleep(1000);
      ready = true;
  }
}
