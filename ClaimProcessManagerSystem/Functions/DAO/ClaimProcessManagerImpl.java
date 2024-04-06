package Functions.DAO;

import Components.Entities.Claim;
import Functions.Save;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class ClaimProcessManagerImpl implements Serializable,Save, ClaimProcessManager {
    private static final long serialVersionUID = 6L;


    @Override
    public void add(Claim Claim) throws IOException {
        Claim c1 = Claim;
        update(c1);
    }

    @Override
    public void update(Claim Claim) throws IOException {
        Save("Claims", Claim.getID(), Claim);
    }

    @Override
    public void delete(String target) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/Claims";
        try {
            Path filePath = Paths.get(path, target);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Claim getOne(String ID) {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        Claim obj = null;
        for (File f : FileList) {
            String name = f.getName();
            if (f.isFile() && name.equals(ID+".ser")) {
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    obj = (Claim) input.readObject();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

        }            return obj;
    }


    @Override
    public ArrayList<Claim> getAll() {
        String projectRoot = System.getProperty("user.dir");
        ArrayList<Claim> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            if (f.isFile() && f.getName().endsWith(".ser")){
                String name = f.getName();
                try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(f))) {
                    Object obj = input.readObject();
                    results.add((Claim) obj);
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
