package Functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class delete {
        public static void delete(String Object,String ID) {
            String projectRoot = System.getProperty("user.dir");
            String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" +Object;
            try {
                Path filePath = Paths.get(ID);
                Files.deleteIfExists(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
