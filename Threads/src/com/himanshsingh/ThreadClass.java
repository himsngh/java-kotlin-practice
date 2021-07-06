package com.himanshsingh;

import static com.himanshsingh.ThreadColorr.*;
public class ThreadClass {
    /*
    The order of the thread running  depends on the operating system and the jvm but we have the option to prioritise the order.
    The .start(); in thread is used to invoke the run() method.
    The run method is not in the thread class itself its in the Runnable interface.
    Using runnable also we can create and run new threads.
    We dont pass or use .run() directly as it will create trouble and give the output as running main thread.
    for ex. we can change the name of the thread using set_name() method and in the class to print current_thread.getName();
    but if we use this and invoke run using .run() we will get hello from main method instead of the whichever running thread.

    ----------------------

    We can also make threads sleep for some time and then perform the action .By using Thread.sleep(long in milliseconds) we can
    make the thread sleep for a certain amount of time but it can be interrupted by the operating system and can woke up
    so in order to implement thread.sleep we have to catch exception interruptedException.

    we can stop any thread from running using the interrupt method . thread.interrupt will stop the thread and the exception will be caught.

    By using join we can wait a thread and let the thread run another thread and when that thread completes it will again start executing.
    we can also pass .join(2000) the threshold value for which the current thread will wait for the other thread to finish execution. otherwise
    it will timeout and the current thread will start executing.
     */
    public static void main(String[] args){
        System.out.println(ANSI_RED + "Hello from main Thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("------------- Another Thread ---------------");
        anotherThread.start();
        /*
        Anonymous thread can be created directly from the class .
         */
        new Thread(() ->System.out.println(ThreadColorr.ANSI_BLUE + "Hello from anonymous class thread")).start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_CYAN + "Hello from anonymous thread.");
                try{
                    Thread.sleep(3000);
                }catch (InterruptedException e){
                    System.out.println("Exception woke up from sleep.");
                }
                System.out.println(ANSI_CYAN+ "Hello again Anonymous thread woke after 3 sec.");
            }
        }.start();

        // Interrupting the anotherThread and stopping it from executing.
        anotherThread.interrupt();

        //Using runnable interface.
        Thread runnableThread = new Thread(new myRunnable());
        runnableThread.start();

        new Thread(new myRunnable(){
            public void run(){
                System.out.println(ANSI_GREEN + "Hello  again from myRunnable anonymous class.");
            }
        }).start();
        // Even we can directly use the runnable interface and run a thread.

        Thread anotherThread2 = new AnotherThread();
        anotherThread2.setName("----------anotherthread2-----------");
        anotherThread2.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_BLACK + " Hello from Directly  running Runnable interface ");
                try{
                    anotherThread2.join();
                    System.out.println(ANSI_BLACK + " Another thread 2 finished execution so anonymous interface runnable thread is running again.");
                }catch (InterruptedException e) {
                    System.out.println(ANSI_BLACK + " Another thread 2 interrupted");
                }
                System.out.println("Runnable interface anonymous completed execution.");
            }
        }).start();

        System.out.println(ANSI_RED + "Hello from main Thread");

    }
}
