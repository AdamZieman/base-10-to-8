/**
 * Adam Zieman (zieman)
 * Course:  CSCI-241 - Computer Science I
 * Section 001
 * Assignment: 2
 * 
 * Project/Class Description:
 * This program asks the user for an integer in base 10 form.
 * It calculates what the same number will be in base 8
 * and prints it.
 * 
 * Known Bugs: None.
 **/
 
import java.util.Scanner; // for Scanner class

public class Base10To8 {
    public static void main (String[] args) {
        // associate a Scanner with the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Explain the program to the user
        System.out.println("--- Base 8 to Base 10 Conversion Program ---");
        System.out.println("=============================================");
        System.out.println("This program will convert an integer from base 8 into base 10.");
        System.out.println("It assumes that the number entered is 5 digits or less.");
        System.out.println("As output, it will print both numbers.");
        System.out.println("It will also recalculate the base 8 number from the base 10 number.");

        // Ask for original number
        System.out.print("\nEnter base 8 number (no more than 5 digits): ");
        int base8Number = keyboard.nextInt();

        // Make sure number is 5 digits or less by using %100000.
        // Any larger digits will be truncated.
        int amt8Left = base8Number % 100000;
        base8Number = amt8Left;

        // 10's digits: 10000 1000 100 10 1
        // 8's digits:  4096 512 64 8 1

        // First, separate 4096's in the number (will be 2 or fewer)
        int num4096S = base8Number / 10000;

        // Remove 4096's from the number
        amt8Left = amt8Left - num4096S * 10000;

        // get # of 512's in the number
        int num512S = amt8Left / 1000;
        amt8Left = amt8Left - num512S * 1000;

        // get # of 64's in the number
        int num64S = amt8Left / 100;
        amt8Left = amt8Left - num64S * 100;

        // get # of 8's in the number
        int num8S = amt8Left / 10;
        amt8Left = amt8Left - num8S * 10;

        // get 1's
        int num1S = amt8Left;
        
        
        // Calculate base 10 number
        int base10Number = (num4096S * 4096) + (num512S * 512) + (num64S * 64) + (num8S * 8) + num1S;

        // print the original number  and the result
        System.out.println("Original base 8 number = " + base8Number);
        System.out.println("Number in base 10 = " + base10Number);

        // To double-check your work, convert in the other direction:
        int backToOriginal = (num4096S * 10000) + (num512S * 1000) + (num64S * 100) + (num8S * 10) + num1S;
        System.out.println("Base 10 number converted back to original = " + backToOriginal);
    }
}
