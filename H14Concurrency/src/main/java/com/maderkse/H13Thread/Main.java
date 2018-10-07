package com.maderkse.H13Thread;
class Hondje implements Runnable {
   public void run() {
      System.out.println("Hoi, Hondje hier!");
   }
}
class Jack implements Runnable {
   public void run() {
      System.out.println("Hoi, Jack hier!");
   }
}
class OpaHenk implements Runnable {
   public void run() {
      System.out.println("Hoi, opa Henk hier!");
   }

   public synchronized gaSlapen(int duur) {
      sleep(duur); 
   }
}
class Maarten implements Runnable {
   public void run() {
      System.out.println("Hoi, Maarten hier!");
   }
}
class El implements Runnable {
   public void run() {
      System.out.println("Hoi, El hier!");
   }
}
public class Main {
   public static void main(String[] args) {
      System.out.println("Hi, H13Thread here!");
      Runnable hondje = new Hondje();
      Thread t1 = new Thread(hondje);
      t1.start();
      Runnable jack = new Jack();
      Thread t2 = new Thread(jack);
      t2.start();
      Runnable opa = new OpaHenk();
      Thread t3 =new Thread(opa);
      t3.start();
      Runnable el = new El();
      Thread t3 = new Thread(el);
      t3.start();
      Runnable maarten = new Maarten();
      Thread t4 = new Thread(maarten);
      t4.start();
   }
}
