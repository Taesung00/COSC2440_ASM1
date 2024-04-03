package Functions.Search;

import Components.Claim;
import Components.Customer;
import Functions.Order.CustomerOrder;

import java.util.ArrayList;

public class customerSearch {
    static ArrayList<Customer> customers = CustomerOrder.LoadAllCustomer();
    public static Customer customerSearchCustomerID(String ID){
        Customer result = null;
        for(Customer customer : customers){
            if(customer.getID() == ID){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchCustomerName(String name){
        Customer result = null;
        for(Customer customer : customers){
            if(customer.getFullName() == name){
                result = customer;
            }
        }
        return result;
    }
    public static Customer customerSearchInsuranceCardID(String ID){
        Customer result = null;
        for(Customer customer : customers){
            if("I-"+customer.getInsuranceCard().getCardNum() == ID){
                result = customer;
            }
        }
        return result;

    }



}
