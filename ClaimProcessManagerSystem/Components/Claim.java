package Components;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import Functions.Save;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Claim implements  Serializable,Save{
    private static final long serialVersionUID = 1L;
    private String ID;
    private LocalDate ClaimDate;
    private Customer InsurancedPerson;
    private String CardNum;
    private LocalDate ExamDate;
    private File ListOfDocuments; /* Adding java file functions*/
    private int ClaimAmount;
    public enum Status{
        New,Processing,Done
    }
    private Status ClaimStatus;
    private String ReceiverBankingInfo;

    public String getCardNum() {
        return CardNum;
    }

    public String getID() {
        return ID;
    }


    public Claim(){
    }
    public Claim(int ID, LocalDate ClaimDate,Customer InsurancedPerson, int CardNum, LocalDate ExamDate,File Documents,int ClaimAmount,Status Status) throws IOException {
        this.ID = "F-"+ID;
        this.ClaimDate = ClaimDate;
        this.InsurancedPerson = InsurancedPerson;
        this.ExamDate = ExamDate;
        this.ListOfDocuments = Documents;
        this.ClaimAmount = ClaimAmount;
        this.ClaimStatus = Status.New;
        InsurancedPerson.addClaim(this);
        Save("Claims",this.ID,this);
        Save("Customers",InsurancedPerson.getID(),InsurancedPerson);
    }

    public int getClaimAmount() {
        return ClaimAmount;
    }

    public Status getClaimStatus() {
        return ClaimStatus;
    }

    public void setClaimAmount(int claimAmount) {
        ClaimAmount = claimAmount;
    }

    public LocalDate getClaimDate() {
        return ClaimDate;
    }

    public void setClaimStatus(Status claimStatus) {
        ClaimStatus = claimStatus;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "ID :'" + ID + '\'' +
                ", ClaimDate :" + ClaimDate +
                ", Insuranced Person's ID :" + InsurancedPerson.getID() + " : "+InsurancedPerson.getFullName()+
                ", Card Number :" + CardNum +
                ", Exam Date :" + ExamDate +
                ", List Of Documents :" + ListOfDocuments +
                ", Claim Amount :" + ClaimAmount +
                ", Claim Status :" + ClaimStatus +
                ", Receiver Banking Information'" + ReceiverBankingInfo + '\'' +
                '}';
    }
}
