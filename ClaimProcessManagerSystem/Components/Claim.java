package Components;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private String CardNum = String.valueOf(Card.getCardNum());
    private LocalDate ExamDate;
    private ArrayList<String> ListOfDocuments = new ArrayList<>();
    private int ClaimAmount;
    public enum Status{
        New,Processing,Done
    }
    private Status ClaimStatus;
    private String ReceiverBankingInfo; /*Bank – Name – Number*/

    public InsuranceCard getCard() {
        return Card;
    }

    public String getCardNum() {
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
        this.CardNum = String.valueOf(InsuranceCard.getCardNum());
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

    public ArrayList<String> getListOfDocuments() {
        return ListOfDocuments;
    }
    public void deleteDocument(String documentName){
        this.ListOfDocuments.remove(documentName);
    }
    public void addDocument(String documentName){
        this.ListOfDocuments.add(documentName);
    }/*ClaimId_CardNumber_DocumentName.pdf*/


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

    public Customer getInsurancedPerson() {
        return InsurancedPerson;
    }

    @Override
    public String toString() {
        return "ID :'" + ID + '\'' +
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
