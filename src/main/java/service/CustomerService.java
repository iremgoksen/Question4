package service;

import model.Customer;
import java.util.List;
public interface CustomerService {
    public List<Customer> getAllCustomers();       // search all customers

    public Customer getCustomerById(long id);      // get an customer by id

    public void saveOrUpdate(Customer customer);   // to save an customer

    public void deleteCustomer(long id);           // delete an customer

}
