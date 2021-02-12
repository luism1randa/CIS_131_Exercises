// formatting Exercise: Use System.out.format to prit the
// Author: Luis Miranda
import java.util.*;

public class FormatExercise {
    public static void main(String[] args) {
        formatList();
        displayReceipt("Monday", 135, 1.25, 745, 1000, 11.25);
    } 
    
    //----------------------------------------------------------------------------------------------------------
    
    public static void formatList() {
        String BUDGET_ITEM[] = {"Clothing", "Utilities", "Automobile", "Groceries", "Other"};
        double COST[] = {20.00, 92.99, 453.55, 84.76, 7.23};
        
        System.out.format("===========LIST OF BUDGET ITEMS=============\n");
        System.out.format("Item --- Category ---------------- Cost ----\n");
        
        //Create a for loop to loop through the arrays and display the data like 
        //the below. Use the format or printf statement with formatting symbols. 
        /*
         ===========LIST OF BUDGET ITEMS============= 
         Item --- Category ---------------- Cost ----
         1       Clothing                 $ 20.00 
         2       Utilities                $ 92.99 
         3       Automobile               $453.55 
         4       Groceries                $ 84.76 
         5       Other                    $  7.23    */


        for (int i = 0; i < BUDGET_ITEM.length; i++) {
            System.out.printf("%-7d %-24s $%6.2f\n", i+1, BUDGET_ITEM[i], COST[i]);
        }
        
        
        
    }
    
    //----------------------------------------------------------------------------------------------------------
    
    public static void displayReceipt(String dayOfWeek, 
                                      int parkingDuration, 
                                      double rate, 
                                      int aTime, 
                                      int dTime, 
                                      double amountCharged) {
        /* 
         Use the format or printf statement with formatting symbols to print the below receipt.        
         
         *******************************
         Wegougem Parking Garage 
         Sales Receipt
         *******************************
         Day of Week: Monday
         Rate: $1.25 per 15 minute interval
         
         Arrival Time:      745
         Departure Time:   1000
         Parking Duration:  135 minutes
         
         Amount Charged: $11.25
         *******************************
         */
        
        
        System.out.println("\n\n\n");
        System.out.println("*****************************");
        System.out.println("  Wegougem Parking Garage");
        System.out.println("       Sales Reciept");
        System.out.println("*****************************");


        System.out.printf("Day of Week: %s\n", dayOfWeek);
        System.out.printf("Rate: $%.2f per 15 minute interval\n", rate);
        System.out.println();
        System.out.printf("Arrival Time: %8d\n", aTime);
        System.out.printf("Departure Time: %6d\n", dTime);
        System.out.printf("Parking Duration: %4d minutes\n", parkingDuration);
        System.out.println();
        System.out.printf("Amount Charged: $%.2f\n", amountCharged);
        
        
        System.out.println("*****************************");
        System.out.println(""); 
    }
    
}//end of class
