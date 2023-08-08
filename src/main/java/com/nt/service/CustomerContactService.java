package com.nt.service;

import java.util.List;

import com.nt.entity.CustomerContact;
import com.nt.exception.ContactNotFoundException;

public interface CustomerContactService 

{
    public String registerCustomerContact(CustomerContact contact);
     
    public List<CustomerContact> fetchAllContacts();
     
    public CustomerContact fetchCustomerContactById(Integer contactid)throws ContactNotFoundException;
     
    public String updateCustomerContact(CustomerContact contact)throws ContactNotFoundException;
     
    public String deleteCustomerContact(Integer contactid)throws ContactNotFoundException;
    
}
