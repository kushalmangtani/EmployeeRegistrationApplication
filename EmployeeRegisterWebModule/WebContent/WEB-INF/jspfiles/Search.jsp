<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
<h3> Search for an Employee Record </h3>
<hr width="65%" align="left"/>
<br/>

<form:form modelAttribute="searchBean" method="POST" action="SearchBean">

<label> Search String </label>
<form:input type="text" name="search_text" path="search_text"></form:input>
<br/>


<label> Search using</label>
<form:select name="search_using" path="search_using">

<form:option  value="firstname" name="firstname" path="firstname"> Firstname</form:option>

<form:option value="lastname" name="lastname" path="lastname"> Lastname </form:option>
<form:option value="phoneno" name="phoneno" path="phoneno" >Phone no</form:option>
</form:select>

<br/>
<input type="submit">
</form:form>

</body>
</html>