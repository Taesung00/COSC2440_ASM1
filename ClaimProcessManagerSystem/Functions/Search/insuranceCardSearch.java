package Functions.Search;

import Components.Entities.InsuranceCard;
import Functions.Order.InsuranceCardOrder;

import java.util.ArrayList;

public class insuranceCardSearch {
    public static ArrayList<InsuranceCard> insuranceCards = InsuranceCardOrder.LoadAllInsuranceCard();


    public static ArrayList<InsuranceCard> insuranceCardSearchCustomerName(String name){
        ArrayList<InsuranceCard> result = new ArrayList<>();
        for(InsuranceCard insuranceCard : insuranceCards){
            if(insuranceCard.getCardHolder().getFullName().equals(name)){
                result.add(insuranceCard);
            }
        }
        return result;
    }
    public static ArrayList<InsuranceCard> insuranceCardSearchCardNumber(String cardNumber){
        ArrayList<InsuranceCard> result = new ArrayList<>();
        for(InsuranceCard insuranceCard : insuranceCards){
            if((insuranceCard.getCardNum()).equals(cardNumber)){
                result.add(insuranceCard);
            }
        }
        return result;
    }
    public static boolean insuranceCardSearchClarification(String name){
        for(InsuranceCard c : insuranceCards){
            if(!(c.getCardHolder().equals(name))){
                return false;
            }
            }

        return true;
    }
    }

