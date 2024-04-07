package Functions.Order;

import Components.Entities.InsuranceCard;
import Functions.DAO.InsuranceCardDAO;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author <Taesung Yoon - S3847581>
 *     This feature is provided for future work(More features to other compoment)
 */

public class InsuranceCardOrder implements order{
    InsuranceCardDAO manager = new InsuranceCardDAO();
    private ArrayList<InsuranceCard> insuranceCardList = manager.getAll();

    public ArrayList<InsuranceCard> insuranceCardIDAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardNum));
        return insuranceCardList;
    }

    public ArrayList<InsuranceCard> insuranceCardPolicyOwnerAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getPolicyOwner));
        return insuranceCardList;
    }

    public ArrayList<InsuranceCard> insuranceCardHolderAscendingSort(){
        Collections.sort(insuranceCardList, Comparator.comparing(InsuranceCard::getCardHolderName));
        return insuranceCardList;
    }




}
