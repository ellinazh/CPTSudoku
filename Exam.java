/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ellina Zhang
//Jan 22 2020
//Comsci Final exam code
package exam;

import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class Exam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 Scanner in = new Scanner (System.in);        
// TODO code application logic here
    //Question 1
        System.out.println("Question 1");
        int count = 0;
        double total = 0;
        String answer = "yes";
        do{
            System.out.print("Enter Price: "); 
            double price = in.nextDouble();
            System.out.print("Quantity: ");
            int quantity = in.nextInt();
            System.out.println("Would you like to continue");
            answer = in.next();
            total +=price;
            count+= quantity;
        }while(answer.equalsIgnoreCase("yes"));
        System.out.println("Subtotal: $"+total);
        System.out.println("Tax: $"+total*0.13);
        System.out.println("Total: $"+total*1.13);
    //Question 2
        System.out.println("Question 2");
        String[] student = {"Tom","Sandra","Nicolas","Sina","Andrei","Arman","Mustansir","Bardia","Sofia","Justin"};
        int[] test1 = {85,93,77,68,76,87,95,90,82,73};
        String high_student = getHighStudent(student,test1);
    //Question 3
    //Question 4
    //Question 5
 
    }
    public static String getHighStudent(String[] student,int[]test){
    int high = 0;
    int high_student = 0;
    for(int i = 0;i<student.length-1;i++){
        if(i==0){
            high = test[i];
        }
        if(test[i+1]>test[i]){
            high = test[i+1];
            high_student = i+1;
        }
    }
    return student[high_student];
    }
    
}
