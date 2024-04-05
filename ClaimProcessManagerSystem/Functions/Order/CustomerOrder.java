package Functions.Order;

import Components.Entities.Claim;
import Components.Entities.Customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CustomerOrder extends ClaimOrder{
    private ArrayList<Customer> customerList = (ArrayList<Customer>) LoadAllCustomer();

    public ArrayList<Customer> CustomerIDAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getID));
        return customerList;
    }

    public ArrayList<Customer> CustomerNameAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getFullName));
        return customerList;
    }

    public ArrayList<Customer> CustomerClaimAmountAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getClaimNumber));
        return customerList;
    }





    public static ArrayList<Customer> LoadAllCustomer() {

        String projectRoot = System.getProperty("user.dir");
        ArrayList<Customer> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/Customers";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            if (f.isFile() && f.getName().endsWith(".ser")){
                String name = f.getName();
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    results.add((Customer) obj);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
            }

        return results;    }

}
