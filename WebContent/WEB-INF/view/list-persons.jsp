<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<title>List Persons</title>
<link type="text/css" 
	rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>FPD - Fluffy Pink Directory</h2>
		</div>
	</div>
	<div id="container">
		<div id="content">
			<input type="button" value="Add Person"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button" /> 					
			<form:form action="search" method="GET">
				Search: <input type="text" name="theSearchName" /> <input type="submit" value="Search" class="add-button" />
			</form:form>			
			<table>
				<tr>
					<th>ID</th>
					<th>Last Name</th>
					<th>First Name</th>
					<th>Address</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempPerson" items="${persons}">
					<c:url var="updateLink" value="/person/showFormForUpdate">
						<c:param name="personId" value="${tempPerson.id}" />
					</c:url>
					<c:url var="deleteLink" value="/person/delete">
						<c:param name="personId" value="${tempPerson.id}" />
					</c:url>
					<tr>
						<td>${tempPerson.id}</td>
						<td>${tempPerson.lastname}</td>
						<td>${tempPerson.firstname}</td>
						<td>${tempPerson.address}</td>
						<td>${tempPerson.phone}</td>
							<td>
								<a href="${updateLink}">Update</a>
									|
								<a href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this person?'))) return false">Delete</a>
							</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>