package Functions.Search;

import Components.Entities.Claim;
import Functions.Order.ClaimOrder;

import java.util.ArrayList;

public class claimSearch {
    static ArrayList<Claim> claims = ClaimOrder.LoadAllClaim();
    public static ArrayList<Claim> claimSearchCustomerID(String customerID){
        ArrayList<Claim> result = null;
        for(Claim Claim : claims){
            if(Claim.getInsurancedPerson().getID().equals(customerID)){
                result.add(Claim);
            }
        }
        return result;
    }
    public static Claim claimSearchClaimID(String ClaimID){
        Claim result = null;
        for(Claim Claim : claims){
            if(Claim.getID().equals(ClaimID)){
                result = Claim;
            }
        }
        return result;
    }

    public static ArrayList<Claim> claimSearchInsuranceCardNum(String insuranceCardNum){
        ArrayList<Claim> result = null;
        for(Claim claim : claims){
            if(claim.getCardNum().equals(insuranceCardNum)){
                result.add(claim);
            }
        }
        return result;
    }
    public static ArrayList<Claim> claimSearchStatus(Enum Status){
        ArrayList<Claim> result = null;
        for(Claim Claim : claims){
            if(Claim.getClaimStatus().equals(Status)){
                result.add(Claim);
            }
        }
        return result;
    }

}
