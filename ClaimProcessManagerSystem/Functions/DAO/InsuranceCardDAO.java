package Functions.DAO;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Components.Entities.InsuranceCard;
import Functions.Save;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class InsuranceCardDAO implements Save, Serializable {
    public void add(InsuranceCard insuranceCard) throws IOException {
        InsuranceCard i1 = insuranceCard;
        update(i1);
    }

    public void update(InsuranceCard insuranceCard) throws IOException {
        Save("InsuranceCards", insuranceCard.getCardNum(), insuranceCard);
    }

    public void delete(String target) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/InsuranceCards";
        try {
            Path filePath = Paths.get(path, target);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InsuranceCard getOne(String ID) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsurnaceCards";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        InsuranceCard obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.equals(ID+".ser")) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (InsuranceCard) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }            return obj;
    }


    public ArrayList<InsuranceCard> getAll() {
        String projectRoot = System.getProperty("user.dir");
        ArrayList<InsuranceCard> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/InsuranceCards";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            if (f.isFile() && f.getName().endsWith(".ser")){
                String name = f.getName();
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    if(!results.contains(obj)){
                        results.add((InsuranceCard) obj);
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
