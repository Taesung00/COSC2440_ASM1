package Functions.Order;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Components.Entities.Claim;
import Functions.DAO.ClaimProcessManagerImpl;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class ClaimOrder implements order{
    static ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();

    public static ArrayList<Claim> claimDateAscending(){
        ArrayList<Claim> ClaimList = manager.getAll();
        Collections.sort(ClaimList,Comparator.comparing(Claim::getClaimDate));
        return ClaimList;
    }
    public static ArrayList<Claim> claimIDAscendingSort(){
        ArrayList<Claim> ClaimList = manager.getAll();
        Collections.sort(ClaimList, Comparator.comparing(Claim::getID));
        return ClaimList;
    }
    public static ArrayList<Claim> claimAmountAscendingSort() {
        ArrayList<Claim> ClaimList = manager.getAll();
        Collections.sort(ClaimList, Comparator.comparing(Claim::getClaimAmount));
        return ClaimList;
    }
    public static ArrayList<Claim> claimStatusSort() /*New > Processing > Done*/{
        ArrayList<Claim> ClaimList = manager.getAll();
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


}
