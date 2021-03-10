/*
 Luis Miranda
 CIS 131 - Exercise 6
 
 Use: 
 https://docs.oracle.com/javase/8/docs/api/java/lang/String.html  
 https://docs.oracle.com/javase/tutorial/java/data/strings.html 
 for reference. 
 */
import java.util.Scanner;

public class StringManipulations {
    public static void main(String[] args) {
        System.out.println("This program will demonstrate several ways to manipulate a string.\n");
        
        //Put a do-you-want-to-do-it-again loop around this code.
        do {
            String aString = getValidString(10, 30, "Please enter multiple words totaling 10 to 30 characters.");

            aString = displayOne(aString);  //returns the string trimmed of starting and ending spaces
            displayTwo(aString);
            displayThree(aString);
            displayFour(aString);
            displayFive(aString);
            displaySix(aString);
            displaySeven(aString);
            displayEight(aString);
            displayNine(aString);
            displayTen(aString);
            displayEleven(aString);
        } while (IR4.getYorN("Do you want to do this again? (y/n)"));
        
        System.out.println("\nThis completes our demonstration.");
        
        System.out.println("\n--- Program Complete ---"); 
    }
    
    //--------------------------------------------------------------------------------------------------
    //Complete each of the below functions to print the correct string or show the correct information
    //--------------------------------------------------------------------------------------------------
    
    //code this standard input validation routine using IR4.getString(...) 
    public static String getValidString(int low, int high, String msg){
        final String ERROR_MSG = "Invalid input.";

        String newValue = IR4.getString(msg);

        while (newValue.length() < low || newValue.length() > high){
            System.err.println(ERROR_MSG);
            newValue = IR4.getString(msg);
        }
            
        return newValue;
    }
    
    public static String displayOne(String theString) {
        //trim the spaces from the start and end of the string and return the trimmed string

        theString = theString.trim();

        System.out.println("1. The trimmed length of the string is " + theString.length()  
                               + " characters.  (no spaces beginning or ending the string");

        return theString; //return the trimmed string value
    }
    
    public static void displayTwo(String theString) {
        //use an if statement to display one of the below messages
        if (theString.equals(theString.toUpperCase())){
            System.out.println("2. This string is all uppercase.");
        } else {
            System.out.println("2. This string is not all uppercase.");
        }
    }
    
    public static void displayThree(String theString) {
        //use an if statement to display one of the below messages
        if (theString.equals(theString.toLowerCase())) {
            System.out.println("3. This string is all lowercase.");
        } else {
            System.out.println("3. This string is not all lowercase.");
        }
    }
    
    public static void displayFour(String theString) {
        //convert the string to uppercase
        theString = theString.toUpperCase();
        System.out.println("4. In uppercase the string is: " + theString);
    }
    
    public static void displayFive(String theString) {
        //convert the string to lowercase
        theString = theString.toLowerCase();
        System.out.println("5. In lowercase the string is: " + theString);
    }
    
    public static void displaySix(String theString) {
        //For example: change "ABC123" to "ABC123ABC123"
        //Don't just print it twice, actually change the string and print the changed string.
        String newString = theString + theString;
        System.out.println("6. The string repeated is: " + newString);
    }
    
    public static void displaySeven(String theString) {
        //change "This is a test" to "This#is#a#test"
        theString = theString.replace(" ", "#");
        System.out.println("7. The string with spaces replaced with # is: " + theString);
    }
    
    public static void displayEight(String theString) {
        //use an if statement to display one of the below messages
        if (theString.equals("This is a test")){
            System.out.println("8. Comparing your string with �This is a test� shows they are the same.");
        } else {
            System.out.println("8. Comparing your string with �This is a test� shows they are not the same.");
        }
    }
    
    public static void displayNine(String theString) {
        //Determine if the string starts with the word "Hello"
        if (theString.startsWith("Hello")){
            System.out.println("9. This string starts with the word \"Hello\"");
        } else {
            System.out.println("9. This string does not start with the word \"Hello\"");
        }
    }
    
    public static void displayTen(String theString) {
        //Determine if the string ends with the word "World!"
        if (theString.endsWith("World!")) {
            System.out.println("10. This string ends with the word \"World!\"");
        } else {
            System.out.println("10. This string does not end with the word \"World!\"");
        }
    }
    
    public static void displayEleven(String theString) {
        if (theString.length() >= 5) {
            //If the length of theString is 5 or more:
            char fifthChar = theString.charAt(4);
            System.out.println("11. The 5th character of the string is: " + fifthChar);

        }

        if (theString.length() >= 2) {
            //If the length of theString is 2 or more:
            char secondToLast = theString.charAt(theString.length()-2);
            System.out.println("11. The next to last character of the string is: " + secondToLast);
        }
    }
    
   
}