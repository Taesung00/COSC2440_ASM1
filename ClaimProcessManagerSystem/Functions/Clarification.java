package Functions;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Clarification{
    public static Boolean duplicationClarify(String componentID){
        /**
         * @param componentID = (claim || customer || InsuranceCard).getID()
         * @return If not duplicated return true ,duplicated return false
         * */
        ArrayList<String> componentFiles = new ArrayList<>();
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
                    componentFiles.add(file.getName());
                }
            }
        }

        if(componentFiles.contains(componentID+".ser")){
            return false;
        }else{
            return true;
        }
    }
}



