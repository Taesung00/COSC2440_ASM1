package Functions.Order;

import Components.Customer;
import Components.InsuranceCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class InsuranceCardOrder {
    public static ArrayList<InsuranceCard> LoadAllInsuranceCard() {
        /* 나중에 LoadAll로 따로 인터페이스 빼놓을것*/
        String projectRoot = System.getProperty("user.dir");
        ArrayList<InsuranceCard> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/InsuranceCards";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            String name = f.getName();
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                Object obj = input.readObject();
                results.add((InsuranceCard) obj);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return results;    }




}
