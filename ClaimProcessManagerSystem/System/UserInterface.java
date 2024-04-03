package System;

import Components.Claim;
import Components.Customer;
import Components.InsuranceCard;
import Functions.Load;
import Functions.Save;
import Functions.delete;

import static Functions.Clarification.duplicationClarify;
import static Functions.Load.returnClaim;
import static Functions.Load.returnCustomer;


import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class UserInterface {
    static Load li = new Load();

    public static void main(String[] args) throws IOException {
        UserInterface u1 = new UserInterface();
        u1.startMenu();
    }
    static Scanner scanner = new Scanner(System.in);
    private void starting(){
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
        System.out.println("                   Welcome to Claim Process Managing system                          ");
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
    }
    public static void startMenu() throws IOException {

        while (true) {
            System.out.println("Please select the menu.");
            System.out.println("1. View.");
            System.out.println("2. Search.");
            System.out.println("3. Create.");
            System.out.println("4. Delete.");
            System.out.println("5. Update");
            System.out.println("exit. Close the program.");
            String startMenu = scanner.nextLine();
                switch (startMenu) {
                    case "exit":
                        System.out.println("Program is now closing...");
                        return; // 종료
                    case "1":
                        view.viewSelect();
                        break;
                    case "2":
                        search.searchSelect();
                        break;
                    case "3":
                        create.createSelect();
                        break;
                    case "4":
                        delete.deleteSelect();
                        break;
                    case "5":
                        update.updateSelect();
                    default:
                        System.out.println("Invalid input.");
                        break;
                }
                System.out.println("");
            }

    }
    private void orderCategory(){
        System.out.println("Please select the category.");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("b. Back to start menu.");
        String orderMenu = scanner.next();
        switch (orderMenu) {
            case "b":
                System.out.println("");
                return; // 종료
            case "1":
                System.out.println("1");
                // 1번 메뉴 코드를 여기에 추가
                break;
            case "2":
                // 2번 메뉴 코드를 여기에 추가
                break;
            case "3":
                // 3번 메뉴 코드를 여기에 추가
                break;
            case "4":
                // 4번 메뉴 코드를 여기에 추가
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
        System.out.println("");
    }
    private void orderOption(){
        System.out.println("Please select the order option.");
        System.out.println("1. ");
        System.out.println("2. ");
        System.out.println("3. ");
        System.out.println("4. ");
        System.out.println("b. Back to start menu.");
        String orderMenu = scanner.next();
        switch (orderMenu) {
            case "1":
                System.out.println("1");
                // 1번 메뉴 코드를 여기에 추가
                break;
            case "2":
                // 2번 메뉴 코드를 여기에 추가
                break;
            case "3":
                // 3번 메뉴 코드를 여기에 추가
                break;
            case "4":
                // 4번 메뉴 코드를 여기에 추가
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }
        System.out.println("");

    }
    public class view{
        private static void viewSelect() throws IOException {
            System.out.println("Plase select the category you want to view into database.");
            System.out.println("1. Claim");
            System.out.println("2. Customer");
            System.out.println("3. Insurance card");
            System.out.println("b. Back to start menu");
            String viewOption = scanner.nextLine();

            switch (viewOption) {
                case "b":
                    System.out.println("Back to start menu...");
                    System.out.println("");

                    startMenu();
                    return; // 종료
                case "1":
                    viewClaim();
                    break;
                case "2":
                    viewCustomer();
                    break;
                case "3":
                    viewInsuranceCard();
                    break;
                case "4":
                    // 4번 메뉴 코드를 여기에 추가
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }}
        private static void viewInsuranceCard(){}
        private static void viewCustomer(){}
        private void viewCard(){}

        private static void viewClaim(){}
    }



    public static class create{
        public static void createSelect() throws IOException {
            System.out.println("Plase select the category you want to create into database.");
            System.out.println("1. Claim");
            System.out.println("2. Customer");
            System.out.println("3. Insurance card");
            System.out.println("b. Back to start menu");
            String createOption = scanner.nextLine();

            switch (createOption) {
                case "b":
                    System.out.println("Back to start menu...");
                    System.out.println("");
                    startMenu();
                case "1":
                    createClaim();
                    break;
                case "2":
                    createCustomer();
                    break;
                case "3":
                    createCard();
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }}

        private static void createCustomer() throws IOException {
            System.out.println("Please type the customer ID number");
            System.out.println("ID duplication is not accepted");
            System.out.println("Existed customer's ID in our database : ");
            li.printAllFilesStartWith("f-");
            String ID = scanner.nextLine();
            while (true){
                System.out.println("Please type 0, if you want to back to mainmenu.");
                if(ID=="0"){
                    startMenu();
                }
                if(duplicationClarify("f-"+ID)){
                    break;
                }
                System.out.println("Claim ID number is already existed in our database, please try again");
            }
            System.out.println("Please type the customer's full name.");
            String targetFullName = scanner.nextLine();
            System.out.println("Please check the information.");
            System.out.println("Customer's ID: "+ID+",Full name : "+targetFullName);
            while (true){
                System.out.println("If information is correct, please type Y.");
                System.out.println("Or if you want to back to create customer, type N.");
                System.out.println("If you want to back to main menu, type M");
                String select = scanner.nextLine();
                switch (select){
                    case "Y":
                    case "y":
                        Customer c1 = new Customer(ID,targetFullName);
                        System.out.println("Customer is completely saved in database");
                        System.out.println("If you want to add claim, press 1");
                        System.out.println("If you want to add more customer, press 2.");
                        System.out.println("If you want to add insurance card, press 3");
                        System.out.println("If you want to back main menu, type b");

                        while (true){
                            String sc = scanner.nextLine();
                            switch (sc){
                                case "2":createCustomer();
                                case "3":createCard();
                                case "1":createClaim();
                                case "b":startMenu();
                                default:
                                    System.out.println("Invalid output. Please type again.");
                            }

                        }

                    case "N":
                    case "n":
                        createCustomer();
                    case "M":
                    case "m":
                        startMenu();
                }


            }

        }
        private static void createCard() throws IOException{
            int ID;
            String customerID;
            System.out.println("Please type the Insurance card ID number");
            System.out.println("Current added ID should not be existed in our database\n");
            System.out.println("Existed insurance card ID in our database : ");
            li.printAllFilesStartWith("I-");
            while (true){
                System.out.println("Please type 0, if you want to back to mainmenu.");
                ID = scanner.nextInt();
                if(ID==0){
                    startMenu();
                }
                if(duplicationClarify("I-"+ID)){
                    break;
                }
                System.out.println("Insurance card ID number is already existed in our database, please try again");
            }
            System.out.println("Please type the card holder's customer ID");
            System.out.println("Customers in database : ");
            li.printAllFilesStartWith("C-");
            while (true){
                customerID = scanner.nextLine();
                System.out.println("Please type 0, if you want to back to mainmenu.");
                if(customerID == "0"){
                    startMenu();
                }
                if(!duplicationClarify("C-"+customerID)){
                    Customer targetCustomer = Load.returnCustomer("C-"+customerID);
                    System.out.println("Customer is now clarified");
                    break;
                }
                System.out.println("Customer is not existed in our database");
            }
            System.out.println("Please type the policy owner of this card.");
            String policyOwner = scanner.nextLine();
            System.out.println("Please type the expiration year");
            int examYear = scanner.nextInt();
            System.out.println("Please type the expiration month");
            int examMonth = scanner.nextInt();
            System.out.println("Please type the expiration day");
            int examDay = scanner.nextInt();
            LocalDate examDate = LocalDate.of(examYear, examMonth, examDay);
            while (true){
                System.out.println("Please check the information");
                System.out.println("Card ID : C-"+ ID);
                Customer cardHolder = Load.returnCustomer("C-"+ID);
                System.out.println("Card holder information : "+cardHolder.toString());
                System.out.println("Policy owner : "+policyOwner);
                System.out.printf("Exam date : "+examDate);
                System.out.println("\n");
                System.out.println("If information is all correct, type Y");
                System.out.println("Or information is not correct and go back to main, type N");
                String response = scanner.nextLine();
                switch (response){
                    case ("y"):
                    case ("Y"):
                        InsuranceCard card = new InsuranceCard((int)ID,cardHolder,examDate,policyOwner);
                        System.out.println("Claim is completely updated in database");
                        System.out.println("Please update the list of document in update menu.");
                        System.out.println("If you want to add claim, press 1");
                        System.out.println("If you want to add customer, press 2.");
                        System.out.println("If you want to add more insurance card, press 3");
                        System.out.println("If you want to back main menu, type b");

                        while (true){
                            String sc = scanner.nextLine();
                            switch (sc){
                                case "2":createCustomer();
                                case "3":createCard();
                                case "1":createClaim();
                                case "b":startMenu();
                                default:
                                    System.out.println("Invalid output. Please type again.");
                            }

                        }
                    case "n":
                    case "N":
                        System.out.println("Going to main menu...\n");
                        break;
                    default:
                        System.out.println("Invalid input, try again.");
                }

            }



        }

        private static void createClaim() throws IOException {
            int ID;
            String CardNum;
            String Customer;
            int claimAmount;
            InsuranceCard targetCard = null;
            Customer targetCustomer = null;
            System.out.println("Please type the claim ID number");
            System.out.println("ID should not be existed in our database\n");
            System.out.println("Existed claims ID in our database : ");
            li.printAllFilesStartWith("Cl-");
            while (true){
                System.out.println("Please type 0, if you want to back to mainmenu.");
                ID = scanner.nextInt();
                if(ID==0){
                    startMenu();
                }
                if(duplicationClarify("Cl"+ID)){
                    break;
                }
                System.out.println("Claim ID number is already existed in our database, please try again");
            }
            System.out.println("Please type the card number.");
            System.out.println("Cards in database : ");
            li.printAllFilesStartWith("I-");
            while (true){
                CardNum = scanner.nextLine();
                System.out.println("Please type 0, if you want to back to mainmenu.");
                if(CardNum == "0"){
                    startMenu();
                }
                if(!duplicationClarify("I-"+CardNum)){
                    targetCard = Load.returnInsuranceCard("I-"+CardNum);
                    System.out.println("Insurance card is now clarified");
                    break;
                }
                System.out.println("Claim ID number is not existed in our database");
            }
            System.out.println("Please type the ID number of customer");
            System.out.println("Customers in database : ");
            li.printAllFilesStartWith("f-");
            while (true){
                Customer = scanner.nextLine();
                System.out.println("Please type 0, if you want to back to mainmenu.");
                if(Customer == "0"){
                    startMenu();
                }
                if(!duplicationClarify("f-"+Customer)){
                    targetCustomer = Load.returnCustomer("f-"+Customer);
                    System.out.println("Customer is now clarified");
                    break;
                }
                System.out.println("Customer is not existed in our database");

            }
            System.out.println("From now, you can only back after you type the all requirements.");
            System.out.println("Please type the amount of claim.");
            claimAmount = scanner.nextInt();

            /*Claim date and Exam date*/
            System.out.println("Please type the receiver's banking information.");
            String bankingInfo = scanner.nextLine();
            System.out.println("Please type the claim date year.");
            int claimYear = scanner.nextInt();
            System.out.println("Please type the claim date month.");
            int claimMonth = scanner.nextInt();
            System.out.println("Please type the claim date day.");
            int claimDay = scanner.nextInt();
            System.out.println("Please type the exam date year.");
            int examYear = scanner.nextInt();
            System.out.println("Please type the exam date month.");
            int examMonth = scanner.nextInt();
            System.out.println("Please type the exam date day.");
            int examDay = scanner.nextInt();
            LocalDate claimDate = LocalDate.of(claimYear, claimMonth, claimDay);
            LocalDate examDate = LocalDate.of(examYear, examMonth, examDay);
            while (true){
                System.out.println("Please check the information");
                System.out.println("Claim ID : F-"+ID);
                System.out.println("Customer information : "+targetCustomer.toString());
                System.out.println("Insurance card information : "+targetCard.toString());
                System.out.printf("Claim date : "+claimDate);
                System.out.printf("Exam date : "+examDate);
                System.out.println("\n");
                System.out.println("If information is all correct, type Y");
                System.out.println("Or information is not correct and go back to main, type N");
                String response = scanner.nextLine();
                switch (response){
                    case ("y"):
                    case ("Y"):
                        Claim cl = new Claim(ID,claimDate,targetCustomer,targetCard,examDate,claimAmount);
                        System.out.println("Claim is completely updated in database");
                        System.out.println("Please update the list of document in update menu.");
                        System.out.println("If you want to add more claim, press 1");
                        System.out.println("If you want to add customer, press 2.");
                        System.out.println("If you want to add insurance card, press 3");
                        System.out.println("If you want to back main menu, type b");

                        while (true){
                            String sc = scanner.nextLine();
                            switch (sc){
                                case "2":createCustomer();
                                case "3":createCard();
                                case "1":createClaim();
                                case "b":startMenu();
                                default:
                                    System.out.println("Invalid output. Please type again.");
                            }

                        }
                    case "n":
                    case "N":
                        System.out.println("Going to main menu...\n");
                        break;
                    default:
                        System.out.println("Invalid input, try again.");
                }

            }

        }
    }

public class delete{
    private static void deleteSelect() throws IOException {
        System.out.println("Plase the type you want to delete from database.");
        System.out.println("1. Claim");
        System.out.println("2. Customer");
        System.out.println("3. Insurance card");
        System.out.println("b. Back to start menu");
        String deleteOption = scanner.nextLine();
        switch (deleteOption) {
            case "B":
            case "b":
                System.out.println("Back to start menu...");
                System.out.println("");

            case "1":
                deleteClaim();
                break;
            case "2":
                deleteCustomer();
                break;
            case "3":
                deleteInsuranceCard();
                break;
            case "4":
                // 4번 메뉴 코드를 여기에 추가
                break;
            default:
                System.out.println("Invalid input.");
                break;
        }}
    private static void deleteClaim() throws IOException {
        System.out.println("Please type the claim ID");
        /*claim list들*/
        li.printAllFilesStartWith("f-");
        String ID = scanner.nextLine();
        while (true){
            System.out.println("Please type 0, if you want to back to mainmenu.");
            if(ID=="0"){
                startMenu();
            }
            if(!duplicationClarify("F-"+ID)){
                String deleteAffirm = scanner.nextLine();
                System.out.println("Are you sure to delete this data permanently? (y/n)");
                switch (deleteAffirm){
                    case "Y":
                    case "y":
                        Functions.delete.delete("Claims","F-"+ID);
                        System.out.println("Claim is completely deleted.\n Do you want to delete customer and insurance card related with it press Y" +
                                "If you want to back main menu, press b");
                        while (true){
                            String selection = scanner.nextLine();
                            switch (selection){
                                case "Y":
                                case "y":
                                    Claim targetClaim = returnClaim("F-"+ID);
                                    /*연결되어 있는게 해제되게 하는 코드*/
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
                    default:
                        System.out.println("Invalid option. Please type correctly");
                }
                break;
            }
            System.out.println("Claim ID number is already existed in our database, please try again");
        }


    }
    private static void deleteCustomer() throws IOException {
        System.out.println("Please type the customer ID");
        /*claim list들*/
        li.printAllFilesStartWith("c-");
        String ID = scanner.nextLine();
        while (true){
            System.out.println("Please type 0, if you want to back to mainmenu.");
            if(ID=="0"){
                startMenu();
            }
            if(!duplicationClarify("c-"+ID)){
                String deleteAffirm = scanner.nextLine();
                System.out.println("Are you sure to delete this data permanently? (y/n)");
                switch (deleteAffirm){
                    case "Y":
                    case "y":
                        Functions.delete.delete("Customers","c-"+ID);
                        System.out.println("Customer is completely deleted.\n Do you want to delete claims and insurance cards related with it press Y" +
                                "If you want to back main menu, press b");/*나중에 같이 연결성 해제되게 할것*/
                        while (true){
                            String selection = scanner.nextLine();
                            switch (selection){
                                case "Y":
                                case "y":
                                    Customer targetCustomer = returnCustomer("c-"+ID);
                                    /*연결되어 있는게 해제되게 하는 코드*/
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
                    default:
                        System.out.println("Invalid option. Please type correctly");
                }
                break;
            }
            System.out.println("Claim ID number is already existed in our database, please try again");
        }

    }
    private static void deleteInsuranceCard() throws IOException {
        System.out.println("Please type the insurance card ID");
        li.printAllFilesStartWith("I-");
        String ID = scanner.nextLine();
        while (true){
            System.out.println("Please type 0, if you want to back to mainmenu.");
            if(ID=="0"){
                startMenu();
            }
            if(!duplicationClarify("I-"+ID)){
                String deleteAffirm = scanner.nextLine();
                System.out.println("Are you sure to delete this data permanently? (y/n)");
                switch (deleteAffirm){
                    case "Y":
                    case "y":
                        Functions.delete.delete("InsuranceCards","I-"+ID);
                        System.out.println("Insurance card is completely deleted.\n Do you want to delete claims and insurance cards related with it press Y" +
                                "If you want to back main menu, press b");/*나중에 같이 연결성 해제되게 할것*/
                        while (true){
                            String selection = scanner.nextLine();
                            switch (selection){
                                case "Y":
                                case "y":
                                    Customer targetCustomer = returnCustomer("c-"+ID);
                                    /*연결되어 있는게 해제되게 하는 코드*/
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
                    default:
                        System.out.println("Invalid option. Please type correctly");
                }
                break;
            }
            System.out.println("Claim ID number is already existed in our database, please try again");
        }

    }
}

    public class search{
        public static void searchSelect() throws IOException {
            startMenu();
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
                    case "2":
                        searchSelectOptionCustomer();
                    case "3":
                        searchSelectOptionInsuranceCard();
                    case"b":

                }
            }

        }
        private static void searchSelectOptionClaim(){
            System.out.println("Please select the search option.");
            System.out.println("1. Customer ID");
            System.out.println("2. Claim ID");
            System.out.println("3. Insurance card ID");
            System.out.println("4. Status");
            System.out.println("b. Back to start menu");
            while (true){
                String searchOption = scanner.nextLine();
                switch (searchOption){
                    case "1":

                    case "2":

                    case "3":

                    case "4":
                    case "5":
                    case "b":
                    default:System.out.println("Invalid input, please type again.");
                }
            }


        }
        private static void searchSelectOptionCustomer(){
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

                    case "2":

                    case "3":

                    case "4":
                    case "b":
                    default:System.out.println("Invalid input, please type again.");
                }
            }


        }
        private static void searchSelectOptionInsuranceCard(){
            System.out.println("Please select the search option.");
            System.out.println("1. Card number");
            System.out.println("2. Cardholder name");
            System.out.println("3. Policy owner");
            System.out.println("b. Back to start menu");
            while (true){
                String searchOption = scanner.nextLine();
                switch (searchOption){
                    case "1":

                    case "2":

                    case "3":


                    case "b":
                    default:System.out.println("Invalid input, please type again.");
                }
            }

        }
        private void searchCustomer(){
            System.out.println("1. Type the customer ID");
            System.out.println("2. Type the name");
            System.out.println("b. Back to start menu");
            while (true){
                String searchOption = scanner.nextLine();
                switch (searchOption){
                    case "1":

                    case "2":

                    case "b":
                    default:System.out.println("Invalid input, please type again.");
                }
            }

        }
    }




    public void OrderClaimSelect(String ID){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
        String searchOption = scanner.nextLine();

    }
    public void OrderCustomerSelect(String ID){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
        String searchOption = scanner.nextLine();

    }
    public void OrderInsuranceCardSelect(String ID){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
        String searchOption = scanner.nextLine();

    }
    public static class update{
        public static void updateSelect() {
        }

        public void UpdateClaimSelect(String ID){
            System.out.println("Please select the update option.");
            System.out.println("1. Status");
            System.out.println("2. List of documents");
            System.out.println("3. Update receiver banking information");
            System.out.println("b. Back");
            String searchOption = scanner.nextLine();


        }
        public void UpdateCustomerSelect(String ID){
            System.out.println("Please select the update option");
            System.out.println("1. Add Insurance Card");
            System.out.println("2. Add claim");
            System.out.println("b. Back");
            String searchOption = scanner.nextLine();

        }
        public void UpdateInsuranceCardSelect(String ID){
            System.out.println("Please select the update option");
            System.out.println("1. Change expiration date ");
            System.out.println("b. Back");
            String searchOption = scanner.nextLine();


        }

    }





    public ArrayList<String> returnIncludeKeywords(String object, String keywords) {
        ArrayList<String> result = null;
        switch(object){
            case "Claim":
            case "Customer":
            case "InsuranceCard":
                String projectRoot = System.getProperty("user.dir");
                String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" + object + "s/";
                int index = 0;
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(path), keywords + "*.txt")) {
                    for (Path entry: stream) {
                        System.out.printf("%d. ",index);
                        System.out.println(entry.getFileName());
                        result.add(""+entry.getFileName());
                        index+=1;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("It is not a valid option");
                return result;
        }
            return result;
    }


}
