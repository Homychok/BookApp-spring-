<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<body>

<h1>Public Information</h1>
<br>
<br>
<security:authorize access="hasAnyRole('Employee', 'Security', 'Director')">
<input type="button" value="For employees"
       onclick="window.location.href = 'employee'">
Only for employees
</security:authorize>
<br>
<br>
<security:authorize access="hasAnyRole('IT', 'Security', 'Director')">
<input type="button" value="For IT stuff"
       onclick="window.location.href = 'it'">
Only for IT stuff
</security:authorize>
<br>
<br>
<security:authorize access="hasAnyRole('Security', 'Director')">
<input type="button" value="For security stuff"
       onclick="window.location.href = 'security'">
Only for security stuff
</security:authorize>
<br>
<br>

<security:authorize access="hasRole('Director')">
<input type="button" value="For director"
       onclick="window.location.href = 'director'">
Only for director
</security:authorize>

<br>
<br>
<input type="button" value="logout"
       onclick="window.location.href = '/login'">
<br>
<br>
</body>

</html>