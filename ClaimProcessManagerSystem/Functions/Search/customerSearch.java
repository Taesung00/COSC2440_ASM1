package Functions.Search;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Functions.DAO.CustomerDAO;

import java.util.ArrayList;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class customerSearch {
    static CustomerDAO manager = new CustomerDAO();
    static ArrayList<Customer> customers = manager.getAll();
    public static Customer customerSearchCustomerID(String ID) {
        Customer result = new Customer();
        for(Customer customer : customers){
            if((customer.getID()).equals("c-"+ID)){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchClaimID(String ID) {
        Customer result = new Customer();
        for(Customer customer : customers){
            if(customer.getClaims().size()>1){
                ArrayList<Claim> claims = customer.getClaims();
                for(Claim c :claims){
                    result = c.getInsurancedPerson();
                }
            }
        }
        return result;
    }
    public static Customer customerSearchCustomerName(String name){
        Customer result = new Customer();
        for(Customer customer : customers){
            if((customer.getFullName()).equals(name)){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchInsuranceCardID(String ID){
        Customer result = new Customer();
        for(Customer customer : customers){
            if(("I-"+customer.getInsuranceCard().getCardNum()).equals(ID)){
                result = customer;
            }
        }
        return result;

    }
    public static boolean customerSearchClarification(String name){
        for(Customer c : customers){
            if((c.getFullName().equals(name))){
                return true;
            }
        }
        return false;
    }
    public static boolean customerSearchClarificationID(String IDnum){
        for(Customer c : customers){
            if((c.getID().equals("c-"+IDnum))){
                return true;
            }
        }
        return false;
    }



}
