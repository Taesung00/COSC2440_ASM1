package Functions.DAO;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Functions.Save;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class CustomerDAO implements Serializable,Save {

    public void add(Customer Customer) throws IOException {
        Customer c1 = Customer;
        update(c1);
    }

    public void update(Customer Customer) throws IOException {
        Save("Customers", Customer.getID(), Customer);
    }

    public void delete(String target) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/Customers";
        try {
            Path filePath = Paths.get(path, target);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Customer getOne(String ID) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        Customer obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.equals(ID+".ser")) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (Customer) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }            return obj;
    }


    public ArrayList<Customer> getAll() {
        String projectRoot = System.getProperty("user.dir");
        ArrayList<Customer> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Customers";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            if (f.isFile() && f.getName().endsWith(".ser")){
                String name = f.getName();
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    if(!results.contains(obj)){
                        results.add((Customer) obj);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }
        return results;    }

    @Override
    public void Save(String ComponentFolder, String ComponentName, Object obj) throws IOException {
        Save.super.Save(ComponentFolder, ComponentName, obj);
    }
}
