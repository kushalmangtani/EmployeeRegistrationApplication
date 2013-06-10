<%@page import="com.kmangtan.empregister.entity.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Result</title>
</head>
<body>
<h3> Search Result</h3>
<hr width="65%" align="left"/>
<br/>


<%
	List<Emp> searchresults=(List<Emp>)request.getAttribute("list1");
%>

<h3>Click <a href="Search"> here  </a> to search for an Employee Record</h3>

</body>
</html>