package Components.Entities;

import Functions.Save;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Customer implements Serializable,Save{
    private static final long serialVersionUID = 2L;

    private String ID;
    private String FullName;
    private InsuranceCard InsuranceCard;
    private ArrayList<Claim> Claims = new ArrayList<>();
    private enum Role{
        policyHolder,dependent
    }
    private Role customerRole = Role.policyHolder; /*Default value*/
    private ArrayList<Customer> dependentList;

    public Customer(){}
    public Customer(String IDNumber, String FullName) throws IOException {
        this.ID = "c-"+IDNumber; /*with the format c-numbers; 7 numbers*/
        this.FullName = FullName;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) throws IOException {
        InsuranceCard = insuranceCard;
    }

    public void addClaim(Claim claim) throws IOException {
        Claims.add(claim);
    }

    public void setCustomerRolePolicyHolder() {
        this.customerRole = Role.policyHolder;
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

    public void addDependent(Customer dependent){
        dependentList.add(dependent);
    }

    @Override
    public void Save(String ComponentFolder, String ComponentName, Object obj) throws IOException {
        String projectRoot = System.getProperty("user.dir");
        String path = projectRoot + "/ClaimProcessManagerSystem/Components" + "/Data/" + ComponentFolder + "/" + ComponentName + ".ser";
        try (FileOutputStream fileOut = new FileOutputStream(path);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(obj);
        }    }

    @Override
    public String toString() {
        return "Customer{" +
                "ID :'" + ID + '\'' +
                ", Full Name :'" + FullName + '\'' +
                ", Insurance Card Information:" + InsuranceCard +
                ", Claims Information : " + Claims +", Role : "+customerRole+ ", Dependents : "+dependentList+
                '}';
    }
}
