<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=windows-1251">
<title>Products</title>
</head>
<body>
<h2>Words poisk</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<form method="post" action='<c:url value="/select" />' style="display:inline;">
<label>Word:</label><br>
<input name="poisk"/>
<input type="submit" value="Poisk" />
</form>
<table>
<tr><th>Word</th><th>Name file</th><th>Count</th></tr>
<c:forEach var="word" items="${word}">
 <tr><td>${word.name}</td>
    <td><a href="file:///${word.filesname}">${word.filesname}</a></td>
    <td>${word.countWord}</td>
    <td>
 </td></tr> 
</c:forEach>
</table>
<br>
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="submit" value="Delete">
        </form>
</body>
</html>