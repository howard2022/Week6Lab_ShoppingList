<%-- 
    Document   : register
    Created on : 14-Feb-2023, 11:33:42 AM
    Author     : howard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form action="ShoppingList" method="post">
            Username: <input type="text" name="username">
            <input type="hidden" name="action" value="register">
            <br>
            <input type="submit" value="Register name">
            
                           
        </form>
            
          
    </body>
</html>
