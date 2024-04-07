package Functions.DAO;

import Components.Entities.Claim;
import Functions.Save;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

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

    public ArrayList<String> getAllPDFFileNames(){
        /**
         * @return All of PDF file names in database
         * */
        String projectRoot = System.getProperty("user.dir");
        ArrayList<String> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/ClaimDocuments";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
            if (f.isFile() && f.getName().endsWith(".pdf")){
                String name = f.getName();
                if (!results.contains(name)) { // Check if the file name is already in the list
                    results.add(name);
                }
            }

        }
        return results;
    }

    public void wirtePDFFiles(Claim claim,String FileName ,String textDetail) throws IOException {
/**
 * @param FileName : This will be the name of the saved PDF file. "ID_InsuranceCardNumber_Filename".pdf
 * @param textDetail : This is the detailed content of the PDF file.
 *                    *     In this feature, external library,PDFBOX is used
 */

        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/ClaimDocuments";
        try {
            PDDocument doc = new PDDocument();
            PDPage p = new PDPage();
            doc.addPage(p);
            PDPageContentStream contentStream = new PDPageContentStream(doc, p);

            // Set font and font size
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA), 14);

            // Write text
            contentStream.beginText();
            contentStream.newLineAtOffset(100, 700); // Set the position where you want to start writing
            contentStream.showText(textDetail);
            contentStream.endText();
            contentStream.close();

            // Save the document
            doc.save(path+"/"+FileName);
            // Close the document
            doc.close();

            System.out.printf("%s file is created successfully! \n",FileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        claim.addDocument(FileName);
    }
    public void deletePDFFiles(String FileName){
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components/Data/ClaimDocuments";
        try {
            Path filePath = Paths.get(path, FileName);
            Files.deleteIfExists(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
                    if(!results.contains(obj)){
                        results.add((Claim) obj);
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
