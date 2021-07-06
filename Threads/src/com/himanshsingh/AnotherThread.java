package com.himanshsingh;

import static com.himanshsingh.ThreadColorr.*;
public class AnotherThread extends Thread {

    @Override
    public void run(){
        System.out.println("\u001B[35m"+"Hello from : " + currentThread().getName());

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println(ANSI_PURPLE + currentThread().getName() + " is interrupted from sleep.");
            return;
        }
        System.out.println(ANSI_PURPLE + currentThread().getName() + " woke after sleep for 3 sec.");
    }
}
