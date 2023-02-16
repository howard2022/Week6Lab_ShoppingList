<%-- 
    Document   : shoppingList
    Created on : 14-Feb-2023, 11:42:51 AM
    Author     : howard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        Hello, ${username}
        <p><a href="ShoppingList?logout">Logout</a></p>
        <br>
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            Add item: <input type="text" name="addeditem"><input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="ShoppingList" method="post">
        <c:forEach items="${itemList}" var="item" varStatus="status">
            
            <input type="radio" name="itemSelected" value="${item}"> ${item}
            <br>
            
        </c:forEach>
                    
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
            
        </form>
        

    </body>
</html>
