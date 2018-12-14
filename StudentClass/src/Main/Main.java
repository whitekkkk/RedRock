package Main;


import Thread.Thread18;
import Thread.Thread17;
import Thread.Thread16;
import Thread.Thread15;
import Thread.Thread14;



public class Main {
    public static void main(String[] args)throws Exception{
        Thread14 thread14=new Thread14();
        Thread demo14=new Thread(thread14);
        Thread15 thread15=new Thread15();
        Thread demo15=new Thread(thread15);
        Thread16 thread16=new Thread16();
        Thread demo16=new Thread(thread16);
        Thread17 thread17=new Thread17();
        Thread demo17=new Thread(thread17);
        Thread18 thread18=new Thread18();
        Thread demo18=new Thread(thread18);
        demo14.start();
        demo15.start();
        demo16.start();
        demo17.start();
        demo18.start();
    }
}