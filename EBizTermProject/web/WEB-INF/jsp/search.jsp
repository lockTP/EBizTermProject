<%-- 
    Document   : search
    Created on : Apr 10, 2015, 1:48:54 PM
    Author     : linxiaohui
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<jsp:useBean id="userdao" scope="page" class="dao.UserDAO"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="<c:url value="/assets/css/customize.css"/>">
        <link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"/>">
        <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
        <script src="<c:url value="/assets/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/assets/js/validateChecker.js"/>"></script>
        <script src="<c:url value="/assets/js/jquery.js"/>"></script>
    </head>
    <body>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <div class="navbar-brand">
                    Job Hunter
                </div>
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
                    <span class="sr-only">Toggle Navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="#"></a>
            </div>

            <div class="collapse navbar-collapse" id="navbar-collapse">
                <ul class="nav navbar-nav">
                    <!-- Server Dropdown -->
                </ul>

                <!-- User Dropdown -->
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="post.html">Post</a></li>
                    <li class="active"><a href="">Search</a></li>
                    <li><a href="profile.html">Profile</a></li>
                    <li><a href="crawler.html">Crawler</a></li>
                    <li><a href="">Log out</a></li>
                </ul>

            </div>
        </div>
    </nav>
</body>
</html>
