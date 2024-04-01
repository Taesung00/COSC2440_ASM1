package System;

import java.io.*;
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
            System.out.println("1. Adding new claim.");
            System.out.println("2. Deleting claim.");
            System.out.println("3. Searching claim.");
            System.out.println("4. Ordering all claims.");
            System.out.println("5. Chainging claim's status.");
            System.out.println("exit. Close the program.");
                String startMenu = scanner.next();
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
    private void add(){}
    private void delete(){
        System.out.println("Please type the claim id number.");
        System.out.println("b. Back to start menu.");
        String idNum = scanner.next();
    }
    public void update(){
        /*
        * Status,Claim amount와 같은거를 업데이트,
        * */  }
    public void search(){
        System.out.println("Please type the search option.");
        System.out.println("1. Claim.");
        System.out.println("2. Customer.");
        System.out.println("3. Insurance card.");
        String idNum = scanner.next();
        System.out.println("There's no match claim in the database.");
    }
    public void searchClaim(){
        System.out.println("Please type the claim ID.");
    }
    public void searchCustomer(){
        System.out.println("Please type the customer ID");
        System.out.println("Please type the name");
    }
    public void searchInsuranceCard(){
        System.out.println("Please type the card number");
        System.out.println("Please type the owner of card");
        System.out.println("Please type the card holder");

    }


}
