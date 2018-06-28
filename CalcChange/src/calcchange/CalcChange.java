/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcchange;

import java.util.Scanner;

/**
 *
 * @author jasmineherd
 * IS 187 Assignment 1
 * Due: June 11,2018
 */
public class CalcChange {
   static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */


      public static void main(String[]args) {
        

         //variables for coins q=quarter,d=dime etc.
         int p = 0;
         int n = 0;
         int q = 0;
         int d = 0;
         int hd = 0;
         String choice = "";

         System.out.println("Welcome to the change calculator!");
         System.out.print("Do you change(Y/N): ");
         
         choice = sc.nextLine();
         while(!choice.isEmpty() && 
            choice.substring(0,1).equalsIgnoreCase("Y")){
             q = getCoin("quarters");
             d = getCoin("dimes");
             n = getCoin("nickels");
             hd = getCoin("half-dollars");
             p = getCoin("pennies");
             
             coinTotal(q,d,n,hd,p);
             System.out.println("Do You Have More Change?(Y/N)");
             choice = sc.next();
         } 

         System.out.println("Thanks for using the Change Calculator!");
      }
         

    static void coinTotal(int q, int d, int n ,int hd,int p){
        int dollars;
        int cents;
        int totalcents;

        totalcents = ((q * 25) + (d * 10) + (n * 5) + (hd*50)+ p);
        dollars = (totalcents / 100); // - integer division
        cents = (totalcents % 100);

        System.out.println("You have a total of "+ totalcents+ " " +
                "cents, "+ "which is "+dollars+" dollar(s) "+ " and "+ cents + " cent(s)");

    }






     static int getCoin(String coinName){
         int c;

         do{
             try{
                 System.out.println("How many " + coinName + " do you have");
                 c = sc.nextInt();

                 if (c < 0) {
                     System.out.println("You must enter a non-negative integer. "
                             + " Please try again");
                     System.out.println("How many " + coinName + " do you have");

                     c = sc.nextInt();
                     c = 0;
                 }
                }catch(Exception e){

                 System.out.println("Error!Illegal input:"+e.getMessage());
                 sc.nextLine();
                 c= -1;
             }

         } while(c < 0);

         return c;
         }
}