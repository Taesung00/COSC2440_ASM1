package Functions.Search;

import Components.Claim;
import Components.Customer;
import Components.InsuranceCard;
import Functions.Order.CustomerOrder;

import java.util.ArrayList;

public class customerSearch {
    static ArrayList<Customer> customers = CustomerOrder.LoadAllCustomer();
    public static Customer customerSearchCustomerID(String ID){
        Customer result = null;
        for(Customer customer : customers){
            if((customer.getID()).equals(ID)){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchCustomerName(String name){
        Customer result = null;
        for(Customer customer : customers){
            if((customer.getFullName()).equals(name)){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchInsuranceCardID(String ID){
        Customer result = null;
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
