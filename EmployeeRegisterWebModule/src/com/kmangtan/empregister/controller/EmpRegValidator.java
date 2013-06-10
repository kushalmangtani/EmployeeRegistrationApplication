package com.kmangtan.empregister.controller;

/*
 * Here, the business logic of validation is implemented..
 * Also, all the default messages which should be printed for firstname,middlename,lastname,email 
 * are written  in validate method of this class
 */
import javax.naming.NamingException;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.kmangtan.empregister.initialize.EjbInitialize;
import com.kmangtan.empregister.registerform.bean.EmpRegBean;
import com.kmangtan.empregister.registerservice.EmployeeRegisterRemoteInterface;








public class EmpRegValidator implements Validator {

	
	
	public boolean supports(Class<?> cl)
	{
		
		return EmpRegBean.class.equals(cl);
	}

	
	public void validate(Object obj, Errors e) {
		
		try
		{
		
			EmployeeRegisterRemoteInterface db=null;
			try
			{
				db= (EmployeeRegisterRemoteInterface) EjbInitialize.getejb("EmailRegEJB");   // Reference to an EJb is made
				
			}
			catch (NamingException e1) {
				e1.getStackTrace();
			}
		EmpRegBean bean=(EmpRegBean) obj;
	 if(bean.getFirstname()==null || bean.getFirstname()=="")
	 { e.rejectValue("firstname","FirstName is required","FirstName is required");
	 
	
	 }
	
	 if(bean.getMiddlename()==null || bean.getMiddlename()=="")
		 e.rejectValue("middlename","MiddleName is required","MiddleName is required");
	 
	 if(bean.getLastname()==null || bean.getLastname()=="")
		 e.rejectValue("lastname","LastName is required","LastName is required");
	 
	 
	 
	 if(bean.getEmail()==null || bean.getEmail()=="")
		 e.rejectValue("email","Email is required","Email is required");
	 
	 if(bean.getPhoneno()==null || bean.getPhoneno()=="")
		 e.rejectValue("phoneno","PhoneNo is required","PhoneNo is required");
	 
	 
	 
	 
	int checkcondition=db.isEmailUnique(bean.getEmail());
	if(checkcondition==0)
	{e.rejectValue("email", "email should be unique","email should be unique" );
	
	}
	 
	}
	
	catch(Exception exception)
	{ 
		exception.printStackTrace();
	}
		
		
	}

	
}
