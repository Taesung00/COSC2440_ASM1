package Components.Entities;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

import Functions.Save;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class Claim implements  Serializable,Save{
    private static final long serialVersionUID = 1L;
    private final String ID; /*(with the format f-numbers; 10 numbers*/
    private LocalDate ClaimDate;
    private Customer InsuredPerson;
    private InsuranceCard Card;
    private String CardNum;
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
        ID = null;
    }
    public Claim(String IDNumber, LocalDate ClaimDate,Customer InsuredPerson, InsuranceCard InsuranceCard, LocalDate ExamDate,int ClaimAmount, String ReceiverBankingInfo) throws IOException {
        this.ID = "f-"+IDNumber;
        this.ClaimDate = ClaimDate;
        this.InsuredPerson = InsuredPerson;
        this.ExamDate = ExamDate;
        this.ClaimAmount = ClaimAmount;
        this.ClaimStatus = Status.New;
        this.CardNum = String.valueOf(InsuranceCard.getCardNum());
        this.ReceiverBankingInfo = ReceiverBankingInfo;
        InsuredPerson.addClaim(this);
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
        return InsuredPerson;
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
        return "Claim ID :'" + ID + '\'' +
                ", ClaimDate :" + ClaimDate +
                ", Insuranced Person's ID :" + InsuredPerson.getID() + " : "+InsuredPerson.getFullName()+
                ", Card Number :" + CardNum +
                ", Exam Date :" + ExamDate +
                ", List Of Documents :" + ListOfDocuments +
                ", Claim Amount :" + ClaimAmount +
                ", Claim Status :" + ClaimStatus +
                ", Receiver Banking Information' : " + ReceiverBankingInfo + '\'' +
                '}';
    }
}
