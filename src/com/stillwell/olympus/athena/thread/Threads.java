package com.stillwell.olympus.athena.thread;
class RunnableDemo implements Runnable {
   private Thread t;
   private String threadName;
   
   RunnableDemo( String name){
       threadName = name;
       System.out.println("Creating " +  threadName );
   }
   public void run() {
      System.out.println(" Running " +  threadName );
      try {
         for(int i = 4; i > 0; i--) {
            System.out.println("  Thread " + threadName + " : count = " + i);
            // Let the thread sleep for a while.
            Thread.sleep(5000);
         }
     } catch (InterruptedException e) {
         System.out.println("   Thread " +  threadName + " was interrupted.");
     }
     System.out.println("    Thread " +  threadName + " is exiting.");
   }
   
   public void start ()
   {
      System.out.println("     Starting Thread " +  threadName );
      if (t == null)
      {
         t = new Thread (this, threadName);
         t.start ();
      }
   }

}

public class Threads {
   public static void main(String args[]) {
   
      RunnableDemo R1 = new RunnableDemo("sillyThread");
      R1.start();
      
      RunnableDemo R2 = new RunnableDemo("goofyThread");
      R2.start();
      
      RunnableDemo R3 = new RunnableDemo("smartyThread");
      R3.start();
      
   }   
}