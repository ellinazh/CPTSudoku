/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decisionsquiz;
import java.util.*;
/**
 *
 * @author e.ruiya
 */
public class DecisionsQuiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner (System.in);
        //Question 1
        System.out.println("Enter name of month:");
        String month = in.nextLine();
        if (month.equals("January") || month.equals("March") || month.equals("May") || month.equals("July") || month.equals("August") || month.equals("October") || month.equals("December")){
            System.out.println("There are 31 days");
        }
        else if (month.equals("April") || month.equals("June") || month.equals("Septembre") || month.equals("Novembre")){
            System.out.println("There are 30 days");
        }
        else {
            System.out.println("There are 28 days");
        }
        //Question 2
        double base = 85;
        double additional = 30;
        double emergency = 10.25;
        double additional_visit;
        double tax = 0.13;
        System.out.println("Enter number of visits:");
        double visit = in.nextDouble();
        if (visit > 3) {
            additional_visit = visit - 3 ;
            System.out.println("Additional fee: $" + additional_visit*additional);
            System.out.println("Emergency fee :$" + emergency);
            System.out.println("Tax :$" +(base*3 + additional_visit*additional + emergency)*tax);
            System.out.println("Total :$" +(base*3 + additional_visit*additional + emergency)*(1+tax));
        }
        else {
            additional_visit = visit - 3 ;
            System.out.println("Emergency fee: $" + emergency);
            System.out.println("Tax :$" +(base*3 + emergency)*tax);
            System.out.println("Total :$" +(base*3 + emergency)*(1+tax));
        }
        //Question 3
        System.out.println("Enter number of babies :");
        int babies = in.nextInt();
        switch(babies){
        case 2: System.out.println("You have twins");
            break;
        case 3: System.out.println("You have triplets");
            break;
        case 4: System.out.println("You have quadruplets"); 
            break ;
        case 5: System.out.println("You have quintuplets");
            break;
        case 6: System.out.println("You have sextuplets");
            break; 
        default:System.out.println("Error");
        }
                
    }
    
}
