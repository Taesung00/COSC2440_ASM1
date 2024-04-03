package Functions.Order;

import Components.Claim;
import Components.Customer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CustomerOrder extends ClaimOrder{
    public static ArrayList<Customer> LoadAllCustomer() {

        String projectRoot = System.getProperty("user.dir");
        ArrayList<Customer> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/Customers";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
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
        return results;    }

}
