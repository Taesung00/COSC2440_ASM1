package System;

import Functions.Load;
import Functions.Save;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        UserInterface u1 = new UserInterface();
        u1.startMenu();
    }
    Scanner scanner = new Scanner(System.in);
    private void starting(){
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
        System.out.println("                   Welcome to Claim Process Managing system                          ");
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================");
    }
    private void startMenu(){

        while (true) {
            System.out.println("Please select the menu.");
            System.out.println("1. View.");
            System.out.println("2. Search.");
            System.out.println("3. Create.");
            System.out.println("4. Delete.");
            System.out.println("exit. Close the program.");
            String startMenu = scanner.nextLine();
                switch (startMenu) {
                    case "exit":
                        System.out.println("Program is now closing...");
                        return; // 종료
                    case "1":
                        viewSelect();
                        break;
                    case "2":
                        searchSelect();
                        break;
                    case "3":
                        createSelect();
                        break;
                    case "4":
                        deleteSelect();
                        break;
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

    private void viewSelect(){
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
    public void viewInsuranceCard(){}
    public void viewCustomer(){}
    public void viewCard(){}

    public void viewClaim(){}


    private void createSelect(){
        System.out.println("Plase select the category you want to create into database.");
        System.out.println("1. Claim");
        System.out.println("2. Customer");
        System.out.println("3. Insurance card");
        System.out.println("b. Back to start menu");
        String createOption = scanner.nextLine();

        switch (createOption) {
            case "b":
                startMenu();
                return; // 종료
            case "1":
                createClaim();
                break;
            case "2":
                createCustomer();
                break;
            case "3":
                createInsuranceCard();
                break;
            case "4":
                // 4번 메뉴 코드를 여기에 추가
                break;
            default:
                System.out.println("Invalid input.");
                break;
    }}
    public void createInsuranceCard(){}
    public void createCustomer(){}
    public void createCard(){}

    public void createClaim(){}
    private void deleteSelect(){

            System.out.println("Plase the type you want to delete from database.");
            System.out.println("1. Claim");
            System.out.println("2. Customer");
            System.out.println("3. Insurance card");
            System.out.println("b. Back to start menu");
        String deleteOption = scanner.nextLine();
        switch (deleteOption) {
                case "b":
                    startMenu();
                    return; // 종료
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
    private void deleteClaim(){

    }
    private void deleteCustomer(){

    }
    private void deleteInsuranceCard(){

    }
    public void deleteClaimSelect(String ID){
        String deleteAffirm = scanner.nextLine();
        System.out.println("Are you sure to delete this data permanently? (y/n)");
    }
    public void deleteCustomerSelect(String ID){
        String deleteAffirm = scanner.nextLine();
        System.out.println("Are you sure to delete this data permanently? (y/n)");

    }
    public void deleteInsuranceCardSelect(String ID){
        String deleteAffirm = scanner.nextLine();
        System.out.println("Are you sure to delete this data permanently? (y/n)");
    }



    public void searchSelect(){

        System.out.println("Plase select the category to search.");
        System.out.println("1. Claim.");
        System.out.println("2. Customer.");
        System.out.println("3. Insurance card.");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();
    }
    public void searchSelectOptionClaim(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchSelectOptionCustomer(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchSelectOptionInsuranceCard(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchCustomer(){
        System.out.println("1. Type the customer ID");
        System.out.println("2. Type the name");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchCustomerID(){
        System.out.println("Please type the customer ID");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchCustomerName(){
        System.out.println("Please type the name");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchInsuranceCard(){
        System.out.println("1. Type the card number");
        System.out.println("2. Type the owner of card");
        System.out.println("3. Type the card holder");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();


    }
    public void searchInsuranceCardNum(){
        System.out.println("Please type the card number");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();


    }
    public void searchInsuranceCardHolder(){
        System.out.println("Please type the card holder");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

    }
    public void searchInsuranceCardPolicy(){
        System.out.println("Please type the policy owner");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.nextLine();

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
        System.out.println("2. Change policy owner ");
        System.out.println("b. Back");
        String searchOption = scanner.nextLine();


    }





    private ArrayList<String> returnIncludeKeywords(String object, String keywords) {
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
