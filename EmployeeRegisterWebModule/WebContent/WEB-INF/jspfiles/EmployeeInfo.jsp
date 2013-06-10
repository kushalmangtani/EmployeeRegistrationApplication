<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="org.springframework.context.annotation.Import"%>

<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>


<!--  % EmployeeBean emp=new EmployeeBean(); %-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
<style>
#submitButton
{
position:relative;
left:100px;
}
</style>
<script>

</script>

</head>
<body>


<h3> Employee Registration Form </h3>
<hr width="65%" align="left"/>
<br/>

<form:form modelAttribute="empRegBean" method ="POST" action="EmpReg">

<table border="0" cellspacing="0" width="65%">


<tr>
<th align="right" width="15%"><label>First Name</label> </th>
<td align="center" width="15%"><form:input  name="firstname" path="firstname"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="firstname" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Middle Name</label> </th>
<td align="center" width="15%"><form:input  name="middlename" path="middlename"/>
<td align="left" width="*"> <font color="red">  <form:errors path="middlename" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Last Name</label> </th>
<td align="center" width="15%"><form:input  name="lastname" path="lastname"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="lastname" cssErrorClass="error"/> </font></td>
</tr>

<tr>
<th>&nbsp; </th>
</tr>

<tr>
<th align="right" width="15%"><label>Email</label> </th>
<td align="center" width="15%"><form:input  name="email" path="email"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="email" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Phone No</label> </th>
<td align="center" width="15%"><form:input  name="phoneno" path="phoneno"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="phoneno" cssErrorClass="error"/> </font></td>
</tr>

<tr>
<th> &nbsp;</th>
</tr>

<tr>
<th align="right" width="15%"><label>Designation</label> </th>
<td align="center" width="15%"><form:input  name="job" path="job"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="job" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Supervisor Name(if any)</label> </th>
<td align="center" width="15%"><form:input  name="supervisor_reference" path="supervisor_reference"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="supervisor_reference" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th>&nbsp;</th>
</tr>

<tr>
<th align="right" width="15%"><label>Office Address</label> </th>
<td align="center" width="15%"><form:input  name="office_address" path="office_address"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="office_address" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Office Location</label> </th>
<td align="center" width="15%"><form:input  name="location" path="location"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="location" cssErrorClass="error"/> </font></td>
</tr>
<tr>
<th align="right" width="15%"><label>Office PhoneNo</label> </th>
<td align="center" width="15%"><form:input  name="office_phone" path="office_phone"/></td>
<td align="left" width="*"> <font color="red">  <form:errors path="office_phone" cssErrorClass="error"/> </font></td>
</tr>

</table>
<br/>
<input type="submit" value="Submit" id="submitButton" />
 
</form:form>
<br/>
<h3>Click<a href="EmpReg"> here </a> to see the List of Employees </h3>

</body>
</html>