package Components.Entities;

import Functions.Save;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Customer implements Serializable,Save{
    private static final long serialVersionUID = 2L;

    private String ID;
    private String FullName;
    private InsuranceCard InsuranceCard = null;
    private ArrayList<Claim> Claims = null;

    public Customer(){}
    public Customer(String IDNumber, String FullName) throws IOException {
        this.ID = "c-"+ID; /*with the format c-numbers; 7 numbers*/
        this.FullName = FullName;
        Save("Customers",this.ID,this);
    }

    public void setInsuranceCard(Components.Entities.InsuranceCard insuranceCard) throws IOException {
        InsuranceCard = insuranceCard;
        Save("InsuranceCards",this.ID,this);
    }

    public void addClaim(Claim claim) throws IOException {
        Claims.add(claim);
        Save("Claims",this.ID,this);
    }

    public Components.Entities.InsuranceCard getInsuranceCard() {
        return InsuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return Claims;
    }
    public int getClaimNumber() {
        return Claims.size();
    }


    public String getFullName() {
        return FullName;
    }

    public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID :'" + ID + '\'' +
                ", Full Name :'" + FullName + '\'' +
                ", Insurance Card Information:" + InsuranceCard +
                ", Claims Information : " + Claims +
                '}';
    }
}
