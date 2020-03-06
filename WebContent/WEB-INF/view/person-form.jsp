<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
	<title>Save Person</title>
	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2> Address Book</h2>
		</div>
	</div>
	<div id="container">
		<h3> Save Person</h3>
		<form:form action="savePerson" modelAttribute="person" method="POST">
		<form:hidden path="id"/>	
			<table>
				<tbody>
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastname"/></td>
					</tr>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstname"/></td>
					</tr>
					
					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address"/></td>
					</tr>
					<tr>
						<td><label>Phone Number:</label></td>
						<td><form:input path="phone"/></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>			
			</table>
		</form:form>
		<div style="clear;both;">
		</div>
		<p>
			<a href="${pageContext.request.contextPath}/person/search?theSearchName=">Back to list</a>
		</p>	
	</div>
</body>
</html>