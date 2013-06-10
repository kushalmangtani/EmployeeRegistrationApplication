<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.kmangtan.empregister.entity.Emp" %>
    <%@page import="com.kmangtan.empregister.entity.Contact" %>
    <%@page import="com.kmangtan.empregister.entity.Job" %>
    
    <%@page import="java.util.Iterator" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Employee Details </h3>
<hr width="65%" align="left"/>
<br/>

<%
	Emp employee=(Emp)request.getAttribute("empRegBean");
%>

<%="<b>First Name : </b>"+ employee.getFirstname()+"<br/>"%>
<%="<b>Middle Name:</b>"+ employee.getMiddlename()+"<br/>"%>
<%="<b>Last Name  :</b>"+ employee.getLastname()+"<br/>"%>
<br/>
<%="<b>Email      :</b>"+ employee.getEmail()+"<br/>"%>


<%
	String str="";
Collection<Contact> contact=employee.getContact();
	
	Iterator<Contact> iter=contact.iterator();
	while(iter.hasNext())
	{
		Contact cont=new Contact();
	   cont=(Contact)iter.next();
	  // str=cont.getPhoneno();
	   str=str+","+cont.getPhoneno();
	   
	}
%>

<%="<b>Phoneno   :</b>" +str+"<br/>"%>
<br/>
<%
	Job job=employee.getJob();
%>
<%= "<b>Location       : </b>"+job.getLocation()+"<br/>" %>
<%= "<b>Supervisor Name:</b>"+job.getSupervisor()+"<br/>" %>
<%= "<b>OfficeAddress  :</b>"+job.getOffice_address()+"<br/>" %>
<br/>
<h3>Click<a href="EmpReg">here </a>to see the List of Employees </h3>
</body>
</html>