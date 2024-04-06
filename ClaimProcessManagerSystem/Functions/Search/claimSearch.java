package Functions.Search;

import Components.Entities.Claim;
import Functions.DAO.ClaimProcessManagerImpl;
import Functions.Order.ClaimOrder;

import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class claimSearch {
    static ClaimProcessManagerImpl manager = new ClaimProcessManagerImpl();
    public static ArrayList<Claim> claimSearchCustomerID(String customerID){
        ArrayList<Claim> ClaimList = manager.getAll();
        ArrayList<Claim> result = new ArrayList<>();
        for(Claim Claim : ClaimList){
            if(Claim.getInsurancedPerson().getID().equals("c-"+customerID)){
                result.add(Claim);
            }
        }
        return result;
    }
    public static Claim claimSearchClaimID(String ClaimID){
        ArrayList<Claim> ClaimList = manager.getAll();
        Claim result = new Claim();
        for(Claim Claim : ClaimList){
            if(Claim.getID().equals("f-"+ClaimID)){
                result = Claim;
            }
        }
        return result;
    }

    public static ArrayList<Claim> claimSearchInsuranceCardNum(String insuranceCardNum){
        ArrayList<Claim> ClaimList = manager.getAll();
        ArrayList<Claim> result = new ArrayList<>();
        for(Claim claim : ClaimList){
            if(claim.getCardNum().equals(insuranceCardNum)){
                result.add(claim);
            }
        }
        return result;
    }
    public static ArrayList<Claim> claimSearchStatus(Enum Status){
        ArrayList<Claim> ClaimList = manager.getAll();
        ArrayList<Claim> result = new ArrayList<>();
        for(Claim Claim : ClaimList){
            if(Claim.getClaimStatus().equals(Status)){
                result.add(Claim);
            }
        }
        return result;
    }

}
