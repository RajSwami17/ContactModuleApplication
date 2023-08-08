package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.CustomerContact;
import com.nt.exception.ContactNotFoundException;
import com.nt.service.CustomerContactService;

@RestController
@RequestMapping("/contactus")
public class CustomerContactController 
{
	@Autowired
	 private CustomerContactService  service;
	
	@PostMapping("/register")
	public ResponseEntity<String> saveCustomerContact(@RequestBody CustomerContact contact)throws Exception
	{
		
		String resultMsg=service.registerCustomerContact(contact);
		return  new ResponseEntity<String>(resultMsg,HttpStatus.CREATED);		
	}
	
	@GetMapping("/findAll")
	public  ResponseEntity<List<CustomerContact>>  getAllContacts() throws Exception
	{
		List<CustomerContact> list=service.fetchAllContacts();
		return new ResponseEntity<List<CustomerContact>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/find/{contactid}")
	public  ResponseEntity<?> getCustomerContactById(@PathVariable("contactid") Integer contactid)throws Exception
	{
		CustomerContact contact =service.fetchCustomerContactById(contactid);
		return new ResponseEntity<CustomerContact>(contact,HttpStatus.OK);
	}
	
	@PutMapping("/modify")
	public   ResponseEntity<String> modifyCustomerContact(@RequestBody CustomerContact contact)throws Exception
	{
			  String msg=service.updateCustomerContact(contact);
			  return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{contactid}")
	public  ResponseEntity<String> removeCustomerContact(@PathVariable("contactid") Integer contactid)throws Exception
	{
		
		String  msg=service.deleteCustomerContact(contactid);
		 return  new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	
}
