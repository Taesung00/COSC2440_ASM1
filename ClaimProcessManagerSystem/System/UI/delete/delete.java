package System.UI.delete;

import Components.Entities.Claim;
import Functions.DAO.ClaimProcessManagerImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;

public class delete{
    public static void deleteClaim() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
        System.out.println("Please type the claim ID number");
        System.out.println("Existed claims :");
        ArrayList<Claim> claimList = manager.getAll();
        int index = 0;
        for (Claim c : claimList){
            System.out.println("["+index+"]" +" "+c );
            index +=1;
        }
        System.out.println("-1. Back to view menu.");
        int claimSize = claimList.size();
        while (true){
            int input = scanner.nextInt();
            try{
                int number = input;
                if(number<=claimSize-1){
                    if(number == -1){
                        startMenu();
                        break;
                    }else{
                        Claim target = claimList.get(number);
                        System.out.println("Are you sure to delete this data permanently? (y/n)");
                        while (true){
                            String deleteAffirm = scanner.nextLine();
                            switch (deleteAffirm){
                                case "Y":
                                case "y":
                                    manager.delete(target.getID()+".ser");
                                    System.out.println("Claim is completely deleted.\n Do you want to delete other claim, press Y \n" +
                                            "If you want to back main menu, press b");
                                    while (true){
                                        String selection = scanner.nextLine();
                                        switch (selection){
                                            case "Y":
                                            case "y":
                                                delete.deleteClaim();
                                            case "B":
                                            case "b":
                                                startMenu();
                                            default:
                                                System.out.println("Invalid option. Please type correctly");

                                        }

                                    }
                                case "N":
                                case "n":
                                    System.out.println("If you want to back to delete menu, press d");
                                    System.out.println("If you want to back to start menu, press b");
                                    while (true){
                                        String selection = scanner.nextLine();
                                        switch (selection){
                                            case "D":
                                            case "d":
                                                deleteClaim();
                                            case "B":
                                            case "b":
                                                startMenu();
                                            default:
                                                System.out.println("Invalid option. Please type correctly");

                                        }

                                    }
                            }
                        }

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
        System.out.println("Please type 0, if you want to back to mainmenu.");
        String ID = scanner.nextLine();
        if(ID.equals("0")){
            startMenu();
        }

    }

}
