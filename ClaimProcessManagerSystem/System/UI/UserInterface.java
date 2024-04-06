package System.UI;


import System.UI.read.search;
import System.UI.read.view;
import System.UI.create.create;
import System.UI.delete.delete;
import System.UI.update.update;

import java.io.*;

import java.util.Scanner;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class UserInterface {



    public static void main(String[] args) throws IOException {
        UserInterface u1 = new UserInterface();
        u1.startMenu();
    }
    static Scanner scanner = new Scanner(System.in);
    public static void startMenu() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("                              Claim Process Managing system                          \n");
            System.out.println("Please select the menu.");
            System.out.println("1. Update claims.");
            System.out.println("2. Search components(Claim,Customer,Insurance card).");
            System.out.println("3. Create claims.");
            System.out.println("4. Delete claims.");
            System.out.println("exit. Close the program.");
            String startMenu = scanner.nextLine();
                switch (startMenu) {
                    case "EXIT":
                    case "exit":
                        System.out.println("Program is now closing...");
                        System.exit(0); // Exit
                    case "1":
                        view.viewClaimSelect();
                        break;
                    case "2":
                        search.searchSelect();
                        break;
                    case "3":
                        create.createClaim();
                        break;
                    case "4":
                        delete.deleteClaim();
                        break;

                    default:
                        System.out.println("Invalid input.");
                        break;
                }
            }

    }












}

