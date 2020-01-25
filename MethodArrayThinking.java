/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Method Array Thinkng Question
//Ellina 
//Dec 13 2019
package methodarraythinking;

import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class MethodArrayThinking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
       int[] array = {1,2,3,4,5,6,7,8,9,10};//Inputs the array
        System.out.println("Enter shift number");
       int shift2 = in.nextInt();//Takes the inputted shift number
       int shift = shift2%10;
       shiftArray(shift,array);//Goes to method
    }
    public static void shiftArray(int shift,int[] array){
       int i;
        int[] array2 = new int[10];//Initializes new array for the shifted values  
        if(shift>-1){//Only allows the shift to take place if shoft number is less or equal to the number of elements in th array
       for(i = 0;i<10;i++){
           if((i+shift)>9){//if the shifted number's index goes out of bounds(past 10)
               array2[(i+shift)%10] = array [i];//Since there are 10 elements the number gets saved to its shifted index mod 10( moved to the start)
           }
           else{
               array2[i+shift] = array[i];//If the index number plus shift doesn't go out of bounds the number is only saved to its index+ shift
           }
       }
       
       for( i = 0;i<10;i++){
           System.out.print(array[i]+" ");//Prints out the original array
       }
        System.out.println("");
        for( i = 0;i<10;i++){//Prints out shifted array
           System.out.print(array2[i]+" ");
       }
       
    }
       else{
           System.out.println("Invalid Shift Entry");//If the shift entered is negative prints out that it is an invalid entry
    }    
    }
    
}
