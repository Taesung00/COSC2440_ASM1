package Functions.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Components.Claim;


public class ClaimOrder{

    private ArrayList<Claim> ClaimList = (ArrayList<Claim>) LoadAllClaim();
    public ArrayList<Claim> claimDateAscending(){
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate));
        return ClaimList;
    }
    public ArrayList<Claim> claimDateDescending(){
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate));
        return ClaimList;
    }
    public ArrayList<Claim> ClaimIDAscendingSort(){
        Collections.sort(ClaimList, Comparator.comparing(Claim::getID));
        return ClaimList;
    }
    public ArrayList<Claim> ClaimIDDescendingSort(){
        Collections.sort(ClaimList, Comparator.comparing(Claim::getID).reversed());
        return ClaimList;
    }
    public ArrayList<Claim> ClaimDateAscendingSort(){
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate));
        return ClaimList;
    }
    public ArrayList<Claim> ClaimDateDescendingSort(){
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate).reversed());
        return ClaimList;
    }
    public ArrayList<Claim> ClaimAmountAscendingSort() {
        Collections.sort(ClaimList, Comparator.comparing(Claim::getClaimAmount));
        return ClaimList;
    }
    public ArrayList<Claim> ClaimAmountDescendingSort(){
        Collections.sort(ClaimList, Comparator.comparing(Claim::getClaimAmount).reversed());
        return ClaimList;
    }
    public ArrayList<Claim> ClaimStatusSort() /*Need testing*/{
        Claim i1 = null;
        Claim i2 = null;
        Claim temp = null;

        for(int i = 0; i<ClaimList.size()-1;i++){
            for(int j = 0; j<ClaimList.size()-i-1;j++){
                if(ClaimList.get(j).getClaimStatus() == Claim.Status.Done){
                    if(ClaimList.get(j+1).getClaimStatus() == Claim.Status.New || ClaimList.get(j+1).getClaimStatus() == Claim.Status.Processing){
                        temp = ClaimList.get(j);
                        ClaimList.set(j, ClaimList.get(j + 1));
                        ClaimList.set(j+1,temp);
                    }
                } else if (ClaimList.get(j).getClaimStatus() == Claim.Status.Processing) {
                    temp = ClaimList.get(j);
                    ClaimList.set(j, ClaimList.get(j + 1));
                    ClaimList.set(j+1,temp);
                }
            }
        }
        return ClaimList;
    }
    public static ArrayList<Claim> LoadAllClaim() {
        /* 나중에 LoadAll로 따로 인터페이스 빼놓을것*/
        String projectRoot = System.getProperty("user.dir");
        ArrayList<Claim> results = new ArrayList<>();
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/Claims";
        File folder = new File(path);
        File[] FileList = folder.listFiles();
        for (File f : FileList) {
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
        return results;    }


}
