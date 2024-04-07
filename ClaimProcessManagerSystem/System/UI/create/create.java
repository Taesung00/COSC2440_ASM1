package System.UI.create;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.DAO.ClaimProcessManagerImpl;
import Functions.DAO.CustomerDAO;
import Functions.DAO.InsuranceCardDAO;
import static System.UI.UserInterface.startMenu;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class create{
    public static void createClaim() throws IOException {
        Scanner scanner = new Scanner(System.in);
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
        String IDNum;
        String CardNum;
        String Customer;
        int claimAmount;
        InsuranceCard targetCard = null;
        Components.Entities.Customer targetCustomer = null;
        System.out.println("Please type the claim ID number");
        System.out.println("ID should not be existed in our database\n");
        System.out.println("Existed claims ID in our database : ");
        ArrayList<Claim> claimList =  manager.getAll();
        ArrayList<String> claimName = new ArrayList<String>();
        if(!claimList.isEmpty()){
            for(Claim cl : claimList){
                System.out.println(cl);
                claimName.add(cl.getID());
            }
        }else{
            System.out.println("Claim list is empty.");
        }
        while (true){
            System.out.println("Please type 0, if you want to back to mainmenu.");
            System.out.println("Requirement. ID number should be 10 numbers.");
            IDNum = scanner.nextLine();
            if(IDNum.equals("0")){
                startMenu();
            } else if ((claimName.contains("f-"+IDNum))||IDNum.length() < 10) {
                System.out.println("Claim ID number is already existed in our database or cannot satisfy requiremnet, please try again");
            }else {
                break;
            }

        }
            int index = 0;
                InsuranceCardDAO InsuranceCardmanager = new InsuranceCardDAO();
                System.out.println("Please select the customer");
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
                int input = scanner.nextInt();
                try {
                    int number = input;
                    if (number <= customersSize - 1) {
                        if (number == -1) {
                            startMenu();
                            break;
                        } else {
                            targetCustomer = customers.get(number);
                            targetCard = targetCustomer.getInsuranceCard();
                        }
                    }else{
                        System.out.println("Invalid input, try again");
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
                String flush = scanner.nextLine();/*Flush scanner to avoid error*/
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
                            Claim cl = new Claim(IDNum,claimDate,targetCustomer,targetCustomer.getInsuranceCard(),examDate,claimAmount,bankingInfo);
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
                                    case "B":
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
        }}

