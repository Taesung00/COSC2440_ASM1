package Functions.Order;

import Components.Entities.Claim;
import Components.Entities.Customer;
import Functions.DAO.ClaimProcessManagerImpl;
import Functions.DAO.CustomerDAO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author <Taesung Yoon - S3847581>
 *
 *     This feature is provided for future work(More features to other compoment)
 */

public class CustomerOrder implements order{
    private ArrayList<Customer> customerList = manager.getAll();
    static CustomerDAO manager = new CustomerDAO();

    public ArrayList<Customer> CustomerIDAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getID));
        return customerList;
    }

    public ArrayList<Customer> CustomerNameAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getFullName));
        return customerList;
    }

    public ArrayList<Customer> CustomerClaimAmountAscendingSort(){
        Collections.sort(customerList, Comparator.comparing(Customer::getClaimNumber));
        return customerList;
    }

}
