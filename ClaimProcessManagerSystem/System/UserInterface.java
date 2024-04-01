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
        System.out.println("=====================================================================================\n");
        System.out.println("                   Welcome to Claim Process Managing system                          \n");
        System.out.println("=====================================================================================");
        System.out.println("=====================================================================================\n");
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
    private void createSelect(){
        String createOption = scanner.nextLine();

        System.out.println("Plase select the category you want to create into database.");
        System.out.println("1. Claim");
        System.out.println("2. Customer");
        System.out.println("3. Insurance card");
        System.out.println("b. Back to start menu");
        switch (createOption) {
            case "b":
                startMenu();
                return; // 종료
            case "1":
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
    }}
    private void deleteSelect(){
            String deleteOption = scanner.nextLine();

            System.out.println("Plase the type you want to delete from database.");
            System.out.println("1. Claim");
            System.out.println("2. Customer");
            System.out.println("3. Insurance card");
            System.out.println("b. Back to start menu");
            switch (deleteOption) {
                case "b":
                    startMenu();
                    return; // 종료
                case "1":
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
    }}
    public void searchSelect(){
        System.out.println("Plase select the category to search.");
        System.out.println("1. Claim.");
        System.out.println("2. Customer.");
        System.out.println("3. Insurance card.");
        System.out.println("b. Back to start menu");
        String searchOption = scanner.next();
    }
    public void searchSelectOptionClaim(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
    }
    public void searchSelectOptionCustomer(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
    }
    public void searchSelectOptionInsuranceCard(){
        System.out.println("Please select the search option.");
        System.out.println("1. Customer ID");
        System.out.println("2. Customer name");
        System.out.println("3. Insurance Card ");
        System.out.println("b. Back to start menu");
    }
    public void searchCustomer(){
        System.out.println("Please type the customer ID");
        System.out.println("Please type the name");
        System.out.println("b. Back to start menu");
    }
    public void searchInsuranceCard(){
        System.out.println("Please type the card number");
        System.out.println("Please type the owner of card");
        System.out.println("Please type the card holder");
        System.out.println("b. Back to start menu");

    }
    public void OrderClaimSelect(){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
    }
    public void OrderInsuranceCardSelect(){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
    }
    public void OrderCustomerSelect(){
        System.out.println("Please select the order option.");
        System.out.println("1. order");
    }
    public void CRUDFunctionsSelection(String Object, String ID){


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
