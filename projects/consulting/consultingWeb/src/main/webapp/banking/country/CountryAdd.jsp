<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/Consulting/commonStyles.css" type="text/css">
<script src="/Consulting/jquery-2.0.2.js"></script>
<script src="/Consulting/commonScripts.js"></script>

<title>Country Add</title>
</head>
<body>
<form id="accountAdd" action="/Consulting/CommonController" method="post">
	<div class="addBox" >
	<div>
	<table>
	<tr>
		<th>
			Add Country 
		</th>
	</tr>
		<tr>
			<td  >Country Code</td><td><input type="text" name="countryCode" id="countryCode"></td>
		</tr>
		<tr>
			<td  >Country Name</td><td><input type="text" name="countryName" id="countryName"></td>
		</tr>
		<tr>
			<td  >Currency Code </td><td><input type="text" name="currencyCode" id="currencyCode"></td>
		</tr>
		<tr>
			<td>
				<input type="hidden" name="actionId" value="5" >
				<input type="hidden" name="module" value="BANKING" > 
				<input type="hidden" name="requestId" value="CountryAdd" >
				
			</td>
		</tr>
		<tr>
			<td><input type="submit" value="submit" ></td>	
		</tr>
		<tr>
		</tr>
	</table>
	</div>
	</div>
</form>

</body>
</html>