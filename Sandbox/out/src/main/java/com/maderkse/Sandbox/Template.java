package com.maderkse.Sandbox;
public class Template {
   final static String TEMPLATE_JAVA = "/src/main/java/com/maderkse/Sandbox/Template.java";
   public static void main (String[] args) {
      System.out.println("Hi, " + Template.class.getSimpleName() + " here!");

      Main main = new Main();
      main.printCodeSnippet(TEMPLATE_JAVA,1,10);
   }
}
