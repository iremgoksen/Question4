package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;
import java.util.List;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value="/list", method= RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model=new ModelAndView("customer_list");
        List<Customer> customerList=customerService.getAllCustomers();
        model.addObject("customerList", customerList);
        return model;
    }

    @RequestMapping(value="/addCustomer", method= RequestMethod.GET)
    public ModelAndView addCustomer() {
        ModelAndView model=new ModelAndView();
        Customer customer=new Customer();
        model.addObject("customerForm", customer);
        model.setViewName("customer_form");
        return model;
    }

    @RequestMapping(value="/updateCustomer/{id}", method= RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable long id) {
        ModelAndView model=new ModelAndView();
        Customer customer=customerService.getCustomerById(id);
        model.addObject("customerForm", customer);
        model.setViewName("customer_form");
        return model;
    }

    @RequestMapping(value="/saveCustomer/", method= RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("customerForm") Customer customer) {
        customerService.saveOrUpdate(customer);
        return new ModelAndView("redirect:/customer/list");
    }

    @RequestMapping(value="/deleteCustomer/{id}", method= RequestMethod.POST)
    public ModelAndView delete(@PathVariable("id") long id) {
        customerService.deleteCustomer(id);
        return new ModelAndView("redirect:/customer/list");
    }

}
