package System;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.Clarification;
import Functions.DAO.ClaimProcessManagerImpl;
import Functions.DAO.CustomerDAO;
import Functions.DAO.InsuranceCardDAO;
import Functions.Order.ClaimOrder;
import Functions.Search.claimSearch;
import Functions.Search.customerSearch;
import Functions.Search.insuranceCardSearch;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
    public static void starting(){
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
        System.out.println("                              Claim Process Managing system                          ");
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
    }
    public static void startMenu() throws IOException {
        starting();
        while (true) {
            System.out.println("Please select the menu.");
            System.out.println("1. Update and delete claims.");
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

    public class view{
        private static void viewClaimSelect() throws IOException {
            System.out.println("Plase select the order category.");
            System.out.println("1. Claim date");
            System.out.println("2. Claim ID");
            System.out.println("3. Amount's of claim");
            System.out.println("4. Claim status");
            System.out.println("b. Back to start menu");
            String viewOption = scanner.nextLine();

            switch (viewOption) {
                case "b":
                    System.out.println("Back to start menu...");
                    System.out.println("");
                    startMenu();
                    return; // 종료
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



    public static class create{

        private static void createClaim() throws IOException {
            ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
            String IDNum;
            String CardNum;
            String Customer;
            int claimAmount;
            InsuranceCard targetCard = null;
            Customer targetCustomer = null;
            System.out.println("Please type the claim ID number");
            System.out.println("ID should not be existed in our database\n");
            System.out.println("Existed claims ID in our database : ");
            ArrayList<Claim> claimList =  manager.getAll();
            ArrayList<String> claimName = new ArrayList<String>();
            for(Claim cl : claimList){
                System.out.println(cl);
                claimName.add(cl.getID());
            }
            while (true){
                System.out.println("Please type 0, if you want to back to mainmenu.");
                System.out.println("Requirement. ID number should be 10 numbers.");
                IDNum = scanner.nextLine();
                if(IDNum.equals(0)){
                    startMenu();
                } else if ((claimName.contains("f-"+IDNum))||IDNum.length() < 10) {
                    System.out.println("Claim ID number is already existed in our database or cannot satisfy requiremnet, please try again");
                }else {
                    break;
                }

            }
            System.out.println("Please select the card number.");
            int index=0;
            System.out.println("Cards in database : ");
            InsuranceCardDAO InsuranceCardmanager = new InsuranceCardDAO();
            ArrayList<InsuranceCard> cards =  InsuranceCardmanager.getAll();
            for(InsuranceCard card : cards){
                System.out.println("["+index+"]" +" "+card);
                index +=1;

            }
            int cardsSize = cards.size();
            while (true){
                System.out.println("Please type -1, if you want to back to mainmenu.");
                int input = scanner.nextInt();
                try {
                    int number = input;
                    if (number <= cardsSize - 1) {
                        if (number == -1) {
                            startMenu();
                            break;
                        } else {
                            targetCard = cards.get(number);
                        }
                    }
                }catch (NumberFormatException ex){
                    ex.printStackTrace();
                    System.out.println("Invalid input, try again.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            System.out.println("Please select the ID of customer");
            System.out.println("Customers in database : ");
            CustomerDAO CustomerManager = new CustomerDAO();
            ArrayList<Customer> customers = CustomerManager.getAll();
            index=0;
                for(Customer customer : customers){
                    System.out.println("["+index+"]" +" "+customer);
                    index +=1;

                }
                int customersSize = customers.size();
                while (true){
                    System.out.println("Please type -1, if you want to back to mainmenu.");
                    input = scanner.nextInt();
                    try {
                        int number = input;
                        if (number <= customersSize - 1) {
                            if (number == -1) {
                                startMenu();
                                break;
                            } else {
                                targetCustomer = customers.get(number);
                            }
                        }
                    }catch (NumberFormatException ex){
                        ex.printStackTrace();
                        System.out.println("Invalid input, try again.");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
            System.out.println("Please type the amount of claim.");
            claimAmount = scanner.nextInt();
            LocalDate claimDate = null;
            LocalDate examDate =null;
            /*Claim date and Exam date*/
            try {
                System.out.println("Please type the claim date year.");
                int claimYear = scanner.nextInt();
                System.out.println("Please type the claim date month.");
                int claimMonth = scanner.nextInt();
                System.out.println("Please type the claim date day.");
                int claimDay = scanner.nextInt();
                claimDate = LocalDate.of(claimYear, claimMonth, claimDay);

                System.out.println("Please type the exam date year.");
                int examYear = scanner.nextInt();
                System.out.println("Please type the exam date month.");
                int examMonth = scanner.nextInt();
                System.out.println("Please type the exam date day.");
                int examDay = scanner.nextInt();
                examDate = LocalDate.of(examYear, examMonth, examDay);
            } catch (InputMismatchException e) /*Errors when the input is string*/{
                System.out.println("Invalid input! Please enter integers for year, month, and day.");
                createClaim();
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                createClaim();
            }
            String flush = scanner.nextLine();/*Flush scanner for error occuring*/
            System.out.println("Please type the receiver's bank name");
            String bankN = scanner.nextLine();
            System.out.println("Please type the receiver's name ");
            String name = scanner.nextLine();
            System.out.println("Please type the bank number");
            String banknumber = scanner.nextLine();
            String bankingInfo = bankN+"-"+name+"-"+banknumber;

            while (true){
                System.out.println("Please check the information");
                System.out.println("Claim ID : f-"+IDNum);
                System.out.println("Customer information : "+targetCustomer.toString());
                System.out.println("Insurance card information : "+targetCard.toString());
                System.out.printf("Claim date : "+claimDate);
                System.out.printf(",Exam date : "+examDate);
                System.out.printf(",Banking information : "+ bankingInfo);
                System.out.println("\n");
                System.out.println("If information is all correct, type Y");
                System.out.println("Or information is not correct and go back to main, type N");
                String response = scanner.nextLine();
                switch (response){
                    case ("y"):
                    case ("Y"):
                        Claim cl = new Claim(IDNum,claimDate,targetCustomer,targetCard,examDate,claimAmount,bankingInfo);
                        manager.add(cl);
                        targetCustomer.addClaim(cl);
                        CustomerManager.update(targetCustomer);
                        InsuranceCardmanager.update(targetCard);
                        System.out.println("Claim is completely updated in database");
                        System.out.println("Please update the list of document in update menu.");
                        System.out.println("1.Add more claim");
                        System.out.println("b. back to menu");

                        while (true){
                            String sc = scanner.nextLine();
                            switch (sc){
                                case "1":createClaim();
                                case "b":startMenu();
                                default:
                                    System.out.println("Invalid output. Please type again.");
                            }

                        }
                    case "n":
                    case "N":
                        startMenu();
                        break;
                    default:
                        System.out.println("Invalid input, try again.");
                }

            }

        }
    }}}

public class delete{
    private static void deleteClaim() throws IOException {
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

    public class search{
        public static void searchSelect() throws IOException {

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
                        System.out.println("Please type the customer ID number. ID number must be more than 10 digits.");
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
                        System.out.println("Please type the customer ID number. ID number must be more than 10 digits.");
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
                        System.out.println("Please type the card holder's full name.");
                        System.out.println("Please type 0 to back to main menu.");
                        while (true){
                            String input = scanner.nextLine();
                            if(insuranceCardSearch.insuranceCardSearchClarification(input)){
                                System.out.println(insuranceCardSearch.insuranceCardSearchCustomerName(input));
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

        public static class order{
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





            private static void orderClaimDetail(String ID) throws IOException {
                ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
                Claim target = manager.getOne(ID);
                System.out.println("Please type the work");
                System.out.println("1. Update");
                System.out.println("2. Print details of this claim's customer");
                System.out.println("3. Print details of this claim's insurance card");
                System.out.println("b. Back to claim display menu.");
                while (true){
                    String input = scanner.nextLine();
                    switch (input){
                        case "b":
                            view.viewClaimSelect();
                            break;
                            case "1":
                                update.UpdateClaimSelect(target);
                        case "2":
                            System.out.println(target.getInsurancedPerson());
                            orderClaimDetail(ID);
                            break;
                        case "3":
                            System.out.println(target.getCard());
                            orderClaimDetail(ID);
                            break;
                        default: System.out.println("Invalid input, please try again.");
                    }
                }
            }
        }





    public static class update {


        public static void UpdateClaimSelect(Claim target) throws IOException {
            ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
            System.out.println("Please select the update option.");
            System.out.println("1. Status");
            System.out.println("2. List of documents");
            System.out.println("3. Update receiver banking information");
            System.out.println("b. Back to claim display");
            while (true) {
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        System.out.println("Claim's status : " + target.getClaimStatus());
                        System.out.println("Select the status");
                        System.out.println("1. New / 2. Processing / 3.Done");
                        while (true) {
                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    target.setClaimStatus(Claim.Status.New);
                                    manager.update(target);
                                    System.out.println("Status is changed");
                                    System.out.println("1. Back to this claim's update display");
                                    System.out.println("b. Back to claim display");
                                    while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "1":
                                                order.orderClaimDetail(target.getID());
                                                break;
                                            case "b":
                                                view.viewClaimSelect();
                                                break;
                                            default:
                                                System.out.println("Invalid input, please type again.");
                                        }
                                    }
                                case "2":
                                    target.setClaimStatus(Claim.Status.Processing);
                                    manager.update(target);
                                    System.out.println("Status is changed");
                                    System.out.println("1. Back to this claim's update display");
                                    System.out.println("b. Back to claim display");
                                    while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "1":
                                                order.orderClaimDetail(target.getID());
                                                manager.update(target);
                                                break;
                                            case "b":
                                                view.viewClaimSelect();
                                                break;
                                            default:
                                                System.out.println("Invalid input, please type again.");
                                        }
                                    }

                                case "3":
                                    target.setClaimStatus(Claim.Status.Done);
                                    manager.update(target);
                                    System.out.println("Status is changed");
                                    System.out.println("1. Back to this claim's update display");
                                    System.out.println("b. Back to claim display");
                                    while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "1":
                                                order.orderClaimDetail(target.getID());
                                                break;
                                            case "b":
                                                view.viewClaimSelect();
                                                break;
                                            default:
                                                System.out.println("Invalid input, please type again.");
                                        }
                                    }

                                default:
                                    System.out.println("Invalid input, please type again.");
                            }

                        }
                    case "2":
                        ArrayList<String> documents = target.getListOfDocuments();
                        System.out.println();
                        System.out.println("1. Adding document 2. Deleting document");
                        while (true) {
                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    System.out.println("Please type the name of document");
                                    String documentName = scanner.nextLine();
                                    System.out.println("'" + documentName + "'is right?(y/n)");
                                    while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "y":
                                            case "Y":
                                                target.addDocument(target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf");
                                                System.out.println("Document is successfully added to claim.");
                                                System.out.println("1. Back to this claim's update display");
                                                System.out.println("b. Back to claim display");
                                                while (true) {
                                                    input = scanner.nextLine();
                                                    switch (input) {
                                                        case "1":
                                                            order.orderClaimDetail(target.getID());
                                                            break;
                                                        case "b":
                                                            view.viewClaimSelect();
                                                            break;
                                                        default:
                                                            System.out.println("Invalid input, please type again.");
                                                    }
                                                }
                                            case "N":
                                            case "n":
                                                System.out.println("1. Back to this claim's update display");
                                                System.out.println("b. Back to claim display");
                                                while (true) {
                                                    input = scanner.nextLine();
                                                    switch (input) {
                                                        case "1":
                                                            order.orderClaimDetail(target.getID());
                                                            break;
                                                        case "b":
                                                            view.viewClaimSelect();
                                                            break;
                                                        default:
                                                            System.out.println("Invalid input, please type again.");
                                                    }
                                                }
                                            default:
                                                System.out.println("Invalid input, please type again.");
                                        }
                                    }
                                case "2":
                                    System.out.println("Please type the name of document name.");
                                    System.out.println("File format : ClaimId_CardNumber_DocumentName.pdf");
                                    while (true) {
                                        System.out.println("b. Back to main menu.");
                                        input = scanner.nextLine();
                                        String fileName = target.getID() + "_" + target.getCardNum() + "_" + input + ".pdf";
                                        if (target.getListOfDocuments().contains(fileName)) {
                                            System.out.println("Are you sure to delete it permanentely? (y/n)");
                                            while (true) {
                                                input = scanner.nextLine();
                                                switch (input) {
                                                    case "Y":
                                                    case "y":
                                                        target.deleteDocument(fileName);
                                                        System.out.println("Selected file is completely removed.");
                                                        System.out.println("1. Back to this claim's update display");
                                                        System.out.println("b. Back to claim display");
                                                        while (true) {
                                                            input = scanner.nextLine();
                                                            switch (input) {
                                                                case "1":
                                                                    order.orderClaimDetail(target.getID());
                                                                    break;
                                                                case "b":
                                                                    view.viewClaimSelect();
                                                                    break;
                                                                default:
                                                                    System.out.println("Invalid input, please type again.");
                                                            }
                                                        }


                                                    case "N":
                                                    case "n":
                                                        System.out.println("1. Back to this claim's update display");
                                                        System.out.println("b. Back to claim display");
                                                        while (true) {
                                                            input = scanner.nextLine();
                                                            switch (input) {
                                                                case "1":
                                                                    order.orderClaimDetail(target.getID());
                                                                    break;
                                                                case "b":
                                                                    view.viewClaimSelect();
                                                                    break;
                                                                default:
                                                                    System.out.println("Invalid input, please type again.");
                                                            }
                                                        }
                                                    default:
                                                        System.out.println("Invalid input, please type again.");
                                                }
                                            }

                                        } else if (input.equals("b")) {
                                            startMenu();
                                        } else {
                                            System.out.println("There's no matched file name in the database.");
                                        }
                                    }
                                default:
                                    System.out.println("Invalid input, please type again.");
                            }
                        }
                    case "3":
                        System.out.println("Please type the bank name.");
                        String bankName = scanner.nextLine();
                        System.out.println("Please type the customer's name.");
                        String name = scanner.nextLine();
                        System.out.println("Please type the bank number.");
                        String bankNumber = scanner.nextLine();
                        String bankingInfo = bankName + "-" + name + "-" + bankNumber;
                        System.out.println(bankingInfo);
                        System.out.println("Following information is correct?(y/n)");
                        input = scanner.nextLine();
                        switch (input) {
                            case "Y":
                            case "y":
                                target.setReceiverBankingInfo(bankingInfo);
                                System.out.println("Banking information is saved");
                                System.out.println("Status is changed");
                                System.out.println("1. Back to this claim's update display");
                                System.out.println("b. Back to claim order selection");
                                while (true) {
                                    input = scanner.nextLine();
                                    switch (input) {
                                        case "1":
                                            order.orderClaimDetail(target.getID());
                                            break;
                                        case "b":
                                            view.viewClaimSelect();
                                            break;
                                        default:
                                            System.out.println("Invalid input, please type again.");
                                    }
                                }
                            case "N":
                            case "n":
                                System.out.println("Back to menu...");
                                UpdateClaimSelect(target);
                                break;
                            default:
                                System.out.println("Invalid input, please type again.");
                        }
                    case "b":
                }
            }
        }



    }

}

