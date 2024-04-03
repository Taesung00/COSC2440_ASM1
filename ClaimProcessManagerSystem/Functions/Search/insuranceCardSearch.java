package Functions.Search;

import Components.InsuranceCard;
import Functions.Order.InsuranceCardOrder;

import java.util.ArrayList;

public class insuranceCardSearch {
    static ArrayList<InsuranceCard> insuranceCards = InsuranceCardOrder.LoadAllInsuranceCard();
        public static ArrayList<InsuranceCard> insuranceCardSearchCustomerID(String ID){
            ArrayList<InsuranceCard> result = null;
            for(InsuranceCard insuranceCard : insuranceCards){
                if("f-"+insuranceCard.getCardNum() == ID){
                    result.add(insuranceCard);
                }
            }
            return result;
        }
    public static ArrayList<InsuranceCard> insuranceCardSearchCustomerName(String name){
        ArrayList<InsuranceCard> result = null;
        for(InsuranceCard insuranceCard : insuranceCards){
            if(insuranceCard.getCardHolder().getFullName() == name){
                result.add(insuranceCard);
            }
        }
        return result;
    }


}
