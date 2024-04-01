package Functions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author <Taesung Yoon - S3847581>
 */

public interface Save extends Serializable {
    public default void Save(String ComponentFolder,String ComponentName, Object obj) throws IOException {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" +ComponentFolder+"/"+ComponentName + ".txt";
        try {
            FileOutputStream fileOut = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data for %s is saved ", ComponentName);
            System.out.println(" ");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}