<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection"%>
<%@page import="javax.validation.constraints.Null"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.kmangtan.empregister.entity.Emp" %>
<%@ page import="com.kmangtan.empregister.entity.Contact" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.kmangtan.empregister.registerform.bean.EmpRegBean"  %>
   
    <%
       	List<Emp> beanlist = (List<Emp>)request.getAttribute("emplist");
       %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee list</title>

</head>
<body>

<h3> Employee List </h3>
<hr width="65%" align="left"/>
<br/>

<%
	if (beanlist.size() > 0 && beanlist!=null)
	{
%>
	
	<table border="1" cellspacing="0" width=65%>
	<tr>
	<th width="12%" align="center">FirstName</th><th align="center" width="12%">LastName</th><th align="center" width="15%">Email</th><th align="center" width="12%">Delete</th><th align="center" width="12%">View Details</th>
	</tr>
	
	<%
			for(Emp bean:beanlist)
			{
		%>
		<tr>
	<td align="center"><%=bean.getFirstname()%></td>
	<td align="center"><%=bean.getLastname()%></td>
	<td align="center"><%=bean.getEmail()%></td>
	
	<%
			int loop=0;
			String str="";
			Contact cont=new Contact();
			Collection<Contact>contact=bean.getContact();
			Iterator iter=contact.iterator();
			while(iter.hasNext())
			{
				loop++;
			   cont=(Contact)iter.next();
			  // str=cont.getPhoneno();
			  if(loop==1)
				  str=str+cont.getPhoneno();
			  else
				  
			   str=str+"<br/>"+cont.getPhoneno();
			   //System.out.println(str);
			   
			}
			
			//System.out.println(str);
		%>
	<td align="center">
	<a href="EmpReg?action=delete&id=<%= bean.getId() %>">   Delete    </a> 
	</td>
	
	<td align="center">
	<a href="EmpReg?action=view&id=<%= bean.getId() %>">   View    </a> 
	</td>
	

		</tr>
		
	<%  } %>
		
	</table>
	<% } 
	else  
	 { 
	
	%>
	<h2>No records found </h2>
   <% } %>
	
	
	
	<br/>
	
	<h3> Click <a href="EmpReg?action=change&id=0"> here </a> to add an Employee Record </h6>
</body>
</html>