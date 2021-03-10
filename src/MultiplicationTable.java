/*****************************************************************************
  *  Program: Expanded Multiplication Table
  *  Author: (put your name here)
  ****************************************************************************
  *   Sample Output:  
  
   
      What is the low value? (1-10) 
      0
      Invalid value
      What is the low value? 
      1
      What is the high value? (1-20) 
      99
      Invalid value
      What is the high value? 
      9
      
         * |  1  2  3  4  5  6  7  8  9 | *
         ----------------------------------
         1 |  1  2  3  4  5  6  7  8  9 | 1
         2 |  2  4  6  8 10 12 14 16 18 | 2
         3 |  3  6  9 12 15 18 21 24 27 | 3
         4 |  4  8 12 16 20 24 28 32 36 | 4
         5 |  5 10 15 20 25 30 35 40 45 | 5
         6 |  6 12 18 24 30 36 42 48 54 | 6
         7 |  7 14 21 28 35 42 49 56 63 | 7
         8 |  8 16 24 32 40 48 56 64 72 | 8
         9 |  9 18 27 36 45 54 63 72 81 | 9
         ----------------------------------
         * |  1  2  3  4  5  6  7  8  9 | *
   
     Do you want to do this again? (y/n)
     No
   
     ----- Program Complete -----  
   
  *****************************************************************************/ 
public class MultiplicationTable {

    final static int LOW_VAL = 0; // Identifies the low value input by the user
    final static int HIGH_VAL = 1; // Identifies the high value input by the user

    final static int LOW_MIN = 1;
    final static int LOW_MAX = 400;
    final static int HIGH_MIN = 1;
    final static int HIGH_MAX = 400;

    public static void main(String[] args) {
        System.out.println("----- Welcome to the Expanded Multiplication Table program -----\n");



        int low;
        int high;

        do {
            low = getValidValue("What is the low value? (" + LOW_MIN + "-" + LOW_MAX + ")", LOW_VAL);
            high = getValidValue("What is the high value? (" + HIGH_MIN + "-" + HIGH_MAX + ")", HIGH_VAL);
            printMultiplicationTable(low, high);
        } while (IR4.getYorN("Do you want to do this again? (y/n)"));

        
        
        
        System.out.println("\n----- Program Complete -----");
        
    }//end main
    
    //----------------------------------------------------------------------------------------
    
    private static void printMultiplicationTable(int low, int high){
        /*Sample output:
          
         * |  1  2  3  4  5  6  7  8  9 | *
         ----------------------------------
         1 |  1  2  3  4  5  6  7  8  9 | 1
         2 |  2  4  6  8 10 12 14 16 18 | 2
         3 |  3  6  9 12 15 18 21 24 27 | 3
         4 |  4  8 12 16 20 24 28 32 36 | 4
         5 |  5 10 15 20 25 30 35 40 45 | 5
         6 |  6 12 18 24 30 36 42 48 54 | 6
         7 |  7 14 21 28 35 42 49 56 63 | 7
         8 |  8 16 24 32 40 48 56 64 72 | 8
         9 |  9 18 27 36 45 54 63 72 81 | 9
         ----------------------------------
         * |  1  2  3  4  5  6  7  8  9 | *
         
         */    

        final String DIVIDER = "-";

        final int NUM_WIDTH = String.valueOf(high * high).length(); // Width = number of digits of highest product
        final int COL_WIDTH = String.valueOf(high).length(); // Column width = numbeer of digits of column label
        final int UNIT_WIDTH = NUM_WIDTH + 1; // includes number width and space to the right
        final int L_DIV_PAD = COL_WIDTH + 3; // The dashes before the first product in each row
        final int R_DIV_PAD = 2 + COL_WIDTH; // The dashes after the last product in each row
        final int DIV_WIDTH = L_DIV_PAD + (high - low + 1) * UNIT_WIDTH + R_DIV_PAD; // Total width of dividers

        // Header row
        System.out.printf("%" + COL_WIDTH + "s | ", "*");
        for (int i = low; i <= high; i++) {
            System.out.printf("%" + NUM_WIDTH + "d ", i);
        }
        System.out.printf("| %-" + COL_WIDTH + "s\n", "*");

        // Top divider
        for (int i = 0; i < DIV_WIDTH; i++) {
            System.out.print(DIVIDER);
        }
        System.out.println();


        // Product table
        for (int i = low; i <= high; i++) {
            // Header column
            System.out.printf("%"+ COL_WIDTH +"d | ", i);

            // Products
            for (int j = low; j <= high; j++) {
                System.out.printf("%" + NUM_WIDTH + "d ", i * j);
            }

            // Footer Column
            System.out.printf("| %-" + COL_WIDTH + "d\n", i);
        }

        // Bottom divider
        for (int i = 0; i < DIV_WIDTH; i++) {
            System.out.print(DIVIDER);
        }
        System.out.println();

        // Footer row
        System.out.printf("%" + COL_WIDTH + "s | ", "*");
        for (int i = low; i <= high; i++) {
            System.out.printf("%" + NUM_WIDTH + "d ", i);
        }
        System.out.printf("| %-" + COL_WIDTH + "s\n", "*");

        System.out.println();
    }

    /**
     * Prompts the user and obtains an integer
     * @param prompt - message prompting the user
     * @param type - 0 = Low value, 1 = High value
     * @return the value entered by the user
     */
    public static int getValidValue(String prompt, int type){
        int value = IR4.getInteger(prompt);

        while (isInvalid(value, type)){
            System.err.println("Invalid value");
            value = IR4.getInteger(prompt);
        }

        return value;
    }

    /**
     * Checks if a value is valid
     * @param value - the value being checked
     * @param valType - 0 = Low value, 1 = High value
     * @return true if invalid, false if valid
     */
    public static boolean isInvalid (int value, int valType){

        switch (valType){
            case LOW_VAL:
                if (value >= LOW_MIN && value <= LOW_MAX) {
                    return false; // Value is valid
                }
                break;
            case HIGH_VAL:
                if (value >= HIGH_MIN && value <= HIGH_MAX) {
                    return false; // Value is valid
                }
                break;
        }

        return true; // Value is invalid
    }
    
                                
}//end of the program