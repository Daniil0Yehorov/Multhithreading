package org.Threads_1;


public class Main {
    public static void main(String[] args) {
        MyThread mythread=new MyThread();
        mythread.start();
        System.out.println(Thread.currentThread().getName());
        MyThread mythread1=new MyThread();
        mythread1.start();
        //example with Interface
        /*
        MyRunnable Myrun=new MyRunnable();
        Thread th2=new Thread(Myrun);
        th2.start();*/
    }
}
class MyThread extends Thread{//object
    @Override
    public void run(){
        //System.out.println(Thread.currentThread().getName());
        //multithreading example with 2 Threads; works in 1 time

        for(int i=0;i<1000;i++){
         System.out.println(Thread.currentThread().getName()+i);
        }

    }
}


class MyRunnable implements Runnable{//interface
    @Override
    public void run(){
       System.out.println(Thread.currentThread().getName());
    }

}