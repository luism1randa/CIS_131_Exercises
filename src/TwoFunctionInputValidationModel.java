/** 
 *  @author PUT YOUR NAME HERE! 
 *  @author This program demonstrates my understanding of the 2-function input validation model.
 *  @version 1.0  
 
 Complete the below code.  
 Use IR4.java to get the input. 
 
 Ask the user for a time in numeric int HHMM format. 
 
 Answer these subproblems before writing ANY code: 
    1. What makes time in the HHMM format valid or invalid? 
    2. How do you break up HHMM into HH and MM so you can validate HH and MM? 
 
 */

public class TwoFunctionInputValidationModel {
    private final static String ARRIVAL_TIME_QUESTION = "Please enter the vehicle's arrival time (HHMM)";
    
    /** The entry point for this program. 
      * @param args - Null: Not used in this program.  
      */ 
    public static void main(String[] args) {
        System.out.println("************************************************************************************");
        System.out.println("This program demonstrates how to code a standard two-function input validation model.");
        System.out.println("************************************************************************************\n");
        
        int arrivalTime   = getValidTime(ARRIVAL_TIME_QUESTION);
        
        System.out.println("The valid arrival time is: " + arrivalTime);
        
        //TO DO: also print the arrival HH and MM 
        
        System.out.println("\n--- Program Complete ---"); 
    }
    
    //--------------------------------------------------------------------------------------------------
    
    /** Get a valid time from the user in the format HHMM. 
      * @param msg - The message displayed to the user.
      * @return time - Returns a valid time in HHMM format.
      */
    public static int getValidTime(String msg) {

        // Prompt user for a valid time

        int time = IR4.getInteger(msg);

        /*Use the standard two-function input-validation model as shown below in pseudocode: (change as necessary) 
         Declare Integer newValue
         newValue = getInteger(msg)
         
         //continue looping while the function isInvalid(�) returns true
         While isInvalid(newValue, low, high, sentinel)   
             newValue = getInteger(msg)
         End While
         Return newValue
         */

        final String ERROR_MSG = "Time is invalid.";

        while (isInvalidTime(time)){
            System.out.println(ERROR_MSG);
            time = IR4.getInteger(msg);
        }
        
        return time;
   }
    
   /** Determines if the input is valid in HHMM format. 
      * @param time - time to check
      * @return boolean - false if valid, true if invalid. 
      */
   public static boolean isInvalidTime(int time) {
       //Sub-problem: What makes time in the HHMM format valid or invalid? Answer this before writing ANY code. 
       //Sub-problem: How do you break up HHMM into HH and MM so you can test them? Again, answer this before trying to write ANY code.

       final int MAX_HH = 23;
       final int MIN_HH = 0;
       final int MAX_MM = 59;
       final int MIN_MM = 0;

       int hrs = time / 100;
       int min = time % 100;

       if (hrs > MAX_HH || hrs < MIN_HH || min > MAX_MM || min < MIN_MM){
           return true; // invalid time
       }

       return false; //means the time is OK
   }
}