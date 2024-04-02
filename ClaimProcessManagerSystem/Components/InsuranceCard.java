package Components;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;


import Functions.Save;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class InsuranceCard implements Serializable,Save {
    private static final long serialVersionUID = 3L;

    private final int CardNum;
    private final Customer cardHolder;
    private LocalDate ExpirationDate;
    private final String PolicyOwner;

    public InsuranceCard(int CardNum, Customer cardHolder, LocalDate expirationDate, String policyOwner) throws IOException {
        this.CardNum = CardNum;
        this.PolicyOwner = policyOwner;
        cardHolder.setInsuranceCard(this);
        this.ExpirationDate = expirationDate;
        this.cardHolder = cardHolder;
        Save("InsuranceCards","I-"+this.CardNum,this);
        Save("Customers",""+cardHolder.getID(),policyOwner);
    }

    public int getCardNum() {
        return CardNum;
    }

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
