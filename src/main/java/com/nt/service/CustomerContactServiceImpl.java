package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.CustomerContact;
import com.nt.exception.ContactNotFoundException;
import com.nt.repo.ICustomerContactRepo;

@Service
public class CustomerContactServiceImpl implements CustomerContactService 
{
	@Autowired
	private ICustomerContactRepo contactRepo;

	@Override
	public String registerCustomerContact(CustomerContact contact) 
	{
	    int idVal = contactRepo.save(contact).getContactid();
		return "Customer Contact is registered  having the id value ::"+idVal;
	}

	@Override
	public List<CustomerContact> fetchAllContacts() 
	{
		List<CustomerContact> list = contactRepo.findAll();
		list.sort((t1,t2)->t1.getContactid().compareTo(t2.getContactid()));
		return list;
	}

	@Override
	public CustomerContact fetchCustomerContactById(Integer contactid) throws ContactNotFoundException 
	{	   
		return contactRepo.findById(contactid).orElseThrow(()-> new ContactNotFoundException(contactid+" Contact not found"));
	}
	
	
	@Override
	public String updateCustomerContact(CustomerContact contact) throws ContactNotFoundException 
	{
		Optional<CustomerContact> optional = contactRepo.findById(contact.getContactid());
		if(optional.isPresent()) 
		{
			contactRepo.save(contact); 
		    return  contact.getContactid()+" Contact is updated";
		}
		else 
		{
		    throw new ContactNotFoundException(contact.getContactid()+" Contact not found ");    	
		}
		
	}
	
	@Override
	public String deleteCustomerContact(Integer contactid) throws ContactNotFoundException 
	{
		  Optional<CustomerContact> opt=contactRepo.findById(contactid);
		  if(opt.isPresent()) 
		  {
			   contactRepo.delete(opt.get());
			   return  contactid+" Contact deleted";
		  }
		  else 
		  {
		       throw new  ContactNotFoundException(contactid+" Contact not found ");	  
		  }
		
	}
	

}
