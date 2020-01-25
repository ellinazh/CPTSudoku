/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Methods Assignment
//Date Completed: Nov 26th 2019
//Ellina Zhang
//Teacher: Mr.Morrison
//Verified by: Sandra Li
//Description: Methods assignment from question 1 to 4
package methods;

import java.util.Random;
import java.util.Scanner;

//Remember to insert breaks
/**
 *
 * @author e.ruiya
 */
public class Methods {

    private static boolean valid;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner in = new Scanner(System.in);

//Question 1
        System.out.println("Enter first side:"); //First side of the triange
        int num1 = in.nextInt();
        System.out.println("Enter second side:");//Second side of the triangle
        int num2 = in.nextInt();
        System.out.println("Enter third side:");//Third side of the triangle
        int num3 = in.nextInt();
        triangle(num1, num2, num3);
//Question 2
        System.out.println("Enter number of kilometers travelled:");
        double kilos = in.nextDouble();
        taxi(kilos);
//Question 3
        System.out.println("In to Cm: Press 1");//All the tables
        System.out.println("Ft to Cm: Press 2");
        System.out.println("Yards to M: Press 3");
        System.out.println("Mi to Km: Press 4 ");
        System.out.println("Cm to In: Press 5");
        System.out.println("Cm to Ft: Press 6");
        System.out.println("M to Yards: Press 7");
        System.out.println("Km to Mi: Press 8");
        int option = in.nextInt();
        conversions(option);
//Question 4
        int stones;
        int stones_2;
        stones = (int) ((30 - 15) * Math.random() + 15);

        System.out.println("There are " + stones + " stones");//Initial number of stones
        while (stones > 0) {
            System.out.println("Take 1,2 or 3 stones");
            stones_2 = in.nextInt();//Enter number of stones to take
            if (Valid(stones_2, stones) == true) {//Ensure a valid move
                stones = stones - stones_2;
                stones = Computer_second(stones);//Go to computer moves
            }
        }
        if (stones == 0) {//After stones equals 0 print out game over and program stops
            System.out.println("Game over");
        }
    }

    //Question 1
    public static void triangle(int num1, int num2, int num3) {
        boolean success = true;
        if ((num1 + num2) > num3 && (num1 + num2) > num3 && (num2 + num3) > num1) {// Using triangle inequality to determine whether the sides will create an actual traingle
            System.out.println(success);
        } else {
            success = false;
            System.out.println(success);
        }

    }

    //Question 2

    public static void taxi(double distance) {
        double fare = 4.00 + ((distance - (1000 * distance) % 140) / 140) * 0.25; //Multiply kilometers by 1000 to get meters, subtract remiander of 140 form the distance and divide by 140 to get how many ranges of $0.25
        System.out.println("the total fare is: $" + fare);//Add 4 dollars onto the calculated $0.25
    }

    //Question 3

    public static void conversions(int option) {
        Scanner in = new Scanner(System.in);
        switch (option) {//Switch statement for each given case
            case 1:
                System.out.println("Enter number of inches:");
                double inches = in.nextInt();
                System.out.println("Number of cm:" + inches * 2.54);//Conversion from inches to centimeters
                break;
            case 2:
                System.out.println("Enter number of feet:");
                double feet = in.nextInt();
                System.out.println("Number of cm:" + feet * 30);//Conversion from feet to centimeters
                break;
            case 3:
                System.out.println("Enter number of yards:");
                double yards = in.nextInt();
                System.out.println("Number of m:" + yards * 0.91);//Conversion from yards to meters
                break;
            case 4:
                System.out.println("Enter number of miles:");//Conversion from miles to kilometers
                double miles = in.nextInt();
                System.out.println("Number of km:" + miles * 0.91);
                break;
            case 5:
                System.out.println("Enter number of centimeters:");
                double cm = in.nextInt();
                System.out.println("Number of in:" + cm / 2.54);//Conversion from centimeters to inches
                break;
            case 6:
                System.out.println("Enter number of centimeters:");
                double centi = in.nextInt();
                System.out.println("Number of ft:" + centi / 30);//Conversion from centimeters to feet
                break;
            case 7:
                System.out.println("Enter number of meters:");
                double m = in.nextInt();
                System.out.println("Number of yards : " + m / 0.91);//Conversion from meters to yards
            case 8:
                System.out.println("Enter number of kilometers:");
                double km = in.nextInt();
                System.out.println("Number of miles:" + km / 0.91);//COnversion from kilometers to miles
                break;
        }
    }
//Question 4

    public static boolean Valid(int stone_number, int stones) { //Check validity of move
        boolean value = false;
        if (stone_number > 3 || stone_number < 1) {
            System.out.println("Not a valid turn");

        } else if (stone_number > 0 && (stone_number < 4) && (stones - stone_number) >= 0) {
            value = true;

        }
        return value;

    }

    public static int Computer_second(int stones) {//All the cases for what a computer should do with a given number of stones
        switch (stones) {
            case 29:
                System.out.println("The computer takes 1 stone");
                stones = 28;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 28:
                System.out.println("The computer takes 3 stones");
                stones = 25;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 27:
                System.out.println("The computer takes 2 stones");
                stones = 25;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 26:
                System.out.println("The computer takes 1 stone");
                stones = 25;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 25:
                System.out.println("The computer takes 1 stone");
                stones = 24;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 24:
                System.out.println("The computer takes 3 stones");
                stones = 23;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 23:
                System.out.println("The computer takes 2 stones");
                stones = 21;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 22:
                System.out.println("The computer takes 1 stone");
                stones = 21;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 21:
                System.out.println("The computer takes 1 stone");
                stones = 20;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 20:
                System.out.println("The computer takes 3 stones");
                stones = 17;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 19:
                System.out.println("The computer takes 2 stones");
                stones = 17;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 18:
                System.out.println("The computer takes 1 stone");
                stones = 17;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 17:
                System.out.println("The computer takes 1 stone");
                stones = 16;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 16:
                System.out.println("The computer takes 3 stones");
                stones = 13;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 15:
                System.out.println("The computer takes 2 stones");
                stones = 13;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 14:
                System.out.println("The computer takes 1 stone");
                stones = 13;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 13:
                System.out.println("The computer takes 1 stone");
                stones = 12;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 12:
                System.out.println("The computer takes 3 stones");
                stones = 9;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 11:
                System.out.println("The computer takes 2 stones");
                stones = 9;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 10:
                System.out.println("The computer takes 1 stone");
                stones = 9;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 9:
                System.out.println("the computer takes 1 stone");
                stones = 8;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 8:
                System.out.println("The computer takes 3 stones");
                stones = 5;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 7:
                System.out.println("The computer takes 2 stones");
                stones = 5;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 6:
                System.out.println("The computer takes 1 stone");
                stones = 5;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 5:
                System.out.println("The computer takes 1 stone");
                stones = 4;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 4:
                System.out.println("The comoputer takes 3 stones");
                stones = 1;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 3:
                System.out.println("The computer takes 2 stones");
                stones = 1;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 2:
                System.out.println("The computer takes 1 stone");
                stones = 1;
                System.out.println("There are " + stones + " stones remaining");
                break;
            case 1:
                System.out.println("The computer takes 1 stone");
                stones = 0;
                System.out.println("You win!");
                break;

        }
        return stones;

    }
}
