/* User Login Program
   Riverz Flores 
   September 7, 2017
   This program will get will ask for a user login and print out
   to a text file. The text file will show whether or not the 
   user inputted correct/valid information.
*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

   class UserLogin {
      
      //variable to hold user input
      static String LoginFromUser;
      
      //Initially report is empty
      static String report = "";
      

      public static void main(String[] args) throws IOException {
            
            
            //Path of the file to write the output
            final String FILE = "file.txt";
            
            //Access the output file
            FileWriter outputDataFile = new FileWriter(FILE);
            PrintWriter outputFile = new PrintWriter(outputDataFile);
            
            //Calling all methods
            greetUser();
            readUser();
            checkValidity();
            printUser();
            printReport(outputFile);
      
      }
      
      
      //Default constructor
      public UserLogin(){
      }
  

      //Method to greet the user
      public static void greetUser() {
      
         System.out.println("This program takes a user login, following the valid requirements.");
      
      }

      //This method reads the user input information into a variable LoginFromUser
      public static void readUser() {
      
         LoginFromUser = new Scanner(System.in).next();
         
      
      }
        
      //This method checks the validity of the user LoginFromUser with different methods
      public static void checkValidity(){
      
         checkCase();
         checkDigit();
         checkSpecialCaseLetter();
         checkLength();
         
      }
        
      //This methods checks for uppercase and lower case letters
      public static void checkCase() {
      
         if (LoginFromUser.equals(LoginFromUser.toLowerCase())) {
         
            addToReport("\n-- no uppercase letter");
         
         }
         if (LoginFromUser.equals(LoginFromUser.toUpperCase())) {
         
            addToReport("\n-- no lowercase letter");
         
         }
      }
      
      //Checks to see how long the user input is and if its too small
      public static void checkLength() {
      
         if (LoginFromUser.length() < 5) {
         
            addToReport("-- too short (minimum of 5 characters)");
         
         }
      }
      
      //This method checks for any special characters
      public static void checkSpecialCaseLetter() {
      
         if (!(LoginFromUser.contains("#") || LoginFromUser.contains("@") || LoginFromUser.contains("$") || LoginFromUser.contains("!"))) {
         
            addToReport("-- invalid special character");
         }
      }
      
      //This method checks to see if any numbers were in the user input
      public static void checkDigit() {
      
         boolean digit = false;
         
         for (int i = 0; i < LoginFromUser.length(); i++) {
         
            if (LoginFromUser.charAt(i) >= '0' && LoginFromUser.charAt(i) <= '9') {
         
               digit = true;
         
               break;
            }
         }
         
         if(!digit){
         
         addToReport("-- no digit");
         
         }
      }
        
      //This method adds the results to report
      public static void addToReport(String str){
      
         report = report+str+"\n";
      
      }
        
      //This method prints the report to a text file
      public static void printReport(PrintWriter outputFile) throws IOException{
      
            outputFile.printf("Riverz Flores \nHomework 1 - User Login\n\n");
            outputFile.printf("Login : "+LoginFromUser );
            
            if(report.isEmpty()){
         
            outputFile.printf(" (Valid)");
         }
         
         else{
         
            outputFile.printf(" (invalid)");
            
            outputFile.printf(report);
         }

            
         outputFile.close();
      }
        
      //This method prints the complete report on the console
      public static void printUser(){
      
         System.out.print("Login : "+LoginFromUser );
         
         if(report.isEmpty()){ //checking if string is empty
         
            System.out.println(" (Valid)");
         }
         
         else{
         
            System.out.println(" (invalid)");
            
            System.out.println(report);
         }
      }
      
   }//End of UserLogin Classs
    