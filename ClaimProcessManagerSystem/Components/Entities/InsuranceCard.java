package Components.Entities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;


import Functions.Save;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class InsuranceCard implements Serializable,Save {
    private static final long serialVersionUID = 3L;

    private final String CardNum; /*number (10 digits)*/
    private final Customer cardHolder;
    private LocalDate ExpirationDate;
    private final String PolicyOwner;

    public InsuranceCard(String CardNum, Customer cardHolder, LocalDate expirationDate, String policyOwner) throws IOException {
        this.CardNum = CardNum;
        this.PolicyOwner = policyOwner;
        cardHolder.setInsuranceCard(this);
        this.ExpirationDate = expirationDate;
        this.cardHolder = cardHolder;
    }

    public String getCardNum() {
        return CardNum;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }
    public String getCardHolderName() {
        return cardHolder.getFullName();
    }

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }

    public String getPolicyOwner() {
        return PolicyOwner;
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
        return "InsuranceCard{" +
                "Card Number :" + CardNum +
                ", Card Holder :" + cardHolder.getFullName() +
                ", Expiration Date :" + ExpirationDate +
                ", Policy Owner :" + PolicyOwner +
                '}';
    }
}
