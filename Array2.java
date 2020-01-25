/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array2;

import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class Array2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     Scanner in = new Scanner(System.in);
     //Question 1
     /*
     int[] grade = new int[10]; //Creating array for the marks
     
     String[] name = new String[10]; //Creating array for student names
     
     int i;
     
     for(i = 0;i<name.length;i++ ){ // Looping to receive a student name and respective mark
         System.out.println("Enter student name:"); 
         name[i] = in.next();
         System.out.println("Enter student grade");
         grade[i] = in.nextInt();
     }
        System.out.println("Do you want to have the marks forward, backward, average or highest and lowest marks?"); //Asking for optioins
        String response = in.next();
        if (response.equalsIgnoreCase("forward")){ //Go to first method Forward
            System.out.println("The order of grades forward is: ");
            Forward(grade);
        }
        else if(response.equalsIgnoreCase("backward")){//Go to Second method Reverse
            System.out.println("The order of grades backward is: ");
            Reverse(grade);
        }
        else if(response.equalsIgnoreCase("average")){//Go to third method Average
            System.out.println("The average of the grades is: ");
            int average = Average(grade);
            System.out.println("The average is: "+ average);
        }
        else if(response.equalsIgnoreCase("min")){ // Go to fourth and fifth method Min and Max
            int min = Min(grade);
            int max = Max(grade);

      
            System.out.println("The student with the lowest mark is " + name[min]); // Takes return from min to print out respective name
         
            System.out.println("The student with the highest mark is " + name[max]);// Takes return from max to rpint out respective name
        }
     
     
     //Question 2
        String[] names = new String[5]; // Create new array for names

        
       String[] Address = new String[5]; // Create new array for Adresses
   
        int name_2 = 0;
        String insert;
        String response_2;
        String new_address;
        for (i =0; i< 5;i++){
            System.out.println("Enter name: "); // Looping to get 5 names and respective adresses
            names[i] = in.nextLine();
            System.out.println("Enter address: ");
            Address[i] = in.nextLine();
        }
        System.out.println("Would you like to view addresses?"); //Asking if you would want to view adresses
        insert = in.next();
        if(insert.equalsIgnoreCase("yes")){ // if response is yes continue, otherwise code stops here
            System.out.println("Please enter the name"); // Entering name
        String person = in.next();
        for(i = 0; i<5;i++){
            if(person.equals(names[i])){ // Finding where the inputted name equals the name of someone in the list
                name_2 = i;
            }
        }
            System.out.println("The address is: " + Address[name_2]); //Taking the index number and printing out teh respective adress
            System.out.println("Do you wish to change the address?");//Asking if you would like to change the address you just found
            response_2 = in.next();
            if(response_2.equalsIgnoreCase("yes")){ //If response is yes continue else code stops here
                System.out.println("Please enter the address you with to change it to:");
                in.nextLine(); // In order for the code not to skip the in.nextLine line
                new_address = in.nextLine();
                System.out.println(new_address);//Take all of the address, along with any spaces in it
                Address[name_2] = new_address;
                System.out.print("New Adresses: "); //printing out the new array with the changed address
                for (i = 0; i < 5; i++) {
                System.out.print( Address[i] + ",");
        }
            }
        }
        System.out.println(" ");
    //Question 3
         int[] val = new int[500]; // Creates an array with 500 spaces
        double one = 0;//Number of ones rolled
        double two = 0;//Number of twos rolles
        double three = 0;//Number of threes rolled
        double four = 0;//number of fours rolled
        double five = 0;//Number of fives rolled
        double six = 0;//Number of sixs rolled

        
        for (i = 0; i < val.length; i++) { 
            val[i] = (int) (6 * Math.random() + 1);// Inputs 500 random digidts between 1-6 into the array
        }
        for (i = 0; i < val.length; i++) {
            if (val[i] == 1) {
                one += 1;//Adds onto the ones
            } else if (val[i] == 2) {
                two += 1;//Adds onto the twos
            } else if (val[i] == 3) {
                three += 1;//Adds onto the threes
            } else if (val[i] == 4) {
                four += 1;//Adds onto the number of fours
            } else if (val[i] == 5) {
                five += 1;//Adds onto the number of fives
            } else {
                six += 1;//Adds onto the number of sixs
            }
        }
        //Does the percentage calculation of rolls for each number divided by 500 times 100% and print sit out
        System.out.println("number of ones, percentage : " + (one/500)*100 + "%");
        System.out.println("number of twos, percentage : " + (two/500)*100 + "%");
        System.out.println("number of threes, percentage : " + (three/500)*100 + "%");
        System.out.println("number of fours, percentage : " + (four/500)*100 + "%");
        System.out.println("number of fives, percentage : " + (five/500)*100 + "%");
        System.out.println("number of sixs, percentage : " + (six/500)*100 + "%");
    */
        //Question 4
     int i;
        double[] array = new double[5]; //Creates new array to hold onto 5 real numbers
        for (i = 0; i < 5; i++) {
            System.out.println("Please enter a number: "); //Gets 5 inputted real numbers
            array[i] = in.nextDouble();
        }

        int temp = 0;//Initializes temp = 0
        for (i = 0; i < 4; i++) { // Since there is an i+1 i goes form 0-3
            if(array[i + 1] < array[i]) { //If the following number is smaller making it out of order the index number is saved to temp
                temp = (i+1);
                if (temp > 0){ //In order to avoid mistakes that may come from later portions also being out of order break after finding the first temp> 0
                    break;
                }
            }
        }
        System.out.println(temp);
        System.out.println("The array is: "); //prints out the array
        for (i = 0;i<array.length;i++){
         System.out.print(array[i]+ " ,");
         }
         System.out.println(" ");
        if (temp > 0) {
            System.out.println("The problem is : " + array[temp]); // Take the index number saved to temp to print out the firts number in the array that is the problem
            // If the index number was 4 it might still be out of orde at the last digit
        } else {
            System.out.println("it's in order");// If temp is it's inital value of zero it is in order since the array can't be out of order on the fiorts number
        }
        
    }
    //Question 1
    public static int Forward(int[] grade){
        int temp;
        
        int i;
        
        int j;
        for (i = 0; i < grade.length; i++) {
            for (j = i + 1; j < grade.length; j++) { 
                if (grade[i] > grade[j]) { // If a number is greater than all the ones being checked its value is saved so that the array can be put in ascending order
                    temp = grade[i];
                    grade[i] = grade[j];
                    grade[j] = temp;
                }
            }
        }
        System.out.print("Ascending Order:"); // Prints out the ascending order
        for (i = 0; i < grade.length - 1; i++) {
            System.out.print( grade[i] + ",");
        }
        return 0;
    
    }
    public static int Reverse (int[] grade){
        int temp;
        int i;
        int j;
        for (i = 0; i < grade.length; i++) {
            for (j = i + 1; j < grade.length; j++) {
                if (grade[i] < grade[j]) { // Similar to Descending order compare values to see if they are less than whihc values to sort the array
                    temp = grade[i];
                    grade[i] = grade[j];
                    grade[j] = temp;
                }
            }
        }
        System.out.print("Descending Order:");//Prints out descending order
        for (i = 0; i < grade.length - 1; i++) {
            System.out.print( grade[i] + ",");
        }
        return 0;
    }
    
    public static int Average (int[] grade){
        int sum = 0;
        int i;
        
        for(i=0;i<grade.length;i++){//Takes sum of all the values in the array
        sum = sum + grade[i];    
        }
        int average = sum/10; // Divide by 10 to get the average
        return average;
    }
    public static int Min (int[] grade){
       int tem = 0;
        int i;
        int low = grade[0];// Initialize the lowest value as the first number
        for (i = 0; i < 10; i++) {
                if (grade[i] < low) {// If any number is smaller than the first number low is saved as that
                    tem = (i);// The index of the current low is also saved
                    low = grade[i];//New low
                }
        }
        
        int min = tem;//Min is saved as the index of the lowest mark

        return min ;
        }
  public static int Max (int[] grade){

        int i;
        int tem = 0;
        int high=grade[0]; //Initilaize the highest value as the first number
        for (i = 0; i < 10; i++) { 
            if (grade[i] > high) {// If any number is bigger than the first number high is saved as that
                    high = grade[i];//Saves the new grade to high
                    tem = i;//saves index of the highest value
                }
            }     
        int max = tem;//max is saved as the index of the final highest 
        return max ;
    }
    }
    

