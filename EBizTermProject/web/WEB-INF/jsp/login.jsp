<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <h1>Login</h1>
        ${message}
        <s:form method="post" commandName="user" action="login.html">
            <table>
                <tr><td>Username:</td>
                    <td><s:input path="name"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><s:password path="password"/></td>
                </tr>
                <tr>
                    <td>Submit</td>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </s:form>

    </body>
</html>
