/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.javaact;
import static com.mycompany.javaact.JavaAct.DisplayFirst;
import java.util.Scanner;

class Calculator {
    private int fNum, sNum;
    private int passCode;
    private boolean isSecretUnlocked = false;

    public Calculator(int fNum, int sNum) {
        this.fNum = fNum;
        this.sNum = sNum;
    }

    public void setPassCode(int passCode) {
        this.passCode = passCode;
    }

    public boolean unlockSecret(int attempt) {
        if (attempt == passCode) {
            isSecretUnlocked = true;
            return true;
        }
        return false;
    }

    public void displayMenu() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose an Operation (1-5): ");
        System.out.println("1 - Add");
        System.out.println("2 - Subtract");
        System.out.println("3 - Multiply");
        System.out.println("4 - Divide");
        System.out.println("5 - Power");

        System.out.print("Enter your Choice: ");
        int choice = input.nextInt();
        
        if(choice == 1){
            add();
        }
        if(choice == 2){
            subtract();
        }
        if(choice == 3){
            multiply();
        }
        if(choice == 4){
            divide();
        }
        if (choice == 5){
            handleSecretOperation(input);
        }
        else{
            displayMenu();
        }
        continuePrompt();
    }

    private void handleSecretOperation(Scanner input) {
        System.out.print("Set your password: ");
        int setPass = input.nextInt();
        input.nextLine();
        setPassCode(setPass);

        System.out.print("Enter password to unlock the secret operation: ");
        int attempt = input.nextInt();

        if (unlockSecret(attempt)) {
            power();
        } else {
            System.out.println("Access Denied! We are proceeding with basic operations only!");
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

    private void add() {
        int sum = fNum + sNum;
        System.out.println("Result of " + fNum + " + " + sNum + " = " + sum);
        continuePrompt();
    }

    private void subtract() {
        int diff = fNum - sNum;
        System.out.println("Result of " + fNum + " - " + sNum + " = " + diff);
        continuePrompt();
    }

    private void multiply() {
        int prod = fNum * sNum;
        System.out.println("Result of " + fNum + " * " + sNum + " = " + prod);
        continuePrompt();
    }

    private void divide() {
        if (sNum == 0) {
            System.out.println("Cannot be divide to 0.");
        } else {
            double quot = (double) fNum / sNum;
            System.out.println("Result of " + fNum + " / " + sNum + " = " + quot);
        }
        continuePrompt();
    }

    private void power() {
        double result = Math.pow(fNum, sNum);
        System.out.println("Result of " + fNum + " ^ " + sNum + " = " + result);
    }
}


public class JavaAct {

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

        Calculator calcu = new Calculator(fNum, sNum);
        calcu.displayMenu();
        
        
    }
}
        
