package service;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CustomerRepository;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {                       // search all customers
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(long id) {                     // get an customer by id
        return customerRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Customer customer) {                  // to save an customer
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(long id) {                          // delete an customer
        customerRepository.deleteById(id);
    }
}
