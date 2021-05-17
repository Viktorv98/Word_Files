<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<br>
<br>
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="submit" value="Delete">
        </form>
</body>
</html>