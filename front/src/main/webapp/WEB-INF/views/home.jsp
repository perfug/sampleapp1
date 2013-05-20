<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<h1>API sample links</h1>
<p>
<ul>
<li><a href="transaction?countryCode=FRA&productId=1234&storeId=1234">/transaction?<b>countryCode</b>=FRA&amp;<b>productId</b>=1234&amp;<b>storeId</b>=1234</a></li>
<li><a href="transaction?countryCode=FRA&productId=1234&storeId=1234&txId=1">/transaction?<b>countryCode</b>=FRA&amp;<b>productId</b>=1234&amp;<b>storeId</b>=1234&amp;<b>txId</b>=1</a></li>
<li><a href="total?txId=1">/total?<b>txId</b>=1</a></li>
<li><a href="inventory?storeId=1234">/inventory?<b>storeId</b>=1234</a></li>
<li><a href="turnover?groupId=1">/turnover?<b>groupId</b>=1</a></li>
</ul>
<p>
<p> The time on the server is ${serverTime}.</p>
</body>
</html>
