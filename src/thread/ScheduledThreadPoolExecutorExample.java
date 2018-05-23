package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPoolExecutorExample
{
   public static void main(String[] args) throws InterruptedException, ExecutionException
    {

        Runnable runnabledelayedTask = new Runnable()
        {
            @Override
            public void run()
            {
                 System.out.println(Thread.currentThread().getName()+" is Running Delayed Task");
            }
        };


        Callable callabledelayedTask = new Callable()
        {

            @Override
            public String call() throws Exception
            {
                 return "GoodBye! See you at another invocation...";
            }
        };

        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(4);

        scheduledPool.scheduleWithFixedDelay(runnabledelayedTask, 1, 1, TimeUnit.SECONDS);

        ScheduledFuture<String> sf = scheduledPool.schedule(callabledelayedTask, 4, TimeUnit.SECONDS);

        String value = sf.get();

        System.out.println("Callable returned"+value);

        scheduledPool.shutdown();

        System.out.println("Is ScheduledThreadPool shutting down? "+scheduledPool.isShutdown());
    }
}