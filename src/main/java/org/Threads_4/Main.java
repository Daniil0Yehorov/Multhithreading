package org.Threads_4;


public class Main {
   volatile static int i;//без волатайла, изменения внутри потока не видны другому потоку

    public static void main(String[] args) throws InterruptedException   {
        new MyThread().start();
        new MyThreadRead().start();
    }
    static class MyThread extends Thread {
        @Override
        public void run() {
            while(i<5){
                 System.out.println("increment i: " + (++i));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    static class MyThreadRead extends  Thread {
        @Override
        public void run() {
        int localvar=i;
             while(localvar<5){
                if(localvar!=i){
                System.out.println("new value of i: " + i);
                localvar=i;
                }
            }
        }
    }
}


