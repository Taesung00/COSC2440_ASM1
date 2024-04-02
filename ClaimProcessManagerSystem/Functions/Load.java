package Functions;

import Components.Claim;
import Components.Customer;
import Components.InsuranceCard;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Load implements Serializable {

    public static void ListAllComponents() {
        ArrayList<String> componentFolders = new ArrayList<String>(Arrays.asList("Claims", "Customers", "InsuranceCards"));
        for (String component : componentFolders){
            String projectRoot = System.getProperty("user.dir");
            String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" +component;
            File folder = new File(path);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.printf("There's no Data in %s folder\n",component);
                continue;
            }
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("Reading TXT file: " + file.getName());
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public static String returnAllFilesStartWith(String startWord) {
        String projectRoot = System.getProperty("user.dir");
        String path = "";
        ArrayList<Object> results = new ArrayList<>();
        switch(startWord){
            case "Cl-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
                break;
            case "f-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
                break;
            case "I-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
                break;
            default:
                System.out.println("Invalid startWord: " + startWord);
                return ""+results;
        }

        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(startWord)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    results.add(obj.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        return "" + results;

    }
    public static Claim returnClaim(String claimID){
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        Claim obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(claimID)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (Claim) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return obj;
    }
    public static InsuranceCard returnInsuranceCard(String insuranceCardID){
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        InsuranceCard obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(insuranceCardID)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (InsuranceCard) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return obj;
    }
    public static Customer returnCustomer(String customerID){
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        Customer obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(customerID)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (Customer) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return obj;
    }




    public static ArrayList<String> returnAllFileNamesStartWith(String startWord) {
        String projectRoot = System.getProperty("user.dir");
        String path = "";
        ArrayList<String> folderNames = new ArrayList<>();
        switch(startWord){
            case "Cl-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
                break;
            case "f-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
                break;
            case "I-" /*Insurance card*/:
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
                break;
            default:
                System.out.println("Invalid startWord: " + startWord);
                return folderNames;
        }
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(startWord)) {
                folderNames.add(name);
            }
        }
        return folderNames;

    }

    public void printAllFilesStartWith(String startWord) {
        String projectRoot = System.getProperty("user.dir");
        String path = "";
        switch(startWord){
            case "Cl-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
                break;
                case "f-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
                break;
            case "I-":
                path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
                break;
            default:
                System.out.println("Invalid startWord: " + startWord);
                return; // Exit the method.
        }
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        ArrayList<Object> results = new ArrayList<>();
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.startsWith(startWord)) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    results.add(obj.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
        for(Object result : results){
            System.out.println(result.toString());
        }

    }
//                    break;
//            case "f":
//    path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
//                break;
//            case "I":
//    path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
//                break;
//    default:
//            System.out.println("Invalid type: " + componentType);
//}

//    public ArrayList<Claim> LoadAllClaim(){
//        return LoadAllComponent("Cl");
//    }

//    public void ListOneComponent(String componentType) {
//        String projectRoot = System.getProperty("user.dir");
//        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" +componentType;
//        File folder = new File(path);
//        if (!folder.exists() || !folder.isDirectory()) {
//            System.out.printf("There's no Data in %s folder\n",componentType);
//            return;
//            }
//            File[] listOfFiles = folder.listFiles();
//            for (File file : listOfFiles) {
//                if (file.isFile() && file.getName().endsWith(".txt")) {
//                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
//                        String line;
//                        while ((line = reader.readLine()) != null) {
//                            System.out.println(line);
//                        }
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }
    }

