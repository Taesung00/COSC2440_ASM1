package System.UI.delete;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Functions.DAO.ClaimProcessManagerImpl;
import Functions.DAO.CustomerDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class delete{
    public static void deleteClaim() throws IOException {
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
        Scanner scanner = new Scanner(System.in);
        ArrayList<Claim> claimList = manager.getAll();
        if(claimList.isEmpty()){
            System.out.println("There's no claim in the database. Back to main menu.");
            startMenu();
        }
        System.out.println("Please select the claim");
        System.out.println("Existed claims :");
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
                                    CustomerDAO CustomerManager = new CustomerDAO();
                                    Customer targetInsuredCustomer= target.getInsurancedPerson();
                                    targetInsuredCustomer.deleteClaimList(target);
                                    CustomerManager.update(targetInsuredCustomer);
                                    System.out.println(target);

                                    manager.delete(target.getID()+".ser");
                                    System.out.println("Claim is completely deleted.\nDo you want to delete other claim, press Y \n" +
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
                else{
                    System.out.println("Invalid input, try again");
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
