/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Name: Ellina Zhang
//Date Submitted: Nov 13
//Date last edited: Nov 12
//Name of Program: Loops Assingment
//Program Description: 4 questions from loop assigment
//Verified by: 
package loop;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class Loop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner in = new Scanner(System.in);
        //Loops
        //Question 1
        int i = 0;
        for ( i = 0; i <=100; i++){
              System.out.println(i);
    }
        for ( i = 0; i <=100; i++){
              System.out.println(100-i);
    }
        for ( i = 0; i <=50; i++){
              System.out.println(2*i);
    }
        for ( i = 0; i <=49; i++){
              System.out.println(2*i+1);
    }
          for ( i = 0; i <=20; i++){
              System.out.println(6*i);
    }
     //Question 2   
    double total = 0;
     int zeroes = -1;
     int fives =  -1;
     double high = 0;
     double low = 0;
     double count = 0;
     double number = 0;
     while(number >= 0) {
         total += number;
         if (number == 0) {
             zeroes +=1;
             fives +=1;
         }
         else if (number%5 == 0) {
             fives += 1;
             
         }
         if (number > high){
             high = number;
         }
         if (number < low){
             low = number;
         }
         System.out.println("Enter integer:");
         number = in.nextInt();
         if(number >= 0) {
              count +=1;
         }
     };
      
     double average = total/count;
     System.out.println(count);
     System.out.println("Average is: "+ average);
     System.out.println("Total is: " + total);
     System.out.println("Highest number is:  "+ high);
     System.out.println("Lowest number is:  " + low);
     System.out.println("Number of zeroes: " + zeroes);
     System.out.println("Number of multiples of 5: " + fives);
         
             
     //Question 3
        System.out.println("Enter Username:");
     String username = in.next();
        System.out.println("Enter Password:");
     String password = in.next();
     int counter = 0;
     String user = "";
     String pass = "";
     while (!username.equals(user) || !password.equals(pass) && counter <=3 ){
         System.out.println("Enter Username guess:");
         user = in.next();
               System.out.println("Enter Password guess:");
        pass = in.next();
        counter +=1;
            if (counter ==3 ){
                System.out.println("Intruder Alert");
            break;
                    
            }
        }
    if (counter <3){
        System.out.println("Welcome");
    
   }
            
            
    //Question 4
         String response = "no";   
   double wins = 0;
   double games= 0;
   
         do{    
  
      System.out.println("Pick Game Option : Easy, Difficult, Customized");
      String option = in.next();
      int counts = 0;
      int guess = 0;
       wins = wins;
       games = games;
      if (option.equalsIgnoreCase("Easy")){
            Random rand = new Random(); 
        int random = rand.nextInt(100);
        while (counts != 5 && guess != random){
            System.out.println("Please enter a number: ");
             guess = in.nextInt();
             counts +=1;
             if (guess>random){
                 System.out.println("Too high, guess lower");
             }
             else if (guess<random){
                 System.out.println("Too low, guess higher");
             }
             else{
                 System.out.println("Correct");
             }
        }
        if (guess == random){
            wins += 1;
            games += 1;           
        }
        if (counts == 5) {
            games +=1;
        }
        
      }     
      else if (option.equalsIgnoreCase("Difficult")){
        Random rand = new Random(); 
        int random = rand.nextInt(1000);  
        while (counts != 10 && guess != random){
            System.out.println("Please enter number:");
             guess = in.nextInt();
             counts +=1;
              if (guess>random){
                 System.out.println("Too high, guess lower");
             }
             else if (guess<random){
                 System.out.println("Too low, guess higher");
             }
               else{
                 System.out.println("Correct");
             }
        }
        
        if (guess == random){
            wins += 1;
            games += 1;           
        }       
        if (counts==10) {
            games +=1;
        }
        
      }
      else if (option.equalsIgnoreCase("Customized")){
        Random rand = new Random();
        System.out.println("Enter lowest number:");
        int lowest = in.nextInt();
          System.out.println("Enter highest number");
          int highest = in.nextInt();
        System.out.println("Enter number of guesses:");
        int guess_number = in.nextInt();
        int random;
        	random = (int) ((highest + lowest) * Math.random () + lowest);
        while (counts != guess_number && guess != random){
             System.out.println("Please enter a number:"); 
            guess = in.nextInt();
             counts +=1;
              if (guess>random){
                 System.out.println("Too high, guess lower");
             }
             else if (guess<random){
                 System.out.println("Too low, guess higher");
             }
               else{
                 System.out.println("Correct");
             }
        }
        if (guess == random){
            wins += 1;
            games += 1;           
        }
       if (counts==guess_number) {
            games +=1;
        }
        
      }
              

      System.out.println("Do you wish to continue? yes or no");
      response = in.next();
    } while (response.equals("yes"));
        System.out.println("WINS:" + wins);
        System.out.println("TOTAL:"+games);
        double percentage = (wins/games)*100;
        System.out.println("WINS PERCENTAGE: %" + percentage );
    }
    
}
