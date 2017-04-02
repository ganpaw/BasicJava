package concurrency.in.practice.priorityblockingqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.PriorityQueue;

/**
 * https://kodejava.org/how-do-i-use-priorityblockingqueue-class/
 * 
 * This example demonstrate how to use the PriorityBlockingQueue class. 
   PriorityBlockingQueue is one implementation of the BlockingQueue interface. 
   It is an unbounded concurrent queue. The object place in this type of queue must implements the java.lang.Comparable
   interface. The Comparable interface defines how the order priority of the elements inside this queue.
   
 * @author dealscandy
 *
 */
public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        final String[] names =
                {"carol", "alice", "malory", "bob", "alex", "jacobs"};

        final BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < names.length; i++) {
                    try {
                        queue.put(names[i]);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Producer").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < names.length; i++) {
                        System.out.println(queue.take());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();
    }
}