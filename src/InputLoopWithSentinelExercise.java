/** 
 *  @author Luis Miranda
 *  @author This program demonstrates my understanding of a Sentinel loop and the 2-function input validation model.
 *  @version 1.0  
 * 
 Complete the below code.  
 Use IR4.java to get the input.  
 Create Javadoc. Make sure it is correct. 
 */

public class InputLoopWithSentinelExercise {
    private final static String QUESTION = "Please enter a day of the week. (M,Tu,W,Th,F,Sa,Su, or Q to quit)";
    
    private static final String [] D_ABBREVIATIONS = {"q", "m", "tu", "w", "th", "f", "sa", "su"};
    private static final String [] DAYS = {"quit", "Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private static final int INVALID_VALUE = -1;
    
    /** The entry point for this program. 
      * @param args - Not used in this program.  
      */ 
    public static void main(String[] args) {
        System.out.println("************************************************************************************");
        System.out.println("This program demonstrates how to code a standard input loop with a sentinel value.");
        System.out.println("************************************************************************************\n");
        
        
        //Subproblem: Create an input-sentinal value loop. Freitag textbook: p. 102
        //            Q to quit. Don't display Q as a day of the week. 
        //            Ask the user to enter a String, return an Integer representing the day of the week
        //
        //Here is a pseudocode model to follow: 
        //  Integer dayOfWeek = getValidDayOfWeek(QUESTION)  //the priming read
        //  While dayOfWeek not equal to sentinel value's index value
        //      Display "The day of the week is: " + DAYS[dayOfWeek]
        //      dayOfWeek = getValidDayOfWeek(QUESTION)
        //  End-While

        int dayOfWeek = getValidDayOfWeek(QUESTION);
        int SENTINEL = 0;

        while (dayOfWeek != SENTINEL){
            System.out.println("The day of the week is: " + DAYS[dayOfWeek]);
            dayOfWeek = getValidDayOfWeek(QUESTION);
        }

        System.out.println("\n--- Program Complete ---"); 
    }
    
    //--------------------------------------------------------------------------------------------------
    
    /** Get a valid day of the week. 
      * @param msg - The message displayed to the user.
      * @return numericDayOfWeek - Returns a valid day of the week: 0=q, 1=m, 2=tu, 3=w, etc...
      */
    public static int getValidDayOfWeek(String msg) {
        //Subproblem: use the standard 2-function input validation model 
        //            which will return an int representing the day of the week or quit
        
        String day = IR4.getString(msg);        
        //Here is a pseudocode model to follow: 
        //  Display msg 
        //  Input day 
        //  While isInvalidDayOfWeek(day) == INVALID_VALUE 
        //      Display "Invalid day of week."  
        //      Display msg 
        //      Input day 
        //  End-While 

        String ERROR_MSG = "Invalid day of week";

        while (isInvalidDayOfWeek(day) == INVALID_VALUE){
            System.out.println(ERROR_MSG);
            day = IR4.getString(msg);
        }

        int index = isInvalidDayOfWeek(day);
        
        //Sub-problem: What are you trying to return to the calling statement? What are the values? 
        //             Do you already have that information? If not, can you get that information easily? (yes, you can!)
        return index; //change what is being returned to the numeric value representing the day of the week or quit (0-7)!
    }
    
    /** Validates the day entered by the user is valid (or q for quit). 
      * Any word starting with a valid day of the week text value is acceptable. (m for monday, tu for tuesday, etc)
      * @param day - The user's entered value of the day of the week. 
      * @return numericDayOfWeek - 0=quit, 1=m, 2=tu, 3=w, etc... -1=not valid
      */ 
    public static int isInvalidDayOfWeek(String day) {
        //subproblem: how to convert the user input toLowerCase. Look it up: https://docs.oracle.com/javase/8/docs/api/java/lang/String.html
        //subproblem: how to compare 2 strings. Hint: For this exercise, use str.startsWith(...). Look it up using the above link. 
        //  All the user to enter values such as "M", "m", "MoN", "MonDA", etc. Even "MMMMMM" should work! 
        //  Compare the user input day with the values of the D_ABBREVIATIONS array.
        //subproblem: how to compare a string with an array of strings? Hint: Perhaps you need to loop through the array? 

        for (int index = 0; index < D_ABBREVIATIONS.length; index++) {
            if (day.toLowerCase().startsWith(D_ABBREVIATIONS[index]) ){
                return index;
            }
        }

        //return an int representing the day of the week or the invalid value flag
        return INVALID_VALUE; //invalid day of week 
    }   
    
}