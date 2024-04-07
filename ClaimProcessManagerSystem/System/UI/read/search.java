package System.UI.read;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.Clarification;
import Functions.DAO.CustomerDAO;
import Functions.Search.claimSearch;
import Functions.Search.customerSearch;
import Functions.Search.insuranceCardSearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;

public class search{
    public static void searchSelect() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Plase select the category to search.");
        System.out.println("1. Claim.");
        System.out.println("2. Customer.");
        System.out.println("3. Insurance card.");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();
        while (true){
            switch (searchOption){
                case "1":
                    searchSelectOptionClaim();
                    break;
                case "2":
                    searchSelectOptionCustomer();
                    break;
                case "3":
                    searchSelectOptionInsuranceCard();
                    break;
                case"b":
                    startMenu();
                    break;
                default:
                    System.out.println("Invalid input, please type again.");
            }
        }

    }
    private static void searchSelectOptionClaim() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Claim ID");
        System.out.println("3. Insurance card ID");
        System.out.println("4. Status");
        System.out.println("b. Back to start menu");
        while (true){
            String searchOption = scanner.nextLine();
            switch (searchOption){
                case "b":
                    startMenu();
                    break;
                default:
                    System.out.println("Invalid input, please type again.");
                case "1":
                    System.out.println("Please type the customer ID number. ID number must be more than 7 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify("c-"+input)){
                            ArrayList<Claim> claims = claimSearch.claimSearchCustomerID(input);
                            for(Claim c : claims){
                                System.out.println(c);
                            }
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in customer database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelectOptionClaim();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "2":
                    System.out.println("Please type the claim ID number. ID number must be more than 10 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify("f-"+input)){
                            System.out.println(claimSearch.claimSearchClaimID("f-"));
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in claim database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelectOptionClaim();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "3":
                    System.out.println("Please type the insurance card ID number. ID number must be more than 10 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify(input)){
                            ArrayList<Claim> claims = claimSearch.claimSearchInsuranceCardNum(input);
                            for(Claim c : claims){
                                System.out.println(c);
                            }
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in insurance database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelectOptionClaim();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "4":
                    ArrayList<Claim> claims = null;
                    System.out.println("Please type the claim status you want to search.");
                    System.out.println("New/Processing/Done");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true) {
                        String input = scanner.nextLine();
                        switch (input){
                            case "New":
                                claims = claimSearch.claimSearchStatus(Claim.Status.New);
                                for(Claim c : claims){
                                    System.out.println(c);
                                }
                                break;

                            case "Processing":
                                claims = claimSearch.claimSearchStatus(Claim.Status.Processing);
                                for(Claim c : claims){
                                    System.out.println(c);
                                }
                                break;

                            case "Done":
                                claims = claimSearch.claimSearchStatus(Claim.Status.Done);
                                for(Claim c : claims){
                                    System.out.println(c);
                                }
                                break;
                            case "0": startMenu();
                                break;

                        }
                        System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                        while (true){
                            input = scanner.nextLine();
                            switch (input){
                                case "1":
                                    searchSelectOptionClaim();
                                    break;
                                case"b":
                                case"B":
                                    startMenu();
                                    break;
                                default: System.out.println("Invalid input. Please type again.");
                            }
                        }
                    }
            }
            System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
            while (true){
                String input = scanner.nextLine();
                switch (input){
                    case "1":
                        searchSelectOptionClaim();
                        break;
                    case"b":
                    case"B":
                        startMenu();
                        break;
                    default: System.out.println("Invalid input. Please type again.");
                }
            }
        }

    }
    private static void searchSelectOptionCustomer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ID");
        System.out.println("4. Claim ID");
        System.out.println("b. Back to start menu");
        while (true){
            String searchOption = scanner.nextLine();
            switch (searchOption){
                case "1":
                    System.out.println("Please type the customer ID number. ID number must be more than 7 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify("c-"+input)){
                            Customer target = customerSearch.customerSearchCustomerID(input);
                            System.out.println(target);
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in customer database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelect();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "2":
                    System.out.println("Please type the customer name.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();

                        if(customerSearch.customerSearchClarification(input)){
                            Customer target = customerSearch.customerSearchCustomerName(input);
                            System.out.println(target);
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same name in customer database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelect();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }}
                case "3":System.out.println("Please type the insurance card ID number. ID number must be more than 10 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify(input)){
                            Customer target = customerSearch.customerSearchInsuranceCardID(input);
                            System.out.println(target);
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in insurance card database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelect();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }

                case "4":
                    System.out.println("Please type the claim ID number. ID number must be than 10 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify("c-"+input)){
                            Customer target = customerSearch.customerSearchClaimID(input);
                            System.out.println(target);
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in claim database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelect();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "B":
                case "b":startMenu();
                    break;
                default:System.out.println("Invalid input, please type again.");
            }
        }


    }
    private static void searchSelectOptionInsuranceCard() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the search option.");
        System.out.println("1. Insurance card number");
        System.out.println("2. Card holder full name");
        System.out.println("b. Back to start menu");
        while (true){
            String searchOption = scanner.nextLine();
            switch (searchOption){
                case "1":
                    System.out.println("Please type the card number. Card number must be more than 10 digits.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        if(!Clarification.duplicationClarify(input)){
                            ArrayList<InsuranceCard> card = insuranceCardSearch.insuranceCardSearchCardNumber(input);
                            System.out.println(card);
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same ID in insurance card database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelect();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "2":
                    System.out.println("Please type the card holder's full name.");
                    System.out.println("Please type 0 to back to main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        CustomerDAO customerDAO = new CustomerDAO();
                        ArrayList<Customer> customers= customerDAO.getAll();
                        Customer target = new Customer();
                        for(Customer c : customers){
                            if(c.getFullName().equals(input)){
                                target = c;
                            }

                        }
                        if(target.getInsuranceCard() != null){
                            System.out.println(target.getInsuranceCard());
                            break;
                        }else if(input.equals("0")){
                            startMenu();
                            break;
                        }
                        System.out.println("We cannot find the same full name in database. Please type again. ");
                    }
                    System.out.println("Please type 1 to go search menu.\nPress b to go main menu.");
                    while (true){
                        String input = scanner.nextLine();
                        switch (input){
                            case "1":
                                searchSelectOptionClaim();
                                break;
                            case"b":
                            case"B":
                                startMenu();
                                break;
                            default: System.out.println("Invalid input. Please type again.");
                        }
                    }
                case "b":
                    startMenu();
                default:System.out.println("Invalid input, please type again.");
            }
        }

    }

}
