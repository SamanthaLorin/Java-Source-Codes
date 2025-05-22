/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaact1;
import static com.mycompany.javaact1.JavaAct1.DisplayFirst;
import java.util.Scanner;


class BasicCalculator {
    protected int fNum, sNum;

    public BasicCalculator(int fNum, int sNum) {
        this.fNum = fNum;
        this.sNum = sNum;
    }

    public void add() {
        System.out.println("Result: " + (fNum + sNum));
    }

    public void subtract() {
        System.out.println("Result: " + (fNum - sNum));
    }

    public void multiply() {
        System.out.println("Result: " + (fNum * sNum));
    }

    public void divide() {
        if (sNum == 0) {
            System.out.println("Cannot divide by zero.");
        } else {
            System.out.println("Result: " + ((double) fNum / sNum));
        }
    }
}


    class AdvancedCalculator extends BasicCalculator {
        private String passCode;
        private boolean isUnlocked;

    public AdvancedCalculator(int fNum, int sNum) {
        super(fNum, sNum);
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }

    public boolean unlockSecret(String attempt) {
        return isUnlocked = attempt.equals(passCode);
    }

    public void power() {
        double result = Math.pow(fNum, sNum);
        System.out.println("Result: " + fNum + " ^ " + sNum + " = " + result);
    }

       public void displayMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose an Operation (1-5): ");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - Power (locked)");
        System.out.print("Enter your Choice: ");
        int choice = input.nextInt();
        input.nextLine();
        
         boolean validChoice = true;
    
    if (choice == 1) {
        add();
    } else if (choice == 2) {
        subtract();
    } else if (choice == 3) {
        multiply();
    } else if (choice == 4) {
        divide();
    } else if (choice == 5) {
        System.out.print("Set passcode: ");
        setPassCode(input.nextLine());

    System.out.print("Enter passcode to unlock: ");
    String attempt = input.nextLine();

    if (unlockSecret(attempt)) {
        power();
    } else {
        System.out.println("Access Denied. Power operation is locked.");
    }
    } else {
    System.out.println("Invalid choice.");
    }
    
     if (validChoice) {
            continuePrompt();
        } else {
            displayMenu();
        }
    
       }
        private void continuePrompt() {
            Scanner input = new Scanner(System.in);
            System.out.print("\nWould you like to do another operation? (y/n): ");
            String response = input.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes")) {
            DisplayFirst();
            displayMenu();
        } else {
            System.exit(0);
        }
    }
    }

public class JavaAct1 {

    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
        System.out.println("Advanced Calculator");
        DisplayFirst();

    }
        static void DisplayFirst(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Number: ");
        int fNum = input.nextInt();

        System.out.print("Enter Second Number: ");
        int sNum = input.nextInt();

        AdvancedCalculator calc = new AdvancedCalculator(fNum, sNum);
        calc.displayMenu();
    }
}
    


