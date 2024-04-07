package Functions.Search;

import Components.Entities.InsuranceCard;
import Functions.DAO.InsuranceCardDAO;

import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class insuranceCardSearch {
    static InsuranceCardDAO manager = new InsuranceCardDAO();
    public static ArrayList<InsuranceCard> insuranceCards = manager.getAll();

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
    }

