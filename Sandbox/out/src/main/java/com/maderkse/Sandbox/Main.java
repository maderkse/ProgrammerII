package com.maderkse.Sandbox;
import java.util.Date;
import java.util.Calendar;
import java.util.Locale;
import java.text.NumberFormat;
import java.text.DateFormat;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.Console;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
public class Main {

   final String ZANDBAK_JAVA = "/src/main/java/com/maderkse/Sandbox/Main.java";
   final String VERTAAL_NL_PROPERTIES = "/src/main/java/com/maderkse/Sandbox/Vertaal_nl.properties";

   public static void main(String[] args) {
      System.out.println("Hi, " + Main.class.getSimpleName() + " here!");

      Console cl = System.console();

      Main zandbak = new Main();
      //zandbak.playWithDates();
      Method m = null;
      try {
         m = Main.class.getDeclaredMethod("playWithDates",(Class<?>[]) null);
         m.invoke(zandbak,(Object[]) null);
      } catch (NoSuchMethodException | IllegalAccessException  e) {
      } catch (InvocationTargetException e) {
      }

      zandbak.playWithNumbers();
      zandbak.playWithResourceBundles();
   }

   public void playWithResourceBundles() {
      System.out.println("\nLet's play with ResourceBundles");

      System.out.println("Properties file " + VERTAAL_NL_PROPERTIES + ":");
      printCodeSnippet(VERTAAL_NL_PROPERTIES,1,4); 
      System.out.println("Met.....");
      System.out.println("Code snippet uit " + ZANDBAK_JAVA + ":");
      printCodeSnippet(ZANDBAK_JAVA, 
            (getLineNumber() + 3),
            (getLineNumber() + 4));
      System.out.println("\nGeeft als resultaat:");
      Locale lc = new Locale("nl","NL");
      ResourceBundle rb = ResourceBundle.getBundle("src.main.java.com.maderkse.Sandbox.Vertaal",lc);
      System.out.println(rb.getString("Hello"));
   }
   public void playWithDates() {
      System.out.println("\nLet's play with Dates");

      printCodeSnippet(ZANDBAK_JAVA,
            (getLineNumber() + 3),
            (getLineNumber() + 7));
      System.out.println("\nGeeft als resultaat:");
      Locale lc = new Locale("nl","NL");
      Locale.setDefault(lc);
      Date date = new Date(1_000_000_000_000L);
      System.out.println(date);
      Calendar cal = Calendar.getInstance();
      System.out.println(cal.getClass().getSimpleName());
   }
   public void playWithNumbers() {
      System.out.println("\nLet's play with Numbers");

      printCodeSnippet(ZANDBAK_JAVA,
            (getLineNumber() + 3),
            (getLineNumber() + 6));
      System.out.println("\nGeeft als resultaat:");
      float f = 123.56789F;
      NumberFormat nf = NumberFormat.getInstance();
      System.out.println(nf.format(f));
      nf.setMaximumFractionDigits(4);
      System.out.println(nf.format(f));
   }
   public static int getLineNumber() {
      return Thread.currentThread().getStackTrace()[2].getLineNumber();
   }
   public void printCodeSnippet(String file, int firstLine, int lastLine) {
      try(InputStream dis = Main.class.getResourceAsStream(file);
            InputStreamReader isr = new InputStreamReader(dis);
            BufferedReader br = new BufferedReader(isr)) {
         String line = null;
         for(int i = 1; i <= lastLine; i++) {
            line = br.readLine();
            if (line != null) {
               if (i >= firstLine) {
                  System.out.print(i + " ");      
                  System.out.println(line);
               }
            } else {
               break;
            }
         }
      } catch (IOException e) {
      }
   } 
}
