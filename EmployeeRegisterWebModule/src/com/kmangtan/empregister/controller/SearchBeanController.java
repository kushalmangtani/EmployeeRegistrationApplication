package com.kmangtan.empregister.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kmangtan.empregister.entity.Emp;
import com.kmangtan.empregister.initialize.EjbInitialize;
import com.kmangtan.empregister.registerservice.EmployeeRegisterRemoteInterface;
import com.kmangtan.empregister.searchform.bean.SearchBean;


/*
 * Search Records logic is handled by this controller
 * 
 */

@Controller
@RequestMapping(value="/SearchBean")
public class SearchBeanController {
	
	/*
	 * Returns a model (list of Emp satisfying the search condition)
	 * 	and View (EmployeeList page)
	 */
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView Searchinfo(Model model,SearchBean searchBean)
	{
		ModelAndView mav=new ModelAndView();
		List<Emp> emplist=new ArrayList<Emp>();
		 
		
		EmployeeRegisterRemoteInterface db=null;
		
		try
		{
			db= (EmployeeRegisterRemoteInterface) EjbInitialize.getejb("EmailRegEJB");     // Reference to an EJb is made
		
		}
		catch (NamingException e) {
			e.getStackTrace();
		}

		emplist=db.searchEmployeeRecord(searchBean.getSearch_text(), searchBean.getSearch_using());
		mav.addObject("emplist",emplist);

		mav.setViewName("EmployeeList");
		
		return mav;
	}
	

}
