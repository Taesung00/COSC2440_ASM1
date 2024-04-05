package Functions.Order;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Components.Entities.Claim;


public class ClaimOrder{

    private static ArrayList<Claim> ClaimList = (ArrayList<Claim>) LoadAllClaim();
    public static ArrayList<Claim> claimDateAscending(){
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate));
        return ClaimList;
    }
    public static ArrayList<Claim> claimIDAscendingSort(){
        Collections.sort(ClaimList, Comparator.comparing(Claim::getID));
        return ClaimList;
    }
    public static ArrayList<Claim> claimAmountAscendingSort() {
        Collections.sort(ClaimList, Comparator.comparing(Claim::getClaimAmount));
        return ClaimList;
    }
    public static ArrayList<Claim> claimStatusSort() /*New > Processing > Done*/{
        Claim i1 = null;
        Claim i2 = null;
        Claim temp = null;

        for(int i = 0; i<ClaimList.size()-1;i++){
            for(int j = 0; j<ClaimList.size()-i-1;j++){
                if(ClaimList.get(j).getClaimStatus().equals(Claim.Status.Processing)){
                    if(ClaimList.get(j+1).getClaimStatus().equals(Claim.Status.New) || ClaimList.get(j+1).getClaimStatus().equals(Claim.Status.Processing)){
                        temp = ClaimList.get(j);
                        ClaimList.set(j, ClaimList.get(j + 1));
                        ClaimList.set(j+1,temp);
                    }
                } else if (ClaimList.get(j).getClaimStatus().equals(Claim.Status.Done)) {
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


}
