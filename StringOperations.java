/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Ellina Zhang
//String Operators Assigment
//November 28th 2019
//Verfied by:

package stringoperations;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 * @author e.ruiya
 */
public class StringOperations {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       
//Question 1
        
        int i;
        String word ; //Initializes a string variable
        int wordLength;
        do{
        System.out.println("Please enter a word: ");
        word = in.next(); //Allows for input fo a word
        wordLength = word.length(); //Word length given by length operator
            System.out.println("The number of characters in the word is " + wordLength);
        }while(!"done".equals(word));//Going to keep looping until the word done is entered
   
// Question 2
        //a)
        
        System.out.println("Enter the first number"); 
        String num1 = in.next();//Inputting first number as a string
        int Int1 = parseInt(num1);//Parses the number into int
        System.out.println("Enter the second number");
        String num2 = in.next(); //Inputting second number as a string
        int Int2 = parseInt(num2);//Parses number into int
        int product = Int1*Int2; //Product of numbers as variable
        System.out.println("The product is "+ product);//Print out the product
        //b)
        System.out.println("Enter your question"); 
       in.nextLine();
        String question = in.nextLine();//Allows you to enter the question
        System.out.println("Enter your response");
        String answer = in.nextLine();//Allows you to enter a response
        question = question.concat(answer);//Concatenates the question and response, saves to question
        System.out.println(question);//Print out concantenated question

        
        //Question 3
        System.out.println("Please enter a sentence");
        
        String sentence = in.nextLine();//Inputs a sentence
        String sentence_2;
        System.out.println("Please enter the bottom range: ");
        int num3 = in.nextInt();//Enters the first digit(lower bound)
        System.out.println("Please enter the top range");
        int num4 = in.nextInt();//Enters the second number(upper bound)
        if(num4<(sentence.length()+1) && num3>=0){//The second number must be less than the sentence length and the first number must be greater than or equal to 0 in order for there not to be an error
            System.out.println("The letters are: ");
        sentence_2 = sentence.substring(num3,num4);//Creates substring if conditions stated above hold true
            System.out.println(sentence_2);//Prints out substring if conditions stated above hold true
        //Question 4
        //a)
            System.out.println("Please enter a word");
            String w = in.next();//Inputs a word
            int rand =(int) ((w.length()-1)*Math.random());//Initializes a random number from 0 to 1 less than the length of the word
            String w_2 = w.substring(rand,rand+1);//Creates one letter substring
            System.out.println("A character in this word is: " + w_2); //Prints out one random letter from the word
        //b)
            System.out.println("Please enter a sentence: ");
            in.nextLine();
            String letter;
            String sent = in.nextLine();//Inputs a sentence
            int random;
            do{
                random = (int) ((sent.length()-1)*Math.random());//Initializes a random number from 0 to 1 less than the length of the sentence
                letter = sent.substring(random,random+1);//Creates one character substring
                if(!" ".equals(letter)){//As long as the character isn't a space will print out the character
                    System.out.println("The letter is: " + letter);
                    break;
                }
            }while(letter.equals(" "));//The do while loop will keep running if there is a space and will break out when it's a letter
            
        //c)
            
            System.out.println("Input sentence again...:");
            //in.nextLine();
            String sen = in.nextLine();//Inputs a sentence
            String[] parts = sen.split(" ");//Splits the sentence into an array at the space
            int partslength = parts.length;//Saves the length of the array
            int num = (int)(partslength*Math.random());//Randomly generate a number within the range of the length of the array
            System.out.println(parts[num]);//Prints out the randomly selected element, is a word
            
            //Question 5
            System.out.println(" ");
            String let;
            String wo ="";//Initializes an empty string
            do{
                System.out.print("Letter?");
                let = in.next();//let gets a letter
                
                if(!".".equals(let)){//As long as let doen't equal a period
                    wo = wo + let;//word has letter added to the end of it(concatenated)
                System.out.println("Current Word: " + wo );//Prints out the word with the additional letter
                }
                else{
                    System.out.println("Final word: "+ wo);//If a period is entered the final word won't print out the period with the word
                }
            }while(!".".equals(let));
            
            //Question 6
            
            int count = 0; //initializes a count
            System.out.print("Please enter a word:");
            String word_2 = in.next();//Inputes a word
            System.out.print("Please enter a letter:");
            
            String letter_2 = in.next();//Inputs a letter
            String[] words = new String[word_2.length()];//Creates an empty string with length equal to the length of the word
            for( i = 0;i<word_2.length();i++){
            words[i] = word_2.substring(i,i+1);//Saves each letter of the word into the spaces in the array with substrings
            }
           for( i = 0;i<word_2.length();i++){
               if(words[i].equals(letter_2)){//Compare to see when any element in the array equal the inputted letter
                   count++;//Each time values equal the count increases by 1
               }
           }
           if(count==1){
               System.out.println("The letter appears 1 time"); //If count equals 1 print out 'time'
           }
           else if(count>1){
               System.out.println("The letter appears "+ count+ " times");//If count is greater than 1, prints out that number in the sentence
           }
           else{
               System.out.println("The letter doesn't appear in the word");//If count is still its initial 0 the letter doesn't appear
           }


    
}
}
}

