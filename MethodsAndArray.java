/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods.and.array;

import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class MethodsAndArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //Question 1
        System.out.println("Enter gross pay");
        double grosspay = in.nextDouble();//Inputs in gross pay
        boolean afford = checkHousing(grosspay);//checkHousing takes the input and compares to see if it's greater of less than 120,000 returns true or false
        if (afford) {//if the return is true this statement will run meaning the person can afford the house
            System.out.println("They can afford the house");
        } else {//If the statement is false then they can't afford the house and it prints that
            System.out.println("They can't afford the house");
        }
        //Question 2
        int[] marks = {85, 46, 77, 87, 43, 56, 99, 97, 96, 44, 89};//List of marks
        int high = highest(marks);//Goes to highest method
        int low = lowest(marks);//Goes to lowest method
        int average = average(marks);//Goes to average method
        int fail = fail(marks);//Goes to fail method
        System.out.println("Highest mark is " + high);//Prints out the highest mark
        System.out.println("Lowest mark is " + low);//Prints out the lowest makr
        System.out.println("Average is " + average);//Prints out the average mark
        System.out.println(fail + " students failed");//Prints out the number of students who failed
    }

    public static boolean checkHousing(double grosspay) {
        boolean afford = true;//Initializes the afford
        if (grosspay > 120000) {//If it is greater afford is true, they can afford iit
            afford = true;
        } else {//If less than or equal to 120000 afford is false, they can't afford it
            afford = false;
        }
        return afford;
    }

    public static int highest(int[] marks) {
        int high = marks[0];//Initialize high as the the first makr
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] > high) {//If any proceeding mark s gretaer than the first one that is saved to the high and  this continues until the array is traversed
                high = marks[i];
            }
        }
        return high;//The highets value is returned to main method
    }

    public static int lowest(int[] marks) {
        int low = marks[0];   //Initialize the lowest as the first mark
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < low) {//If any proceeding mark is greater than the first one it is saved to low and it contineus until the array is traversed
                low = marks[i];
            }
        }
        return low;//The lowest mark is returned
    }

    public static int average(int[] marks) {
        int sum = 0;//Initialize sum as 0
        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];//Using for loop continue to add elements onto the sum until reaches the end and gets the sum of all the values
        }
        int average = sum / marks.length;//Average is the sum of marks divided by the total length of the array, the number of marks
        return average;//return average to main method
    }

    public static int fail(int[] marks) {
        int fail = 0;//Initikalize number of students that failed
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 50) {//runs through the array, if there is a mark under 50 1 gets added to fail, there's one more student that failed
                fail++;
            }
        }
        return fail;//return the number of students that failed to the main method
    }
}
