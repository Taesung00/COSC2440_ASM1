package Components;

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
    public Customer(String ID, String FullName) throws IOException {
        this.ID = "C-"+ID;
        this.FullName = FullName;
        Save("Customers",this.ID,this);
    }

    public void setInsuranceCard(Components.InsuranceCard insuranceCard) throws IOException {
        InsuranceCard = insuranceCard;
        Save("InsuranceCards",this.ID,this);
    }

    public void addClaim(Claim claim) throws IOException {
        Claims.add(claim);
        Save("Claims",this.ID,this);
    }

    public Components.InsuranceCard getInsuranceCard() {
        return InsuranceCard;
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
