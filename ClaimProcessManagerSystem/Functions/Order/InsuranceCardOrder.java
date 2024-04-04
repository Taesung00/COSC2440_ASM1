package Functions.Order;

import Components.Entities.InsuranceCard;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class InsuranceCardOrder {
    private ArrayList<InsuranceCard> insuranceCardList = (ArrayList<InsuranceCard>) LoadAllInsuranceCard();

    public ArrayList<InsuranceCard> insuranceCardIDAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardNum));
        return insuranceCardList;
    }
    public ArrayList<InsuranceCard> insuranceCardIDDescendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardNum).reversed());
        return insuranceCardList;
    }
    public ArrayList<InsuranceCard> insuranceCardPolicyOwnerAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getPolicyOwner));
        return insuranceCardList;
    }
    public ArrayList<InsuranceCard> insuranceCardPolicyOwnerDescendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getPolicyOwner).reversed());
        return insuranceCardList;
    }
    public ArrayList<InsuranceCard> insuranceCardHolderAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardHolderName));
        return insuranceCardList;
    }
    public ArrayList<InsuranceCard> insuranceCardHolderDescendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardHolderName).reversed());
        return insuranceCardList;
    }


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
