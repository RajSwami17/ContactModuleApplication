package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.sun.source.doctree.SerialDataTree;

import lombok.Data;

@Entity
@Table(name="CustomerDetailsInfo")
@Data
public class CustomerContact  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		
		@Id
		@SequenceGenerator(name = "customercontact1",sequenceName = "contact_id_seq",initialValue =1,allocationSize = 1 )
		@GeneratedValue(generator = "customercontact1",strategy = GenerationType.SEQUENCE)
		private Integer contactid;


		@Column(name="Salutation",length=10)
		private String salutation;
		
		@Column(name="FirstName",length=20)
		private String firstName;
		
		@Column(name="MiddleName",length=20)
		private String middleName;
		
		@Column(name="LastName",length=20)
		private String lastName;
		
		@Column(name="ContactNumber")
		private Long contactNumber;
	
		@Column(name="EmailId")
		private String mailId;
		
		@Column(name="Department",length=20)
		private String department;
		
		@Column(name="Designation",length=20)
		private String designation;

		public Integer getContactid() {
			return contactid;
		}

		public void setContactid(Integer contactid) {
			this.contactid = contactid;
		}
		
		public String getSalutation() {
			return salutation;
		}

		public void setSalutation(String salutation) {
			this.salutation = salutation;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getMiddleName() {
			return middleName;
		}

		public void setMiddleName(String middleName) {
			this.middleName = middleName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Long getContactNumber() {
			return contactNumber;
		}

		public void setContactNumber(Long contactNumber) {
			this.contactNumber = contactNumber;
		}

		

		public String getMailId() {
			return mailId;
		}

		public void setMailId(String mailId) {
			this.mailId = mailId;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		
		public CustomerContact(Integer contactid, String salutation, String firstName, String middleName,
				String lastName, Long contactNumber, String mailId, String department, String designation) 
		{
			super();
			this.contactid = contactid;
			this.salutation = salutation;
			this.firstName = firstName;
			this.middleName = middleName;
			this.lastName = lastName;
			this.contactNumber = contactNumber;
			this.mailId = mailId;
			this.department = department;
			this.designation = designation;
		}

		public CustomerContact() {
			super();
		}

		
}
