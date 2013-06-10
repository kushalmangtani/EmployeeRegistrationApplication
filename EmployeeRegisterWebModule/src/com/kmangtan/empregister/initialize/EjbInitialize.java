/*
 * Binding and Lookup of Ejb's properties are implemented in this class 
 */

package com.kmangtan.empregister.initialize;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;


import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServlet;

public class EjbInitialize extends HttpServlet {
	
	private static final long serialVersionUID = 2292714369867123222L;

	/*
	 * Binding the properties file to a Hash Map
	 */

	private static Map<String,String> bind(){
		
	 Map<String, String> allejblist=new HashMap<String,String>();
		ResourceBundle rb=ResourceBundle.getBundle("com.kmangtan.empregister.initialize.Ejb");
		
	   Enumeration<String> keylist= rb.getKeys();
	   while(keylist.hasMoreElements())
	   {
		  String key= keylist.nextElement();
		  String value=rb.getString(key);
		  allejblist.put(key,value);
		 
		  
	   }
		
		return allejblist;
	}
	
/*
 * Lookup an EJB from the JNDI Initial Context
 */
	public static Object getejb(String str) throws NamingException
	{
		Object value;
		Map<String, String> allejblist2;
		
		allejblist2=EjbInitialize.bind();
		Properties p=new Properties();
		InitialContext ic=new InitialContext(p);	
		
	  value=ic.lookup(allejblist2.get(str));
	 
		return value;
	}
	
	public void HelloWorld()
	{
		System.out.println("Hello world!");
	}
	
	
	

}
