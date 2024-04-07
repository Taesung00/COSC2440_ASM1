package System.UI.read;

import Components.Entities.Claim;
import Functions.Order.ClaimOrder;
import System.UI.UserInterface;
import System.UI.order.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;
import static System.UI.order.order.*;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class view{
    static Scanner scanner = new Scanner(System.in);
    public static void viewClaimSelect() throws IOException {
        ArrayList<Claim> claims = ClaimOrder.claimDateAscending();
        if(claims.isEmpty()){
            System.out.println("Claim database is now empty. Back to main menu.");
            startMenu();
            return;
        }
        System.out.println("Plase select the order category.");
        System.out.println("1. Claim date");
        System.out.println("2. Claim ID");
        System.out.println("3. Amount's of claim");
        System.out.println("4. Claim status");
        System.out.println("b. Back to start menu");
        String viewOption = scanner.nextLine();

        switch (viewOption) {
            case "B":
            case "b":
                System.out.println("Back to start menu...");
                System.out.println("");
                startMenu();
                return;
            case "1":
                order.OrderClaimDate();
                break;
            case "2":
                order.OrderClaimID();
                break;
            case "3":
                order.OrderClaimAmount();
                break;
            case "4":
                order.OrderClaimStatus();
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }}

}

