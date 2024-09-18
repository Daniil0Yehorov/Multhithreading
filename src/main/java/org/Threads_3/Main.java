package org.Threads_3;


public class Main {
    public static void main(String[] args) throws InterruptedException   {
        Resource resource=new Resource();
        //resource.i=0;
        resource.setI(0);

        MyThread myThread=new MyThread();
        MyThread myThread2=new MyThread();

        myThread.setResource(resource);
        myThread2.setResource(resource);

        myThread.start();
        myThread2.start();
        myThread.join();
        myThread2.join();
        //System.out.println(resource.i);
        System.out.println(resource.getI());
    }
}
class MyThread extends Thread{//object
    Resource resource;
    public void setResource(Resource resource){
        this.resource=resource;
    }
    @Override
    public void run(){
        resource.changeI();
    }
}

class Resource{
    //1example
    /*
    private int i;
    //synchronized method to prevent race condition
    public synchronized void changeI(){
        int i=this.i;
        if (Thread.currentThread().getName().equals("main"))
        {
            Thread.yield();
        }
        i++;
        this.i=i;
    }*/
    //2 example
    private int i;
    public synchronized void  setI(int i){
        this.i=i;
    }
    public synchronized int getI(){
        return this.i;
    }

    public  void changeI(){
        int i=this.i;
        if (Thread.currentThread().getName().equals("main"))
        {
            Thread.yield();
        }
        i++;
        this.i=i;
    }

}