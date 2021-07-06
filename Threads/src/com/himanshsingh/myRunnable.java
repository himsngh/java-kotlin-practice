package com.himanshsingh;


import static com.himanshsingh.ThreadColorr.ANSI_GREEN;

public class myRunnable implements Runnable {

    @Override
    public void run(){
        System.out.println(ANSI_GREEN + "Hello from the myRunnable class ");
    }
}
