package org.Threads_2;


public class Main {
    public static void main(String[] args)  {
       MyThread mythread=new MyThread();
        mythread.start();
        try {
            mythread.join();//if thread finished,starts another
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //sleep 1sec for 2 Thread
        /*
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        //mythread.setPriority(5);//Prority for threads (1 bis 10)
       //Thread.yield();//if job finished, starts another thread

        MyThread mythread1=new MyThread();
        mythread1.start();

    }
}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}