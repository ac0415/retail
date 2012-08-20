<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<form:form action="/admin/customer/save" method="POST" modelAttribute="customer" enctype="multipart/form-data">
	<table>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName"/></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><form:input path="address"/></td>
		</tr>
		<tr>
			<td>Birth Date</td>
			<td><form:input path="birthDate"/></td>
		</tr>
		<tr>
			<td>Contact Number:</td>
			<td><form:textarea path="contactNumber"/></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><input type="radio" name="gender" value="Male" /> Male</td>
			<td><input type="radio" name="gender" value="Female" /> Female</td>
		</tr>
	</table>
	<input type="submit" value="Submit"/>
</form:form>