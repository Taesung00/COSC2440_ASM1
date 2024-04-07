package System.UI.update;

import Components.Entities.Claim;
import Functions.DAO.ClaimProcessManagerImpl;
import System.UI.UserInterface;
import System.UI.read.view;
import System.UI.order.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static System.UI.UserInterface.startMenu;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class update {

    public static void orderClaimDetail(String ID) throws IOException {
        Scanner scanner = new Scanner(System.in);
        ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
        Claim target = manager.getOne(ID);
        System.out.println("Please type the work");
        System.out.println("1. Update");
        System.out.println("2. Print details of this claim's customer");
        System.out.println("3. Print details of this claim's insurance card");
        System.out.println("b. Back to claim display.");
        while (true){
            String input = scanner.nextLine();
            switch (input){
                case "B":
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
                    if(target.getCard() == null){
                        System.out.println("Card is not existed in this claim.");
                    }else{
                        System.out.println(target.getCard());
                    }
                    orderClaimDetail(ID);
                    break;
                default: System.out.println("Invalid input, please try again.");
            }
        }
    }



    public static void UpdateClaimSelect(Claim target) throws IOException {
        Scanner scanner = new Scanner(System.in);
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
                                            orderClaimDetail(target.getID());
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
                                            orderClaimDetail(target.getID());
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
                                            orderClaimDetail(target.getID());
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
                    if(documents.isEmpty()){
                        System.out.println("Document list is empty.");
                        System.out.println("1. Adding document    b. Back to claim display");
                        while (true){
                            input = scanner.nextLine();
                            switch (input){
                                case "1":
                                    System.out.println("Please type the name of document");
                                    String documentName = scanner.nextLine();
                                    System.out.println("Please type the detail text of document");
                                    String documentText = scanner.nextLine();
                                    System.out.println("'" + documentName + ": "+documentText+" is right?(y/n)");
                                    ArrayList<String> fileNames = manager.getAllPDFFileNames();
                                    if(fileNames.contains(target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf")){
                                        System.out.println("File name is duplicated. Back to update prompt.");
                                        UpdateClaimSelect(target);
                                        break;
                                    }else{
                                        while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "y":
                                            case "Y":
                                                manager.wirtePDFFiles(target,target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf",documentText);
                                                target.addDocument(target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf");
                                                manager.update(target);
                                                System.out.println("Document is successfully added to claim.");
                                                System.out.println("1. Back to this claim's update display");
                                                System.out.println("b. Back to claim display");
                                                while (true) {
                                                    input = scanner.nextLine();
                                                    switch (input) {
                                                        case "1":
                                                            orderClaimDetail(target.getID());
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
                                                            orderClaimDetail(target.getID());
                                                            break;
                                                        case "B":
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
                                    }
                                case"b":
                                case "B": view.viewClaimSelect();
                                    break;
                                default:System.out.println("Invalid input, please try again.");
                            }
                        }




                    }else{

                        System.out.println(documents);
                        System.out.println();
                        System.out.println("1. Adding document 2. Deleting document b.Back to claim display");
                        while (true) {
                            input = scanner.nextLine();
                            switch (input) {
                                case "1":
                                    System.out.println("Please type the name of document");
                                    String documentName = scanner.nextLine();
                                    System.out.println("Please type the detail text of document");
                                    String documentText = scanner.nextLine();
                                    System.out.println("'" + documentName + ": "+documentText+" is right?(y/n)");
                                    ArrayList<String> fileNames = manager.getAllPDFFileNames();
                                    if(fileNames.contains(target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf")){
                                        System.out.println("File name is duplicated. Back to update prompt.");
                                        UpdateClaimSelect(target);
                                        break;
                                    }else{                                while (true) {
                                        input = scanner.nextLine();
                                        switch (input) {
                                            case "y":
                                            case "Y":
                                                manager.wirtePDFFiles(target,target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf",documentText);
                                                target.addDocument(target.getID() + "_" + target.getCardNum() + "_" + documentName + ".pdf");
                                                manager.update(target);
                                                System.out.println("Document is successfully added to claim.");
                                                System.out.println("1. Back to this claim's update display");
                                                System.out.println("b. Back to claim display");
                                                while (true) {
                                                    input = scanner.nextLine();
                                                    switch (input) {
                                                        case "1":
                                                            orderClaimDetail(target.getID());
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
                                                            orderClaimDetail(target.getID());
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
                                                        manager.deletePDFFiles(fileName);
                                                        manager.update(target);
                                                        System.out.println("Selected file is completely removed.");
                                                        System.out.println("1. Back to this claim's update display");
                                                        System.out.println("b. Back to claim display");
                                                        while (true) {
                                                            input = scanner.nextLine();
                                                            switch (input) {
                                                                case "1":
                                                                    orderClaimDetail(target.getID());
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
                                                                    orderClaimDetail(target.getID());
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
                                case "B":
                                case "b":
                                    view.viewClaimSelect();
                                    break;
                                default:
                                    System.out.println("Invalid input, please type again.");
                            }
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
                            manager.update(target);
                            System.out.println("Banking information is saved");
                            System.out.println("1. Back to this claim's update display");
                            System.out.println("b. Back to claim order selection");
                            while (true) {
                                input = scanner.nextLine();
                                switch (input) {
                                    case "1":
                                        orderClaimDetail(target.getID());
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
                case "B":
                case "b":
                    view.viewClaimSelect();
            }
        }
    }



}

