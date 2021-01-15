/*
 * CIS 131 Spring 2021
 * Luis Miranda
 *
 * ---
 *
 * This class prints out 6 different 10x10 shapes as specified by the given instructions
 *
 */
public class LoopExercises {
    
    final static String DISPLAY_CHAR  = "# ";
    final static String DISPLAY_BLANK = "  ";
    final static int SIZE = 10;

    public static void main(String[] args){
        displayWelcomeMessage();

        printSubscripts(SIZE,SIZE);                   // Subscripts
        printRectangle(SIZE,SIZE);                    // Rectangle
        printBox(SIZE,SIZE);                          // Box
        printLeftTriangle(SIZE,SIZE);                 // Left-leaning Triangle
        printUpsideDownLeftTriangle(SIZE,SIZE);       // Upside-down Left-leaning Triangle
        printUpsideDownRightSideTriangle(SIZE,SIZE); // Upside-down RightSide Triangle
        printBoxWithDiagonal(SIZE,SIZE);             // Box with diagonal

        System.out.println("\n----- Program Complete -----");
    }

    private static void displayWelcomeMessage() {
        System.out.println("");
        System.out.println("************************************************");
        System.err.println("                 For-Loop Exercises");
        System.out.println("************************************************");
        System.out.println("");
    }

    private static void printSubscripts(int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Subscripts ---");

        for (int r = 0; r < nbrOfRows; r++){
            for (int c = 0; c < nbrOfCols; c++){
                System.out.print(r + "," + c + DISPLAY_BLANK);
            }
            System.out.println("");
        }
    }

    //Display a filled in rectangle
    /*
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
        # # # # # # # # # #
    */
    private static void printRectangle(int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 1 ---");

        //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        // Print a character in every row and column
        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {
                System.out.print(DISPLAY_CHAR);
            }

            // Print new line at end of row
            System.out.println();
        }
    }

    //Display a box
     /*
     # # # # # # # # # #
     #                 #
     #                 #
     #                 #
     #                 #
     #                 #
     #                 #
     #                 #
     #                 #
     # # # # # # # # # #
   */
    private static void printBox (int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 2 ---");

      //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {

                // Print a character only on the first row, last row, first column, last column
                if (row == 0 || row == nbrOfRows - 1){
                    System.out.print(DISPLAY_CHAR);
                } else if ( col == 0 || col == nbrOfCols - 1){
                    System.out.print(DISPLAY_CHAR);
                } else {
                    System.out.print(DISPLAY_BLANK);
                }
            }

            // Print new line at end of row
            System.out.println();
        }

    }

    //Display a left-leaning triangle
    /*
     #
     # #
     # # #
     # # # #
     # # # # #
     # # # # # #
     # # # # # # #
     # # # # # # # #
     # # # # # # # # #
     # # # # # # # # # #
   */
    private static void printLeftTriangle (int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 3 ---");


        //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {

                // Print a character only when the row number is greater or equal to the column number
                if (row >= col){
                    System.out.print(DISPLAY_CHAR);
                }
            }

            // Print new line at end of row
            System.out.println();
        }

    }

    //Display an upside-down left-leaning triangle
    /*
     # # # # # # # # # #
     # # # # # # # # #
     # # # # # # # #
     # # # # # # #
     # # # # # #
     # # # # #
     # # # #
     # # #
     # #
     #
   */
    private static void printUpsideDownLeftTriangle (int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 4 ---");

        //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {

                // Print a character only when the row number is less or equal to the column number
                if (row <= col){
                    System.out.print(DISPLAY_CHAR);
                }
            }

            // Print new line at end of row
            System.out.println();
        }
    }

    //Display an upside-down rightside triangle
    /*
     # # # # # # # # # #
       # # # # # # # # #
         # # # # # # # #
           # # # # # # #
             # # # # # #
               # # # # #
                 # # # #
                   # # #
                     # #
                       #
   */
    private static void printUpsideDownRightSideTriangle (int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 5 ---");

        //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {

                // Using blank spaces to create padding on the left side when the row number
                // is greater than the column number
                if (row <= col){
                    System.out.print(DISPLAY_CHAR);
                } else {
                    System.out.print(DISPLAY_BLANK);
                }
            }

            // Print new line at end of row
            System.out.println();
        }
    }

    //Display a box with a diagonal
    /*
     # # # # # # # # # #
     #               # #
     #             #   #
     #           #     #
     #         #       #
     #       #         #
     #     #           #
     #   #             #
     # #               #
     # # # # # # # # # #
   */
    private static void printBoxWithDiagonal(int nbrOfRows, int nbrOfCols) {
        System.out.println("\n--- " + nbrOfRows + "x" + nbrOfCols + " Shape 6 ---");

        //insert code here... No while-loops, no counters, just 2 nested for-loops if-else and print lines.

        for (int row = 0; row < nbrOfRows; row++) {
            for (int col = 0; col < nbrOfCols; col++) {

                if (row == 0 || row == nbrOfRows - 1){
                    System.out.print(DISPLAY_CHAR);
                } else if ( col == 0 || col == nbrOfCols - 1){
                    System.out.print(DISPLAY_CHAR);
                } else if ( col == nbrOfCols - 1 - row){
                    // Print a character when the column number is equal to the difference
                    // between the total amount of columns and the current row number
                    System.out.print(DISPLAY_CHAR);
                } else {
                    System.out.print(DISPLAY_BLANK);
                }
            }

            // Print new line at end of row
            System.out.println();
        }
    }
    
}//End of Class