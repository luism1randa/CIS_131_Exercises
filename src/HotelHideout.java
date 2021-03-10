/********************************************************************************************************************
    HotelHideout.java
    Author: Luis Miranda
   
    A fugitive is holed up in a hotel room and the FBI need our help in finding which room(s). 
    The hotel has 60 rooms, numbered from 1 to 60. 
   
    1. The fugitive is not in a room with the lowest 10 room numbers.
    2. The fugitive is not in the highest room number. 
    3. The fugitive is not in a room with the room number having 2 even digits.
    4. The fugitive is not in a room with the room number having 2 odd digits.
    5. The fugitive is not in a room when the second digit is not at least twice as large as the first digit. 
       For example, 12 would be eliminated because 2 is not > (1 * 2), it is equal). 
       For example, 57 would be eliminated because 7 is not > (5 * 2)). 
    6. The fugitive is not in a room that is divisible by 7.
    7. The fugitive is not in a room whose room number digits when switched is not a valid room number in the hotel. 
   
    As you eliminate rooms, print the room number and ALL the reasons why it has been eliminated. You should use these statements: 
       System.out.println("Room number " + i + " is the room we are seeking.");
       System.out.println("Room number " + i + " has been eliminated due to being less than 11."); 
       System.out.println("Room number " + i + " has been eliminated due to both digits being even."); 
       System.out.println("Room number " + i + " has been eliminated due to both digits being odd."); 
       System.out.println("Room number " + i + " has been eliminated due to the second digit not being at least twice as large as the first.");
       System.out.println("Room number " + i + " has been eliminated due to being divisable by 7.");
       System.out.println("Room number " + i + " has been eliminated due to switched digits not being a valid room number (" + newRoomNbr + ").");
   
    You should end up with 1 or more rooms where the fugitive is holed up. 
   
    As you eliminate rooms, print the room number and why it has been eliminated. For example: 
       Room number 12 has been eliminated due to the second digit not being twice as large as the first. 
       Room number 29 has been eliminated due to switched digits not being a valid room number (92 is not a valid room number). 
   
   
   ******************************************************************************************************************
    Required sample output: For each room, from 1 to 60, print all the reasons why it was eliminated from consideration.  
   
       Room number 1 has been eliminated due to being less than 11. 
       
       etc...
       
       Room number 57 has been eliminated due to both digits being odd. 
       Room number 57 has been eliminated due to the second digit not being twice as large as the first. 
       Room number 57 has been eliminated due to switched digits not being a valid room number (75). 
       
       etc..
       
       ATTENTION!
       Room number xx is the room with the fugitive! 
       
   
    If your output does not follow the required format, you will not receive any credit. 
    Think about how you need to structure your program to produce the required output. 
    Think about what kind of array you need and how big it should be. Make it easy to understand.
    Be sure to print the last line of which room contains the fugitive. 
    
  ********************************************************************************************************************/

public class HotelHideout{
   final static int NBR_OF_ROOMS = 60;

   /**
    * The entry point for this program
    * @param args not used in this program
    */
   public static void main(String[] args){

      boolean[] hotel = new boolean[NBR_OF_ROOMS];

      for (int room = 0; room < hotel.length; room++) {
         searchForFugitive(room, hotel);
      }

      revealFugitive(hotel);

   }//end of main ----------------------------------------------------------------------------------------------------

   /**
    * Checks if the fugitive can be in a given room and eliminates the room
    * Also states why the room was eliminated
    * @param room the room being searched
    * @param hotel an array of rooms
    */
   public static void searchForFugitive(int room, boolean[] hotel){
      final boolean ROOM_CLEAR = true;

      final int LOWEST_TEN = 10;
      final int RULE_6_DIVISOR = 7;

      // 1. The fugitive is not in a room with the lowest 10 room numbers.
      if (room <= LOWEST_TEN){
         hotel[room] = ROOM_CLEAR;
         System.out.println("Room number " + room + " has been eliminated due to being less than 11.");
      }

      // 2. The fugitive is not in the highest room number.
      if (room == NBR_OF_ROOMS){
         hotel[room] = ROOM_CLEAR;
         System.out.println("Room number " + room + " has been eliminated due to being the highest room number.");
      }

      if (room > LOWEST_TEN){
         final int FIRST_DIGIT = room / 10;
         final int SECOND_DIGIT = room % 10;

         final boolean FIRST_DIGIT_IS_EVEN = FIRST_DIGIT % 2 == 0;
         final boolean SECOND_DIGIT_IS_EVEN = SECOND_DIGIT % 2 == 0;

         // 3. The fugitive is not in a room with the room number having 2 even digits.
         if (FIRST_DIGIT_IS_EVEN && SECOND_DIGIT_IS_EVEN){
            hotel[room] = ROOM_CLEAR;
            System.out.println("Room number " + room + " has been eliminated due to both digits being even.");
         }

         // 4. The fugitive is not in a room with the room number having 2 odd digits.
         if (!FIRST_DIGIT_IS_EVEN && !SECOND_DIGIT_IS_EVEN){
            hotel[room] = ROOM_CLEAR;
            System.out.println("Room number " + room + " has been eliminated due to both digits being odd.");
         }

         // 5. The fugitive is not in a room when the second digit is not at least twice as large as the first digit.
         if (SECOND_DIGIT <= FIRST_DIGIT * 2){
            hotel[room] = ROOM_CLEAR;
            System.out.println("Room number " + room + " has been eliminated due to the second digit not being at least twice as large as the first.");
         }

         // 6. The fugitive is not in a room that is divisible by 7.
         if (room % RULE_6_DIVISOR == 0){
            hotel[room] = ROOM_CLEAR;
            System.out.println("Room number " + room + " has been eliminated due to being divisible by 7.");
         }

         // 7. The fugitive is not in a room whose room number digits when switched is not a valid room number in the hotel.
         final int NEW_ROOM_NBR = Integer.parseInt(String.valueOf(SECOND_DIGIT) + FIRST_DIGIT);
         if (NEW_ROOM_NBR > NBR_OF_ROOMS){
            hotel[room] = ROOM_CLEAR;
            System.out.println("Room number " + room + " has been eliminated due to switched digits not being a valid room number (" + NEW_ROOM_NBR + ").");
         }
      }
   }

   /**
    * Prints a statement stating what room the fugitive is in
    * @param hotel an array containing all rooms in which the fugitive has already been looked for
    */
   public static void revealFugitive(boolean[] hotel){

      boolean roomCleared;

      // All rooms that have been cleared should be set to true
      // The fugitive will be in the one room set to false
      for (int room = 0; room < hotel.length; room++) {
         roomCleared = hotel[room];

         if (!roomCleared){
            System.out.println("ATTENTION!");
            System.out.println("Room number " + room + " is the room with the fugitive!");
         }
      }
   }
}//end of class