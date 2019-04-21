/*
 * Prints a histogram and bar graph of authors and their books.
 */

import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      ArrayList<String> authors = new ArrayList<String>();
      ArrayList<Integer> books = new ArrayList<Integer>();

      System.out.print("Enter a title for the data:");
      String userTitle = scan.nextLine();
      System.out.println("\nYou entered: " + userTitle);

      System.out.println();

      System.out.print("Enter the column 1 header:");
      String c1 = scan.nextLine();
      System.out.println("\nYou entered: " + c1);
      System.out.println();

      System.out.print("Enter the column 2 header:");
      String c2 = scan.nextLine();
      System.out.println("\nYou entered: " + c2);
      System.out.println();

      // Repeatedly ask user for data points
      while (true) {
         System.out.print("Enter a data point (-1 to stop input):");
         String userData = scan.nextLine();
         System.out.println();
         
         if (userData.contains("-1")) {
            System.out.println();
            break;
         }

      // Error if user does not type a comma
         if (userData.indexOf(',') == -1) {
               System.out.println("Error: No comma in string.");
               System.out.println();
         }

      // Error if more than one comma
      // Search the data entered for any commas after the index where the first comma is found
      // The condition evaluates to -1 when there's only 1 comma
         else if (userData.indexOf(',', userData.indexOf(',')+1) > -1) {
               System.out.println("Error: Too many commas in input.");
               System.out.println();
         }

      // Error if no integer entered after comma
      // Catch NumberFormatException or Exception
         else {
            try {
               int userData2 = Integer.parseInt(userData.substring(userData.indexOf(',')+1));
               String name = userData.substring(0, userData.indexOf(','));
               authors.add(name);
               books.add(userData2);
               System.out.println("Data string: " + name);
               System.out.println("Data integer: " + userData2);
               System.out.println();
               
            }
            catch (Exception e) {
               System.out.println("Error: Comma not followed by an integer.");
               System.out.println();
            }
         }//end else
      }//end while

   // Draw a table
      System.out.printf("%33s", userTitle);
      System.out.println();
      System.out.printf("%-20s", c1);
      System.out.print("|");
      System.out.printf("%23s", c2);
      System.out.println();
      for (int i=0; i<44; i++) {
         System.out.print("-");
      }
      System.out.println();

      for (int i=0; i<books.size(); i++) {
         System.out.printf("%-20s", authors.get(i));
         System.out.print("|");
         System.out.printf("%23s", books.get(i));
         System.out.println();
      }
   
      System.out.println();

   // Draw a histogram
      for (int i=0; i < authors.size(); i++) {
         System.out.printf("%20s", authors.get(i));
         System.out.print(" ");
         for (int j=0; j < books.get(i); j++) {
            System.out.print("*");
         }
         System.out.println();
         
      }
   }
}

