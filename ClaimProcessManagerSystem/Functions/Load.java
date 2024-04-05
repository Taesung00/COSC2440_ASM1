package Functions;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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
                System.out.println(file.getName());
                if (file.isFile() && file.getName().endsWith(".ser")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        Object obj = ois.readObject();
                        System.out.println(obj.toString());
                    } catch (IOException | ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
    public static ArrayList<String> returnAllComponentsFileName() {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> componentFolders = new ArrayList<String>(Arrays.asList("Claims", "Customers", "InsuranceCards"));
        for (String component : componentFolders) {
            String projectRoot = System.getProperty("user.dir");
            String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" + component;
            File folder = new File(path);
            if (!folder.exists() || !folder.isDirectory()) {
                System.out.printf("There's no Data in %s folder\n", component);
                continue;
            }
            File[] listOfFiles = folder.listFiles();
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".ser")) {
                    result.add(file.getName());
                }
            }
        }
        return result;
    }


    public static Claim returnClaim(String claimID){
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        Claim obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.equals(claimID+".ser")) {
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
            if (f.isFile() && name.equals(insuranceCardID+".ser")) {
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
            if (f.isFile() && name.equals(customerID+".ser")) {
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
            case "c-":
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


    }

