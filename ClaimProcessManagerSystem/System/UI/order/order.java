package System.UI.order;

import Components.Entities.Claim;
import Functions.Order.ClaimOrder;
import System.UI.UserInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;
import static System.UI.update.update.*;


public class order {
    static Scanner scanner = new Scanner(System.in);
    public static void OrderClaimDate(){
        int index = 0;
        ArrayList<Claim> claims = ClaimOrder.claimDateAscending();
        for (Claim c : claims){
            System.out.println("["+index+"]" +" "+c );
            index +=1;
        }
        System.out.println("If you want to select the claim and do more work, type infront number");
        System.out.println("-1. Back to view menu.");
        int claimSize = claims.size();
        while (true){
            int input = scanner.nextInt();
            try{
                int number = input;
                if(number<=claimSize-1){
                    if(number == -1){
                        startMenu();
                        break;
                    }else{
                        Claim target = claims.get(number);
                        orderClaimDetail(target.getID());
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                System.out.println("Invalid input, try again.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void OrderClaimID(){
        int index = 0;
        ArrayList<Claim> claims = ClaimOrder.claimIDAscendingSort();
        for (Claim c : claims){
            System.out.println("["+index+"]" +" "+c );
            index +=1;
        }
        System.out.println("If you want to select the claim and do more work, type infront number");
        System.out.println("-1. Back to view menu.");
        int claimSize = claims.size();
        while (true){
            int input = scanner.nextInt();
            try{
                int number = input;
                if(number<=claimSize-1){
                    if(number == -1){
                        startMenu();
                        break;
                    }else{
                        Claim target = claims.get(number);
                        orderClaimDetail(target.getID());
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                System.out.println("Invalid input, try again.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void OrderClaimStatus(){
        int index = 0;
        ArrayList<Claim> claims = ClaimOrder.claimStatusSort();
        for (Claim c : claims){
            System.out.println("["+index+"]" +" "+c );
            index +=1;
        }
        System.out.println("If you want to select the claim and do more work, type infront number");
        System.out.println("-1. Back to view menu.");
        int claimSize = claims.size();
        while (true){
            int input = scanner.nextInt();
            try{
                int number = input;
                if(number<=claimSize-1){
                    if(number == -1){
                        startMenu();
                        break;
                    }else{
                        Claim target = claims.get(number);
                        orderClaimDetail(target.getID());
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                System.out.println("Invalid input, try again.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void OrderClaimAmount(){
        int index = 0;
        ArrayList<Claim> claims = ClaimOrder.claimAmountAscendingSort();
        for (Claim c : claims){
            System.out.println("["+index+"]" +" "+c );
            index +=1;
        }
        System.out.println("If you want to select the claim and do more work, type infront number");
        System.out.println("-1. Back to view menu.");
        int claimSize = claims.size();
        while (true){
            int input = scanner.nextInt();
            try{
                int number = input;
                if(number<=claimSize-1){
                    if(number == -1){
                        startMenu();
                        break;
                    }else{
                        Claim target = claims.get(number);
                        orderClaimDetail(target.getID());
                    }
                }
            }
            catch (NumberFormatException ex){
                ex.printStackTrace();
                System.out.println("Invalid input, try again.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
