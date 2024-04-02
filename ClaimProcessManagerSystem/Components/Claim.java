package Components;

import java.io.*;
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
    private InsuranceCard Card;
    private int CardNum = Card.getCardNum();
    private LocalDate ExamDate;
    private File ListOfDocuments; /* Adding java file functions*/
    private int ClaimAmount;
    public enum Status{
        New,Processing,Done
    }
    private Status ClaimStatus;
    private String ReceiverBankingInfo;

    public int getCardNum() {
        return CardNum;
    }

    public String getID() {
        return ID;
    }


    public Claim(){
    }
    public Claim(int ID, LocalDate ClaimDate,Customer InsurancedPerson, InsuranceCard InsuranceCard, LocalDate ExamDate,int ClaimAmount) throws IOException {
        this.ID = "F-"+ID;
        this.ClaimDate = ClaimDate;
        this.InsurancedPerson = InsurancedPerson;
        this.ExamDate = ExamDate;
        this.ClaimAmount = ClaimAmount;
        this.ClaimStatus = Status.New;
        this.CardNum = InsuranceCard.getCardNum();
        InsurancedPerson.addClaim(this);
        Save("Claims",this.ID,this);
        Save("Customers",InsurancedPerson.getID(),InsurancedPerson);
    }

    public void setClaimDate(LocalDate claimDate) {
        ClaimDate = claimDate;
    }

    public void setExamDate(LocalDate examDate) {
        ExamDate = examDate;
    }

    public void setListOfDocuments(File listOfDocuments) {
        ListOfDocuments = listOfDocuments;
    }

    public void setReceiverBankingInfo(String receiverBankingInfo) {
        ReceiverBankingInfo = receiverBankingInfo;
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

    public void addDocuments(File documents){}/*나중에 업데이트하기*/
    public void deleteDocument(File documents){}
    public void getDocuments(){}

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
